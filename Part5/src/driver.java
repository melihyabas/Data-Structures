/***
 * This is a driver class to test all the other methods of classes
 */
public class driver
{
    /***
     * main method of program
     * @param args
     */
    public static void main(String[] args)
    {
        int i, j;
        int[][] data = new int[5][5];

        int x = 1;
        for (i = 0; i < data.length; i++)
        {
            for (j = 0; j < data[i].length; j++)
            {
                data[i][j] = x;
                x++;
            }
        }


        System.out.printf("Two dimensional array:\n");
        for (i = 0; i < data.length; i++)
        {
            for (j = 0; j < data[i].length; j++)
            {
               System.out.printf("%s ", data[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");

        MyIterator obj = new MyIterator(data);

        System.out.println("");

        System.out.printf("Test of hasNext and Next methods\n");
        while (obj.hasNext())
          System.out.printf("%s ",obj.next());

        System.out.println("");

        System.out.printf("\nTest of printSpiral method:(It just prints all the element that I recursively determine.)\n");
        obj.printSpiral(0);
    }

}
