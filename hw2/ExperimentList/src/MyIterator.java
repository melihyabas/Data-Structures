import java.util.Iterator;

/**
 * An iterator class that implements Iterator
 */
public class MyIterator implements Iterator {
    public ExperimentNode e;

    /**
     * Constructors
     * @param obj
     */
    public MyIterator(ExperimentList obj)
    {
        e = obj.head;
    }
    public  MyIterator(ExperimentNode obj)
    {
        e = new ExperimentNode();
        e = obj;
    }

    /**
     * If this list has a next value, returns true
     * @return a boolean value
     */
     public boolean hasNext()
    {
        if(e.next == null)
            return false;
        else
            return true;
    }

    /**
     * Returns next element of the list
     * @return next element
     * @throws NullPointerException
     */
     public ExperimentNode next()throws NullPointerException
    {
        if(hasNext())
            return e.next;
        else
            throw new NullPointerException();
    }

}
