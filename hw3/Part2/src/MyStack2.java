/***
 * This is a stack structure. It keeps some double numbers.
 */
public class MyStack2{
    /***
     * A node class to link nodes.
     */
    public class Node
    {
        public Node()
        {

        }
        public Node(double a)
        {
            x = a;
        }
        double x;
        Node link;
    }

    Node top;
    /***
     * No parameter constructure.
     */
    public MyStack2()
    {
        top = null;
    }

    /***
     * This method adds a Points object to the top of stack.
     * @param obj Points
     */
    public void push(double obj)
    {
        Node temp = new Node(obj);
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
    public Node pop() throws NullPointerException
    {
        if(top==null)
            throw new NullPointerException();

        Node temp = new Node();
        temp = top;

        top = top.link;

        return temp;
    }
    /**
     * It just returns the top element of the stack.
     * @return Top element.
     * @throws NullPointerException
     */
    public Node peek() throws NullPointerException
    {
        if(top==null)
            throw new NullPointerException();
        return top;
    }

}
