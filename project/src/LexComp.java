import java.util.Comparator;

/***
 *  * This is a comparator and it takes lexicographical order as a base to compare 2 objects.
 */
public class LexComp implements Comparator<Pixel> {

    /***
     *
     * @param o1 object1
     * @param o2 object2
     * @return
     */
    public int compare(Pixel o1, Pixel o2)
    {
        if(o1.getRed()<o2.getRed())    /*o1 < o2*/
            return 1;
        else if(o1.getRed()==o2.getRed() && o1.getBlue()<o2.getBlue())
            return 1;
        else if(o1.getRed()==o2.getRed() && o1.getBlue()==o2.getBlue() && o1.getGreen()<o2.getGreen())
            return 1;
        else
            return -1;
    }
}
