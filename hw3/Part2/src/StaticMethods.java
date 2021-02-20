/***
 * This class calculates some Math methods.
 */
public class StaticMethods {
    /***
     * Calculates sinus function using taylor.
     * @param x degree
     * @return value of this degree
     */
    public static double sinus(double x)
    {
        double PI = 3.141592;
        int again = 10;
        x = x * PI / 180;


        double result=0;

        int i;

        for (i=0;i<again;i++)

        {

            result += powN(-1,i) * powN(x,2*i+1) / factorial(2*i+1);
        }

        return result;

    }

    /**
     * Calculates cosinus function using sinus function.
     * @param x degree
     * @return value of this degree
     */
    public static double cosinus(double x)
    {
        return (sinus(90-x));
    }

    /***
     * If the value of negative, this method makes it positive.
     * @param x value
     * @return positive value of this value
     */
    public static double abs(double x)
    {
        if(x<0)
            return -x;
        else
            return x;
    }

    /***
     * Takes a number and calculates its factorial
     * @param number
     * @return
     */
    public static int factorial(int number)

    {

        int result=1;

        int i;

        for(i=1;i<=number;++i)

        {

            result*=i;

        }

        return result;

    }

    /***
     * Takes 2 number and calculates a power function.
     * @param number
     * @param pw
     * @return
     */
    public static double powN(double number,int pw)
    {

        double result=1;
        int i;

        for (i=1;i<=pw;i++)

        {

            result*=number;

        }
        return result;

    }
}

