
import java.util.*;

/***
 * Priority queue adds and removes elements but its difference is it base a comparator to do this.
 * @param <Pixel> Represents 1 pixel's values.
 */
public class MyPriorityQueue<Pixel> extends AbstractQueue<Pixel> implements  Queue<Pixel>{
    private MyArrayList<Pixel> data = new MyArrayList();
    Comparator<Pixel> comparator = null;
/*
    ArrayList<Pixel> getQueue()
    {
        return data;
    }*/

    /***
     * iterator method
     * @return
     */
    public Iterator<Pixel> iterator()
    {
        return data.iterator();
    }

    /***
     * A constructor to start this queue
     * @param comp Comparator that priority queue's needed.
     */
    public MyPriorityQueue(Comparator<Pixel> comp)
    {
        comparator = comp;
    }

    /***
     * Takes an element and adds it priority queue as the comparator.
     * @param item Element to add.
     * @return true if operation is successful.
     */
    public synchronized boolean offer(Pixel item)
    {


        data.add(item);
        int child = data.size()-1;
        int parent = (child-1)/2;

        while(parent>=0 && compare(data.get(parent),data.get(child))>0)
        {
            swap(parent,child);
            child = parent;
            parent = (child-1)/2;

        }
        try{
            notifyAll();
        }
        catch(Exception e)
        {

        }
        return true;
    }

    /***
     * Removes the top element of queue
     * @return Removed element.
     */
    public synchronized Pixel poll()
    {
        if (isEmpty())
        {
            try
            {
                wait();
            }
            catch(Exception e)
            {

            }
            return null;
        }
        Pixel result = data.get(0); //save the top element

        if(data.size()==1) {
            data.remove(0);
            return result;
        }

         /* Remove the last item from the ArrayList and place it into
        the first position. */


        Pixel rmv = data.remove(data.size()-1);
        data.set(0,rmv);
        int parent = 0;
        for( ; ;) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= data.size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
            // See whether rightChild is smaller.
            if (rightChild < data.size() && compare(data.get(leftChild), data.get(rightChild)) > 0)
            {
                minChild = rightChild;
            }
            // assert: minChild is the index of the smaller child.
            // Move smaller child up heap if necessary.
            if (compare(data.get(parent), data.get(minChild)) > 0)
            {
                swap(parent, minChild);
                parent = minChild;
            } else { // Heap property is restored.
                break;
            }
        }
        return result;
    }

    /***
     * Returns the top element of the queue.
     * @return
     */
    public synchronized Pixel peek()
    {
        if(isEmpty())
        {
            try {
                wait();
            }
            catch (Exception e)
            {

            }
        }
        return data.get(0);
    }

    /***
     * Swaps 2 object of queue
     * @param first element 1
     * @param second element 2
     */
    private void swap(int first, int second)
    {
        Pixel temp;
        temp = data.get(first);
        data.set(first,data.get(second));
        data.set(second,temp);
    }

    /***
     * Compare method to implement the comparation.
     * @param first element 1
     * @param second element 2
     * @return
     */
    private int compare(Pixel first, Pixel second)
    {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(first, second);
        } else { // Use left's compareTo method.
            return ((Comparable<Pixel>) first).compareTo(second);
        }
    }

    /***
     *
     * @return size of queue
     */
    public int size()
    {
        return data.size();
    }

    /***
     * Returns true if queue is empty
     * @return
     */
    public boolean isEmpty()
    {
        return (size()==0);
    }
}
