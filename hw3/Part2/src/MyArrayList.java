import java.util.Arrays;

/***
 * This is an Arraylist.
 * Its main purposse is keeping the variables and their values
 */
public class MyArrayList
{
    char[] var;
    String[] val;
    int sizeVar = 0;
    int sizeVal = 0;

    /***
     * This is a no parameter constructor.
     */
    public MyArrayList()
    {
        var = new char[8];
        val = new String[8];
    }

    /**
     * This adds the variable to the variable array.
     * @param variable This is a variable.
     */
    public void addVar(char variable)
    {
        if(var.length - sizeVar < 5)
            increase();
        var[sizeVar] = variable;
        sizeVar++;
    }

    /***
     * This adds the variable to the end of value array.
     * @param value This is a value.
     */
    public void addVal(String value)
    {
        if(val.length - sizeVal < 5)
            increase();
        val[sizeVal] = value;
        sizeVal++;

    }

    /***
     * This method increase the arrays sizes if it is necessary.
     */
    public void increase()
    {
        System.out.printf("SSS\n");
        var = Arrays.copyOf(var,var.length*2);
        val = Arrays.copyOf(val,val.length*2);

    }

    /***
     * This method gives the specified position variable.
     * @param index Location of variable.
     * @return Variable that we need.
     * @throws ArrayIndexOutOfBoundsException
     */
    public char getVar(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < sizeVar)
            return (var[index]);
        else
            throw new  ArrayIndexOutOfBoundsException();
    }

    /***
     * This method gives the specified position value.
     * @param index Location of value.
     * @return Value that we need.
     * @throws ArrayIndexOutOfBoundsException
     */
    public String getVal(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < sizeVal)
            return (val[index]);
        else
            throw new  ArrayIndexOutOfBoundsException();
    }
}
