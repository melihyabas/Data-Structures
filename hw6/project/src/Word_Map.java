import java.util.*;

/***
 * Keeps words as keys and filemaps as values.
 */
public class Word_Map implements Map, Iterable
{

    Node head = null;
    Node last = null;

    private final Node deleted = new Node(null);
    final static int INITCAP=10;  //initial capacity
    final static float LOADFACT = 0.75f;  //max load factor
    private Node table[];
    private int keyNum;  //Number of existing keys (except deleted ones)
    private int deletedNum; // Number of deleted keys
    public Word_Map() {
        this.table = new Node[INITCAP];
    }

    @Override
    public Iterator iterator() {
        MyIterator itr = new MyIterator(this);
        return itr;
    }

    public class Node {
        // complete this class according to the given structure in homework definition
        public Node()
        {

        }
        public Node(Object x)
        {
            key=null;
            value=null;
            next=null;
        }

        public Node(Object k, Object v)
        {
            key = k;
            value = (File_Map) v;
            next = null;
        }
        public Node(Object k, Object v, Node n)
        {
            this.key = k;
            this.value = (File_Map) v;
            this.next = n;
        }
        public Object getValue()
        {
            return value;
        }
        public Object getKey()
        {
            return key;
        }
        public void setValue(Object val) {
            File_Map temp = new File_Map();
            temp = (File_Map)val;

            value.put(temp.fnames.get(0),temp.occurances.get(0));
        }
        Object key;
        File_Map value;
        Node next;
    }

    @Override
    public int size() {

        return keyNum;
    }

    @Override
    public boolean isEmpty() {

        return keyNum == 0;
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsKey(Object key) {

        if(get(key)==null)
            return false;

        return true;
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsValue(Object value)
    {
        Node itr = new Node();
        itr = head;

        while (itr!=null)
        {
            if(itr.getValue() == value)
                return true;

            itr = itr.next;
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int index = find(key);

        if(table[index]!=null)
            return table[index].getValue();

        else
             return null;
    }

    @Override
    /*
    Use linear probing in case of collision
    * */
    public Object put(Object key, Object value) {

        int index = find(key);

        if(table[index] == null)
        {
            table[index] = new Node(key,value,last);

            if(keyNum == 0)
            {
                head = table[index];
            }
            else
            {
                last.next = table[index];
            }
            last = table[index];
            last.next = null;
            keyNum++;

            double loadFac = (double) ((keyNum + deletedNum)) / table.length;

            if(loadFac > LOADFACT)
                rehash();

            return null;
        }

        Object old = table[index].getValue();
        table[index].setValue(value);
        return old;

    }

    @Override
    /*You do not need to implement remove function
     * */
    public Object remove(Object key) {
        return null;
    }


    @Override
    public void putAll(Map m) {
        if(m.isEmpty())
            return;


        Set temp = new HashSet();

        temp = (Set) m.entrySet();

        Object[] tempArr = new Object[temp.size()];

        tempArr = temp.toArray();
        Node[] arr = new Node[tempArr.length];


        for(int i=0 ; i<arr.length ; i++)
        {
            arr[i] = (Node) tempArr[i];
        }


        for(int i=0 ; i<arr.length ; i++)
        {
            put(arr[i].getKey(),arr[i].getValue());
        }
    }

    @Override
    public void clear() {
        table = new Node[table.length];
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Set keySet() {
        Set<Object> keys = new HashSet<Object>();

        Node itr = new Node();
        itr = head;

        while(itr!=null)
        {
            keys.add(itr.getKey());
            itr = itr.next;
        }
        return keys;
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Collection values() {
        Set<Object> val = new HashSet<Object>();

        Node itr = new Node();
        itr = head;

        while(itr!=null)
        {
            val.add(itr.getValue());
            itr = itr.next;
        }
        return val;
    }

    @Override
    /*You do not need to implement entrySet function
     * */
    public Set<Entry> entrySet()
    {
        Set entries = new HashSet();
        Node itr = head;

        while(itr!=null)
        {
            entries.add(itr);
            itr = ((Node) itr).next;
        }

        return entries;
    }

    private int find(Object key)
    {
        int i = key.hashCode() % table.length;

        if(i<0)
            i += table.length;
        while (table[i]!=null && !key.equals(table[i].getKey()))
        {
            i++;
            if(i>=table.length)
                i=0;
        }
        return i;
    }

    private void rehash()
    {
        Node[] old = table;

        table = new Node[2*old.length+1];

        keyNum = 0;
        deletedNum = 0;

        Node itr = new Node();
        itr = head;

        for(; itr!=null&&itr!=deleted ; )
        {
            put(itr.getKey(),itr.getValue());
            itr = itr.next;
        }
    }
    public Node[] getTable()
    {
        return table;
    }
}
