public class MyGraph extends AbstractGraph{

    /****
     *
     * @return Returns the adjacency matrix.
     */
    public boolean[][] getAdj() {
        return adj;
    }

    /***
     * Constructor to create a new graph
     * @param numVertices
     */
    public MyGraph(int numVertices) {

        super(numVertices,true);
        adj = new boolean[numVertices][numVertices];
    }

    /***
     *
     * @param src The source vertex
     * @param dest The destination vertex
     */
    public void addEdge(int src, int dest) { adj[src-1][dest-1] = true; }

    /***
     *
     * @param src The source vertex
     * @param dest The destination vertex
     */
    public void removeEdge(int src, int dest) {
        adj[src][dest] = false;
    }

    /***
     * Returns true if the edge is exists.
     * @param src The source vertex
     * @param dest The destination vertex
     * @return
     */
    public boolean isEdge(int src, int dest) {
        return adj[src][dest];
    }
}