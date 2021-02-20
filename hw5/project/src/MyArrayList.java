import java.util.Arrays;
import java.util.Iterator;

/***
 * This is an Arraylist.
 * Its main purposse is keeping the variables and their values
 */
public class MyArrayList<E>
{
    E[] var;
    int size = 0;

    /***
     * This is a no parameter constructor.
     */
    public MyArrayList()
    {

        var = (E[]) new Object[8];
    }

    /**
     * This adds the variable to the variable array.
     * @param variable This is a variable.
     */
    public void add(E variable)
    {
        if(var.length - size <= 5)
            increase();
        var[size++] = variable;
    }

    /***
     * This adds the variable to the end of value array.
     * @param value This is a value.
     */

    /***
     * This method increase the arrays sizes if it is necessary.
     */
    public void increase()
    {
        var = Arrays.copyOf(var,var.length*2);
    }

    /***
     * This method gives the specified position variable.
     * @param index Location of variable.
     * @return Variable that we need.
     * @throws ArrayIndexOutOfBoundsException
     */
    public E get(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < size)
            return (var[index]);
        else
            throw new  ArrayIndexOutOfBoundsException();
    }

    public E remove(int index){
        if(index < size){
            E obj = var[index];
            var[index] = null;
            int tmp = index;
            while(tmp < size){
                var[tmp] = var[tmp+1];
                var[tmp+1] = null;
                tmp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }
    public int size()
    {
        return size;
    }
    public Iterator iterator()
    {
        return new MyIterator(this);
    }
    public void set(int i, E obj)
    {
        var[i] = obj;
    }
    /***
     * This method gives the specified position value.
     * @param index Location of value.
     * @return Value that we need.
     * @throws ArrayIndexOutOfBoundsException
     */

}
