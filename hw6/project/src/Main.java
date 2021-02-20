
import java.util.*;
import java.io.*;

/***
 * Main class of program.
 * Tests all the methods.
 */
public class Main {
    public static void main(String args[]) {

        try {

            NLP nobj = new NLP();

            if(false/*If you want to test printWordMap method, please do it 'true'*/)
                nobj.printWordMap();



            File file = new File("input.txt");
            Scanner itr = new Scanner(file);

            while (itr.hasNext())
            {
                String word = itr.next();
                String fname = word;
                if(word.equals("bigram"))
                {
                    word = itr.next();

                    System.out.println(nobj.bigrams(word));
                    System.out.println("");
                }
                else if(word.equals("tfidf"))
                {
                    word = itr.next();
                    fname = itr.next();
                    System.out.println(nobj.tfIDF(word,fname));
                    System.out.println("");
                }
            }

        }
        catch (Exception e)
        {

        }

    }
}
