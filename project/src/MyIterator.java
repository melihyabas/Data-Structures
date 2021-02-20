import java.util.ArrayList;
import java.util.Iterator;

/**
 * An iterator class that implements Iterator
 */
public class MyIterator implements Iterator {
    public MyArrayList e;
    int index;
    /**
     * Constructors
     * @param obj
     */

    public  MyIterator(MyArrayList obj)
    {
        e = new MyArrayList();
        e = obj;
    }

    /**
     * If this list has a next value, returns true
     * @return a boolean value
     */
    public boolean hasNext()
    {
        if(e.get(index+1) == null)
            return false;
        else
            return true;
    }

    /**
     * Returns next element of the list
     * @return next element
     * @throws NullPointerException
     */
    public Object next()throws NullPointerException
    {
        if(hasNext())
            return e.get(index+1);
        else
            throw new NullPointerException();
    }

}
