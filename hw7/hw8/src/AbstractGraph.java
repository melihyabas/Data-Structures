/** Abstract base class for graphs. A graph is a set of vertices and
 a set of edges.
 */
public abstract class AbstractGraph implements Graph {

    /***
     * Adjacency matrix to keep edges
     */
    protected boolean adj[][];

    protected int numVert;
    protected boolean directed;

    /***
     * Constructor to use by concrete classes
     * @param numVertices Number of vertices
     * @param directed if has a direction
     */
    public AbstractGraph(int numVertices,boolean directed) {

        numVert = numVertices;
        adj = new boolean[numVertices][numVertices];
        this.directed = directed;
    }

    /***
     *
     * @return Number of vertices
     */
    public int getNumV() {
        return numVert;
    }

    /***
     *
     * @return true if there is a direction
     */
    public boolean isDirected(){ return directed;}
}