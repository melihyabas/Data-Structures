import java.util.Comparator;

/***
 * This is a comparator and it takes euclidean norm as a base to compare 2 objects.
 */
public class EucComp implements Comparator<Pixel>
{
    /***
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return returns 1 if n1 has smaller euclidean norm
     */
    public int compare(Pixel o1, Pixel o2)
    {
        double n1 = o1.getRed()*o1.getRed()+o1.getBlue()*o1.getBlue()+o1.getGreen()*o1.getGreen();

        double n2 = o2.getRed()*o2.getRed()+o2.getBlue()*o2.getBlue()+o2.getGreen()*o2.getGreen();

        n1 = Math.sqrt(n1);
        n2 = Math.sqrt(n2);

        if(n1<n2)
            return 1;
        else
            return -1;
    }
}
