
import java.util.List;
import java.util.*;
import java.io.*;

/***
 * This class coordinates some Natural Language Processesing Operations
 */
public class NLP
{
    public Word_Map wmap;

    /*You should not use File_Map class in this file since only word hash map is aware of it.
    In fact, you can define the File_Map class as a nested class in Word_Map,
     but for easy evaluation we defined it separately.
     If you need to access the File_Map instances, write wrapper methods in Word_Map class.
    * */

    /*Reads the dataset from the given dir and created a word map */

    /***
     *
     * Reads all the files and words. Keep them in the HashMaps.
     * @param dir path of dataset directiory
     */
    public void readDataset(String dir)
    {
        try {
            File folder = new File(dir);
            File[] listOfFiles = folder.listFiles();


            wmap = new Word_Map();

            int ac=0, coord=0;
            for (File file : listOfFiles) {
                if (file.isFile()) {

                    file = new File(dir + file.getName());

                    Scanner input = new Scanner(file);

                    while (input.hasNext())
                    {
                        coord++;
                        String word = input.next();
                        word = word.trim().replaceAll("\\p{Punct}", "");

                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(coord);
                        File_Map fmap = new File_Map();

                        fmap.put(file.getName(),temp);
                        wmap.put(word, fmap);
                    }
                    coord = 0;


                }
            }

        }
        catch (Exception e)
        {

        }
    }

    /*Finds all the bigrams starting with the given word*/

    /***
     * Finds all the bigrams of given word
     * @param word
     * @return bigram list
     */
    public List<String> bigrams(String word){


        wmap = new Word_Map();
        Word_Map.Node itr = wmap.new Node();
        Word_Map.Node itr2 = wmap.new Node();

        readDataset("dataset/");

        itr = wmap.head;
        itr2 = itr.next;

        File_Map maFM = new File_Map();
        maFM = (File_Map) wmap.get(word);
        ArrayList<String> bigram = new ArrayList<>();


        while(itr!=null)
        {
            if(!itr.equals(word))
            {
                File_Map fmTemp = new File_Map();
                fmTemp = (File_Map)itr.getValue();
                for(int i=0 ; i<maFM.size() ; i++)
                {
                    for (int j=0 ; j<fmTemp.size() ; j++)
                    {
                        if(maFM.fnames.get(i).equals(fmTemp.fnames.get(j)))
                        {
                            for(int k=0 ; k<maFM.occurances.get(i).size() ; k++)
                            {
                                for(int l=0 ; l<fmTemp.occurances.get(j).size() ; l++)
                                {
                                    if(maFM.occurances.get(i).get(k)+1 == fmTemp.occurances.get(j).get(l))
                                    {

                                        String tempStr = "";
                                        tempStr += word;
                                        tempStr += " ";
                                        tempStr += itr.getKey();
                                        if(!bigram.contains(tempStr))
                                              bigram.add(tempStr);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            itr = itr.next;
        }

        return  bigram;
    }


    /*Calculates the tfIDF value of the given word for the given file */

    /***
     * Calculates tFIDf value using wmap object
     * @param word
     * @param fileName
     * @return list of biwords
     */
    public float tfIDF(String word, String fileName)
    {
        int myW=0, numOfW=0;
        float TF, IDF;
        wmap = new Word_Map();
        Word_Map.Node itr = wmap.new Node();
        readDataset("dataset/");

        itr = wmap.head;
        while (itr!=null)
        {
            if(itr.getKey().equals(word))
            {
                File_Map ftemp = new File_Map();

                ftemp = (File_Map) itr.getValue();

                for(int i=0 ; i<ftemp.size() ; i++)
                {
                    if(ftemp.fnames.get(i).equals(fileName))
                    {
                        myW += ftemp.occurances.get(i).size();
                    }

                }
            }

            File_Map tempFm = new File_Map();
            tempFm = (File_Map) itr.getValue();
            for(int i=0 ; i<tempFm.size() ; i++)
            {
                if(tempFm.fnames.get(i).equals(fileName))
                    numOfW += tempFm.occurances.get(i).size();
            }
            itr = itr.next;
        }

        TF = (float) myW/(float) numOfW;

        Set<String> allDoc = new HashSet();
        Set<String> myDoc = new HashSet<>();


        itr = wmap.head;
        while (itr!=null)
        {
            if(itr.getKey().equals(word))
            {
                File_Map ftemp = new File_Map();

                ftemp = (File_Map) itr.getValue();

                for(int i=0 ; i<ftemp.size() ; i++)
                {
                    myDoc.add(ftemp.fnames.get(i));
                }
            }

            File_Map tempFm = new File_Map();
            tempFm = (File_Map) itr.getValue();
            for(int i=0 ; i<tempFm.size() ; i++)
            {
                allDoc.add(tempFm.fnames.get(i));
            }
            itr = itr.next;
        }

        IDF = (float) Math.log((double) allDoc.size()/(double)myDoc.size());

        float TFIDF = TF * IDF;

        return TFIDF;
    }

    /*Print the WordMap by using its iterator*/

    /***
     * Prints all the data structures.
     */
    public  void printWordMap()
    {

        wmap = new Word_Map();
        readDataset("dataset/");

        System.out.println(wmap.size());
        Iterator itr =  wmap.iterator();

        while (itr.hasNext())
        {
            Word_Map.Node word = (Word_Map.Node) itr.next();
            System.out.println("Key of Word_Map:"+word.getKey());

            File_Map f = new File_Map();
            f = (File_Map) word.getValue();
            System.out.println("Value of Word_Map:");
            System.out.println("");
            for(int i=0 ; i<f.fnames.size() ; i++)
            {
                System.out.println("Key of File_Map");
                System.out.println(f.fnames.get(i));
                System.out.println("Value of File_Map");
                System.out.println(f.occurances.get(i));
            }
            System.out.printf("\n\n");
            System.out.println("---------------------------");
        }

    }

}
