import java.util.*;

/***
 * Keeps File Names and the coordinates of words.
 */
public class File_Map implements Map
{
    public class Pair
    {
        public Pair(String k, List v)
        {
            keyy = k;
            valuee = v;
        }
        private String keyy;
        private List valuee;
    }
    /*
    For this hashmap, you will use arraylists which will provide easy but costly implementation.
    Your should provide and explain the complexities for each method in your report.
    * */
    ArrayList<String> fnames = new ArrayList<>();
    ArrayList<List<Integer>> occurances = new ArrayList<>();

    @Override
    public int size() {

        return fnames.size();
    }

    @Override
    public boolean isEmpty()
    {
        return fnames.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for(int i=0 ; i<fnames.size() ; i++)
            if(fnames.get(i) == key)
                return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0 ; i<occurances.size() ; i++)
            if(occurances.get(i) == value)
                return true;
        return false;
    }

    @Override
    public Object get(Object key) {

        if (!fnames.contains(key))
            return null;

        return occurances.get(fnames.indexOf(key));

    }


    @Override
    /*Each put operation will extend the occurance list*/
    public Object put(Object key, Object value)
    {

        Object res = get(key);

        if(fnames.contains(key)==false)
        {
            fnames.add((String) key);
            occurances.add((ArrayList<Integer>) value);
        }
        else
        {
            List<Integer> temp = new ArrayList<>();

            temp = occurances.get(fnames.indexOf(key));
            temp.addAll((List<Integer>)value);
            occurances.set(fnames.indexOf(key),temp);

        }

        return res;
    }

    @Override
    public Object remove(Object key)
    {
        ArrayList<String> tempfnames = new ArrayList<>();
        ArrayList<List<Integer>> tempOcc = new ArrayList<>();

        for(int i=0 ; i<tempfnames.size() ; i++)
        {
            if(!fnames.get(i).equals(key))
            {
                tempfnames.add(fnames.get(i));
            }
            if(!occurances.get(i).equals(get(key)))
            {
                tempOcc.add(occurances.get(i));
            }
        }

        fnames = tempfnames;
        occurances = tempOcc;

        Pair dlt = new Pair((String) key,(List)get(key));

        return dlt;
    }

    @Override
    public void putAll(Map m) {
        if(m.isEmpty())
            return;

        Set temp = new HashSet();

        temp = (Set) m.entrySet();

        Object[] tempArr = new Object[temp.size()];

        tempArr = temp.toArray();
        Pair[] arr = new Pair[tempArr.length];


        for(int i=0 ; i<arr.length ; i++)
        {
            arr[i] = (Pair)tempArr[i];
        }


        for(int i=0 ; i<arr.length ; i++)
        {
            put(arr[i].keyy,arr[i].valuee);

        }
    }

    @Override
    public void clear() {
        fnames.clear();
    }

    @Override
    public Set keySet() {
        Set<Object> keys = new HashSet<Object>();

        keys.addAll(fnames);

        return keys;

    }

    @Override
    public Collection values() {
        ArrayList<Object> values = new ArrayList<>();

        values.addAll(occurances);


        return values;

    }

    @Override
    public Set entrySet() {
        Set entries = new HashSet();

        for(int i=0 ; i<fnames.size() ; i++)
        {
            entries.add(new Pair(fnames.get(i),occurances.get(i)));
        }

        return entries;
    }
}
