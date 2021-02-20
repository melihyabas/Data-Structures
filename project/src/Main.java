import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/***
 * Main class creates threads and tests all methods in the program.
 */
public class Main {
    /***
     *  main method of program.
     * @param args String argument.
     */
    public static void main(String[] args)
    {

        try
        {
            BufferedImage image;

            File input = new File(args[0]);
            image = ImageIO.read(input);

            int width = image.getWidth();
            int height = image.getHeight();

            Pixel[][] pix = new Pixel[width][height];

            int i,j;
            for(i=0 ; i<pix.length ; i++)
            {
                for(j=0 ; j<pix[0].length ; j++)
                {
                    Color c = new Color(image.getRGB(i,j));
                    pix[i][j] = new Pixel(c.getRed(),c.getGreen(),c.getBlue());
                }
            }

            LexComp lex = new LexComp();
            MyPriorityQueue<Pixel> PQLEX = new MyPriorityQueue(lex);

            EucComp euc = new EucComp();
            MyPriorityQueue<Pixel> PQEUC = new MyPriorityQueue(euc);

            BmxComp bmx = new BmxComp();
            MyPriorityQueue<Pixel> PQBMX = new MyPriorityQueue(bmx);

            Thread thr2 = new Thread(new Runnable()
            {
                public void run()
                {
                    for(int i=0 ; i<pix.length ; i++) {
                        for (int j = 0; j < pix[0].length; j++) {
                            System.out.printf("Thread2-PQLEX: [%s, %s, %s]\n", PQLEX.peek().getRed(), PQLEX.peek().getGreen(), PQLEX.peek().getBlue());
                            PQLEX.poll();
                        }
                    }
                }
            });

            Thread thr3 = new Thread(new Runnable()
            {
                public void run()
                {
                    for(int i=0 ; i<pix.length ; i++) {
                        for (int j = 0; j < pix[0].length; j++) {
                            System.out.printf("Thread3-PQEUC: [%s, %s, %s]\n", PQEUC.peek().getRed(), PQEUC.peek().getGreen(), PQEUC.peek().getBlue());
                            PQEUC.poll();
                        }
                    }
                }
            });
            Thread thr4 = new Thread(new Runnable()
            {
                public void run()
                {
                    for(int i=0 ; i<pix.length ; i++) {
                        for (int j = 0; j < pix[0].length; j++) {
                            System.out.printf("Thread4-PQBMX: [%s, %s, %s]\n", PQBMX.peek().getRed(), PQBMX.peek().getGreen(), PQBMX.peek().getBlue());
                            PQBMX.poll();
                        }
                    }
                }
            });
            Thread thr = new Thread(new Runnable()
            {
                int per=0;
                public void run(){
                    for(int i=0 ; i<pix.length ; i++)
                    {
                        for (int j = 0; j < pix[0].length ; j++)
                        {
                            System.out.printf("Thread1: [%s, %s, %s]\n",pix[i][j].getRed(),pix[i][j].getGreen(),pix[i][j].getBlue());

                            PQLEX.offer(pix[i][j]);
                            PQEUC.offer(pix[i][j]);
                            PQBMX.offer(pix[i][j]);
                            per++;
                            if(per==100){
                                thr2.start();
                                thr3.start();
                                thr4.start();

                            }
                        }
                    }
                }
            });

            thr.start();

        }
        catch (Exception e)
        {
            System.out.printf("\nException has been thrown: %s\n",e);
        }
    }
}
