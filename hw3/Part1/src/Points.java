/***
 * This class just keeps 2 int coordinates.
 */
public class Points {
    public int x;
    public int y;
    Points link;

    /***
     * No parameter constructure.
     */
    Points()
    {
        x = 0;
        y = 0;
    }

    /***
     * This constructure takes 2 points and assign them to the coordinates.
     * @param a x coordinate
     * @param b y coordinate
     */
    Points(int a, int b)
    {
        x = a;
        y = b;

    }
}
