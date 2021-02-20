/***
 * Pixel class to keep a pixel's values
 */
public class Pixel {

    private int red;
    private int blue;
    private int green;

    /***
     *
     * @param r red value
     * @param g green value
     * @param b blue value
     */
    public Pixel(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    /***
     *
     * @return Red value
     */
    public int getRed()
    {
        return red;
    }
    /***
     *
     * @return Green value
     */
    public int getGreen()
    {
        return green;
    }
    /***
     *
     * @return Blue value
     */
    public int getBlue()
    {
        return blue;
    }
}
