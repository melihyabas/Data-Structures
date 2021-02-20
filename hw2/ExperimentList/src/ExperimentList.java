import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ExperimentList Class keeps an head to create list. It has all methods to arrange the list.
 */
public class ExperimentList implements Iterable{
    ExperimentNode head;

    /**It is an overriding method of Iterable
     *
     * @return an iterator
     */
    public Iterator iterator()
    {
        return new MyIterator(this);
    }

    /**
     * Lists all the experiments in the given day
     * @param d day of experiments that we see
     */
    public void listExp(int d)
    {
        MyIterator itr = new MyIterator(head);
        int i = 0;
        while ((itr).hasNext())
        {
            if(d == (itr.next()).obj.getDay()&&itr.next().getObj().getCompleted()==true)
            {
                i++;

                System.out.printf("Experiment %d:\nSetup:%s\nday:%d\n", i, (itr.next()).obj.getSetup(), (itr.next()).obj.getDay());
                System.out.printf("time:%s\n", (itr.next()).obj.getTime());
                System.out.printf("completed:%s\naccuracy:%s\n\n\n", (itr.next()).obj.getCompleted(), (itr.next()).obj.getAccuracy());
            }
            itr.e = (itr.e).next;

        }
    }

    /**
     * Adds the given experiment to the and of day.
     * @param exp Experiment that we want to add.
     */
    public void addExp(Experiment exp)
    {
        ExperimentNode iter, iter2, expN;
        iter = new ExperimentNode();
        iter2 = new ExperimentNode();
        expN = new ExperimentNode();
        expN.setObj(exp);
        iter.next = head.next;
        while(iter.next.next!=null && iter.next.next.getObj().getDay() != exp.getDay()+1)
             iter = iter.next;

        iter2.next = iter.next.next;

        iter.next.next=expN;
        expN.next = iter2.next;
    }

    /**
     *
     * @param dayS day
     * @param index index of experiment
     * @return experiment that we want to get
     * @throws NoSuchElementException
     */
    public ExperimentNode getExp(int dayS, int index) throws NoSuchElementException// get the experiment with the given day and position
    {
        ExperimentNode iter;
        iter = new ExperimentNode();
        iter.next = head.next;
        int temp = 0;
        while ((temp!=dayS)&&(iter.next!=null))
        {
            iter = iter.next;
            temp = iter.getObj().getDay();
        }

        if(temp!=dayS) {
            throw new NoSuchElementException();
        }


        int i=1;
        while((i<index) && (iter.next!=null) && iter.next.getObj().getDay() == dayS)
        {
            iter = iter.next;
            i++;
        }

        if(i!=index)
            throw new NoSuchElementException();

        return iter;
    }

    /**
     * Sets the experiment to the determined position
     * @param dayS
     * @param index
     * @param exp
     */
    public void setExp(int dayS, int index, Experiment exp ) //set the experiment with the given day and position
    {
        ExperimentNode expNode = new ExperimentNode(exp);
        ExperimentNode iter;
        iter = new ExperimentNode();
        iter.next = head.next;
        int temp = 0;
        while ((temp!=dayS)&&(iter.next!=null))
        {
            iter = iter.next;
            temp = iter.getObj().getDay();
        }

        if(temp!=dayS) {
            throw new NoSuchElementException();
        }


        int i=1;
        while((i<index) && (iter.next!=null) && iter.next.getObj().getDay() == dayS)
        {
            iter = iter.next;
            i++;
        }

        if(i!=index)
            throw new NoSuchElementException();

        iter.next.setObj(expNode.getObj());
    }

    /**
     * Removes the given day from the list
     * @param dayS The day that will de remove
     */
    public void removeDay(int dayS)
    {
        if(dayS == 1)
        {
            head.next = head.next.nextDay;
        }
        else
        {
            ExperimentNode iter = new ExperimentNode();
            ExperimentNode iter2 = new ExperimentNode();
            ExperimentNode iter3 = new ExperimentNode();

            iter.next = head.next;
            int temp = 0;

            while(iter.next.next.getObj().getDay() != dayS)
            {
                iter = iter.next;
            }
            iter2.next = iter.next;
            iter3.next = iter.next;
            while(iter2.next!=null && temp < dayS+1 )
            {
                temp = iter2.next.getObj().getDay();
                iter2 = iter2.next;
            }
            iter.next.next = iter2.next;

            iter3.next.nextDay = iter2.next;



        }
    }

    /**
     * Removes the experiment from the list
     * @param dayS
     * @param index
     */
    public void removeExp (int dayS, int index)
    {
      ExperimentNode iter = new ExperimentNode();
      ExperimentNode iter2 = new ExperimentNode();
      ExperimentNode iter3 = new ExperimentNode();

        iter.next = head.next;
        iter2.next = head.next;
        iter3.next = head.next;
      if(dayS==1)
      {
          if(index==1)
          {
              head = head.next;
              iter.next = head.next;
              iter2.next = head.next;

              if(iter.next.getObj().getDay() == 1) {
                  while (iter2.next.getObj().getDay() == 1)
                      iter2 = iter2.next;

                  iter.next.nextDay = iter2.next;
              }
          }
          else
          {
              int i = 1;
              while(i<index)
              {
                  i++;
                  iter = iter.next;
              }
              i = 2;
              while (i<index)
              {
                  i++;
                  iter2 = iter2.next;
              }

              iter2.next.next = iter.next.next;
          }

      }
      else{
        while (iter.next.next.getObj().getDay() != dayS)
            iter = iter.next;
        while (iter2.next.getObj().getDay() != dayS)
            iter2 = iter2.next;
        while (iter3.next.nextDay!=null && iter3.next.nextDay.getObj().getDay()!=dayS)
        {
            iter3 = iter3.next;
        }
            if(index==1)
            {
                iter.next.next = iter2.next.next;
                iter3.next.nextDay = iter2.next.next;
                ExperimentNode iter4 = new ExperimentNode();
                iter4.next = iter2.next.next;

                while(iter2.next!=null && iter2.next.getObj().getDay()!=dayS+1)
                    iter2 = iter2.next;
                iter4.next.nextDay = iter2.next;
            }

            else
            {
                int i=1;
                while (i<index)
                {
                    i++;
                    iter2 = iter2.next;
                    iter = iter.next;
                }
                iter.next.next = iter2.next.next;
            }
    }

    }

    /**
     * Orders given day
     * @param dayS
     */
    public void orderDay(int dayS)
    {

        int size = 0;

        ExperimentNode iter = new ExperimentNode();
        iter.next = head.next;

        ExperimentNode iter2 = new ExperimentNode();


        while(iter.next != null && iter.next.getObj().getDay()!=dayS)
        {
            iter=iter.next;
        }
        iter2.next = iter.next;
        while(iter2.next != null && iter2.next.getObj().getDay()==dayS) {
            size++;
            iter2 = iter2.next;

        }

        if (size > 1) {
            for (int i = 0; i < size; i++ ) {

                ExperimentNode currentNode = new ExperimentNode();
                currentNode  = iter.next;
                ExperimentNode next = new ExperimentNode();
                next = currentNode.next;
                for (int j = 0; j < size - 1; j++) {
                    if (currentNode.getObj().getAccuracy() > next.getObj().getAccuracy()) {
                        ExperimentNode temp = new ExperimentNode();
                        temp = currentNode;
                        currentNode = next;
                        next = temp;
                    }

                    currentNode = next;
                    next = next.next;
                }
            }
        }
    }

    /**
     * Orders all of the experiments
     */
    public void orderExperiments()
    {
        ExperimentList newList = new ExperimentList();
        ExperimentNode iter3 = new ExperimentNode();
        iter3.next = head.next;
        newList.head = new ExperimentNode();
        ExperimentNode iterNew = new ExperimentNode();
        iterNew.next = newList.head.next;
        while (iter3.next!=null)
        {
            iterNew.next = iter3.next;

            iterNew = iterNew.next;
            iter3 = iter3.next;
        }

        ExperimentNode iter = new ExperimentNode();
        ExperimentNode iter2 = new ExperimentNode();

        iter.next = head.next;
        iter2.next = iter.next.next;

        while(iter.next!=null)
        {
            while(iter2.next!=null)
            {

                if(iter2.next.getObj().getAccuracy() < iter.next.getObj().getAccuracy())
                {

                    swap(iter.next, iter2.next);
                }
                iter2 = iter2.next;
            }
            iter = iter.next;
        }

    }

    /**
     * Swaps nodes if it is required
     * @param n1 node 1
     * @param n2 node 2
     */
    public void swap(ExperimentNode n1, ExperimentNode n2)
    {
        ExperimentNode temp = new ExperimentNode();


        temp.setObj(n1.getObj());


        n1.setObj(n2.getObj());

        n2.setObj(temp.getObj());


    }

}
