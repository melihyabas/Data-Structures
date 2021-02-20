/***
 * This is a stack structure. It keeps 2 points and to do that it keeps a Points class object.
 */
public class MyStack{

    private Points top;

    /***
     * A constructure
     */
    public MyStack()
    {
        top = null;
    }

    /***
     * This method adds a Points object to the top of stack.
     * @param obj Points
     */
    public void push(Points obj)
    {
        Points temp = new Points(obj.x,obj.y);
        temp.link = top;
        top = temp;
    }

    /***
     * It checks if stack is empty.
     * @return A boolean value.
     */
    public boolean empty()
    {
        return top == null;

    }

    /***
     * It returns and remove the top element of stack.
     * @return old top element
     * @throws NullPointerException
     */
    public Points pop() throws NullPointerException
    {
        if(top==null)
            throw new NullPointerException();

        Points temp = new Points();
        temp = top;

        top = top.link;

        return temp;
    }

    /**
     * It just returns the top element of the stack.
     * @return Top element.
     * @throws NullPointerException
     */
    public Points peek() throws NullPointerException
    {
        if(top==null)
            throw new NullPointerException();
        return top;
    }

}
