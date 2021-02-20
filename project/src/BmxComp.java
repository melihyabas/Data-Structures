import java.util.Comparator;

/***
 * This is a comparator and it takes bitmix as a base to compare 2 objects.
 */
public class BmxComp implements Comparator<Pixel> {
    /***
     *
     * @param o1 object1
     * @param o2 object2
     * @return returns 1 if object1's bitmix value is smaller.
     */
    public int compare(Pixel o1, Pixel o2) {
        double h1=0, h2=0;

        int[] tempArr = new int[8];
        int[][] arrBin = new int[3][8];

        int v1Comp1 = o1.getRed();
        int i = 0;
        while (v1Comp1 / 2 != 0) {
            tempArr[i] = v1Comp1%2;
            v1Comp1/=2;
            i++;
        }
        tempArr[i] = v1Comp1;
        if(i<7)
        {
            for(int k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        int k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[0][i] = tempArr[k];
            k--;
        }



        int v1Comp2 = o1.getGreen();
        i = 0;
        while (v1Comp2 / 2 != 0) {
            tempArr[i] = v1Comp2%2;
            v1Comp2/=2;
            i++;
        }
        tempArr[i] = v1Comp2;
        if(i<7)
        {
            for( k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[1][i] = tempArr[k];
            k--;
        }



        int v1Comp3 = o1.getBlue();
        i = 0;
        while (v1Comp3 / 2 != 0) {
            tempArr[i] = v1Comp3%2;
            v1Comp3/=2;
            i++;

        }
        tempArr[i] = v1Comp3;
        if(i<7)
        {
            for(k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[2][i] = tempArr[k];
            k--;
        }


        for (int j = 0 ; j<8 ; j++)
        {
            for (i = 0; i < 3; i++)
            {
                h1 += Math.pow(2, 3 * (8 - (j + 1))) * Math.pow(2, 3 - (i + 1)) * arrBin[i][j];
            }
        }


   // ------------------------------------------------------------------------------



         v1Comp1 = o2.getRed();
        i = 0;
        while (v1Comp1 / 2 != 0) {
            tempArr[i] = v1Comp1%2;
            v1Comp1/=2;
            i++;
        }
        tempArr[i] = v1Comp1;
        if(i<7)
        {
            for( k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[0][i] = tempArr[k];
            k--;
        }



        v1Comp2 = o2.getGreen();
        i = 0;
        while (v1Comp2 / 2 != 0) {
            tempArr[i] = v1Comp2%2;
            v1Comp2/=2;
            i++;
        }
        tempArr[i] = v1Comp2;
        if(i<7)
        {
            for( k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[1][i] = tempArr[k];
            k--;
        }



        v1Comp3 = o2.getBlue();
        i = 0;
        while (v1Comp3 / 2 != 0) {
            tempArr[i] = v1Comp3%2;
            v1Comp3/=2;
            i++;

        }
        tempArr[i] = v1Comp3;
        if(i<7)
        {
            for( k=i+1 ; k<8 ; k++)
            {
                tempArr[k] = 0;
            }
        }
        k = 7;
        for(i=0 ; i<tempArr.length ; i++)
        {
            arrBin[2][i] = tempArr[k];
            k--;
        }


        for (int j = 0 ; j<8 ; j++)
        {
            for (i = 0; i < 3; i++)
            {
                h2 += Math.pow(2, 3 * (8 - (j + 1))) * Math.pow(2, 3 - (i + 1)) * arrBin[i][j];

            }
        }


        if(h1<h2) {

            return 1;
        }

        else
            return -1;
    }
}