/***
 * This is an ArrayList data structure. It keeps values on an array. If it is necessary it icrease the array.
 */
public class MyArrayList{

    int[] data;
    int index = 0;

    /***
     * No parameter constructure
     */
    public MyArrayList()
    {
        data = new int[8];
    }

    /***
     * Adds an element to the list.
     * @param x Element
     */
    public void add(int x)
    {
        if(data.length-index<4)
            increase();
        data[index++] = x;
    }

    /***
     * Increase the size of array.
     */
    public void increase()
    {
        int[] temp = new int[index*2];
        for(int i=0 ; i<data.length ; i++)
            temp[i] = data[i];

        data = temp;
    }

    /***
     * Gives the value of the given index.
     * @param ix index
     * @return value
     */
    public int get(int ix)
    {
        if(ix<0 || ix>=index)
        {
            System.out.printf("\nHERE?\n");
            throw new ArrayIndexOutOfBoundsException();
        }
        return (data[ix]);
    }

    /***
     * Returns the current index
     * @return current index
     */
    public int getIndex()
    {
        return index;
    }

    /***
     * Returns the current size.
     * @return size.
     */
    public  int getSize()
    {
        return data.length;
    }
}
