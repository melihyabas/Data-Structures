import java.util.Iterator;

/***
 * An iterator for the Word_Map class
 */
public class MyIterator implements Iterator {

    Word_Map.Node[] mapObj;
    Word_Map.Node itr;
    public MyIterator()
    {

    }
    public MyIterator(Word_Map obj)
    {
        mapObj = obj.getTable();
        itr = obj.head;
    }
    public boolean hasNext()
    {
        return (itr.next!=null);
    }

    public Object next()
    {
        if(hasNext())
        {
            Word_Map.Node temp = itr;
            itr = itr.next;
            return (temp);
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
