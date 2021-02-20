import java.nio.file.*;

/***
 * This is the first driver class and it solves the part1's problem.
 */
public class Driver {
    /***
     * Main method tests all the methods of classes.
     * @param args It is a command line argument
     */
    public static void main(String[] args) {

        String data;

        MyStack island = new MyStack();

        try {
            data = new String(Files.readAllBytes(Paths.get(args[0])));
            char[] a = data.toCharArray();

            int i, j,k, line=0, col=0;
            i=0;
            while (a[i]!='\n')
            {
                if(a[i]=='0' || a[i]=='1')
                    line++;
                i++;
            }

            i=0;
            while (i<a.length)
            {
                if (a[i] == '\n')
                    col++;
                i++;
            }
            col++;

            char[][] matrix = new char[col][line];



            i=0;
            j=0;
            k=0;
            while (i<col)
            {
                j=0;
                while (j<line)
                {
                    if(a[k] == '1' || a[k] == '0')
                    {
                        matrix[i][j]=a[k];
                        j++;
                    }
                    k++;
                }
                i++;
            }

            int islandCount = 0;

            for(i=0 ; i<col ; i++)
            {
                for(j=0 ; j<line ; j++)
                {
                    if(matrix[i][j]=='1')
                    {
                        matrix[i][j]='X';

                        if(i+1<col && matrix[i+1][j] == '1')
                        {
                            Points p1 = new Points(i+1,j);
                            island.push(p1);
                        }

                        if(j+1<line && matrix[i][j+1] == '1')
                        {
                            Points p2 = new Points(i,j+1);
                            island.push(p2);
                        }

                        if(i>0 && matrix[i-1][j] == '1')
                        {
                            Points p3 = new Points(i-1,j);
                            island.push(p3);
                        }

                        if(j>0 && matrix[i][j-1] == '1')
                        {
                            Points p4 = new Points(i,j-1);
                            island.push(p4);
                        }
                        if(island.empty())
                            islandCount++;
                        else
                        {
                            while (!(island.empty()))
                            {
                                int x1 = island.peek().x, y1 = island.peek().y;
                                matrix[x1][y1] = 'X';
                                island.pop();

                                if(x1+1<col && matrix[x1+1][y1] == '1')
                                {
                                    Points pt1 = new Points(x1+1,y1);
                                    island.push(pt1);
                                }

                                if(y1+1<line && matrix[x1][y1+1] == '1')
                                {
                                    Points pt2 = new Points(x1,y1+1);
                                    island.push(pt2);
                                }

                                if(x1>0 && matrix[x1-1][y1] == '1')
                                {
                                    Points pt3 = new Points(x1-1,y1);
                                    island.push(pt3);
                                }

                                if(y1>0 && matrix[x1][y1-1] == '1')
                                {
                                    Points pt4 = new Points(x1,y1-1);
                                    island.push(pt4);
                                }
                            }
                            if(island.empty())
                                islandCount++;
                        }

                    }
                }
            }

            System.out.printf("\nThere are %d island.\n",islandCount);

        }
        catch (Exception e)
        {
            System.out.printf("\nException: "+e);
        }

    }
}

