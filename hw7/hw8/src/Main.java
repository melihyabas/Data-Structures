import java.util.*;
import java.io.File;

public class Main {
    /***
     * This method use all the other methods.
     * @param args
     */
    public static void main(String[] args )
    {
        try {
            File file = new File("input.txt");
            Scanner input = new Scanner(file);
            int a = 1;
            int nodes = Integer.parseInt(input.next());
            MyGraph g = new MyGraph(nodes);
            a++;

            while (input.hasNext()) {
                String word = input.next();
                if(a!=2 ) {
                    String st1 = word;
                    String st2 = input.next();
                    g.addEdge(Integer.parseInt(st1) , Integer.parseInt(st2));
                }
                a++;
            }

            boolean[][] ar = g.getAdj();
            int[][] adj = new int[ar.length][ar[0].length];
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (ar[i][j] == true)
                        adj[i][j] = 1;
                    else
                        adj[i][j] = 0;
                }
            }
            arrange(adj,nodes);
        }
        catch (Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }

    /***
     *
     * @param graph adjacency matrix
     * @param V number of vertices
     */
    static void arrange(int graph[][], int V)
    {
        int reach[][] = new int[V][V];
        int  i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if ((reach[i][k] != 0)&& (reach[k][j] != 0)) {
                        reach[i][j] = 1;
                    }
                }
            }
        }

        int counter=0;
        for(i=0 ; i<reach.length ; i++)
            if(isPopular(reach,i+1,V))
                counter++;
        System.out.println("Output: "+counter);
    }

    /***
     *
     * @param reach adjacency matrix
     * @param el The element to control if it is popular
     * @param V number of vertices
     * @return true if the elements is popular
     */
    static boolean isPopular(int reach[][], int el,int V)
    {
        int cnt=0;
        for (int i = 0; i < V; i++)
           if(reach[i][el-1]==1 && i+1!=el)
               cnt++;

        if(cnt+1 == reach.length)
            return true;
        return false;
    }
}