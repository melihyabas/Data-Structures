public interface Graph {

    /***
     * Adds a new edge into the graph
     * @param src The source vertex
     * @param dest The destination vertex
     */
    public void addEdge(int src, int dest);

    /***
     * Removes the given edge
     * @param src The source vertex
     * @param dest The destination vertex
     */
    public void removeEdge(int src, int dest);

    /***
     * Returns true if the given edge exists.
     * @param src The source vertex
     * @param dest The destination vertex
     * @return Existing situation
     */
    public boolean isEdge(int src, int dest);

    /***
     * Gives the number of vertices
     * @return number of vertices.
     */
    public int getNumV();


    }