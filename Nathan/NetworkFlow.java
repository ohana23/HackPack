import java.io.*;
import java.util.*;

public class NetworkFlow {
    public ArrayList[] graph;
    public int n;
    public int source, sink;

    // "Infinite" flow.
	final public static int oo = (int)(1E9);

    //Use this constructor if we need to add a source + sink
    public NetworkFlow(ArrayList[] graph){
        n = graph.length + 2;
        source = n - 2;
        sink = n - 1;

        //Copy initial graph
        this.graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++)
            this.graph[i] = graph[i];

        //setup source + sink
        this.graph[source] = new ArrayList<Edge>();
        this.graph[sink] = new ArrayList<Edge>();

        //loop thourgh graph and count incoming + outgoing edges at each vertex
        int[] in = new int[n];
        int[] out = new int[n];

        for(int i = 0; i < n; i++)
        {
            for(Edge e:(ArrayList<Edge>)this.graph[i])
            {
                out[e.v1]++;
                in[e.v2]++;
            }
        }

        //Now do our connection
        for(int i = 0; i < n; i++)
        {
            //if out is 0, connect to sink with weight 1
            if(out[i] == 0)
                this.graph[sink].add(new Edge(i, sink, 1));

            //if in is 0, connect to source
            if(in[i] == 0)
                this.graph[source].add(new Edge(source, i, 1));
        }
    }

    //Use this constructor if we already know the source + sink
    public NetworkFlow(ArrayList[] g, int sr, int sk) {
        graph = g;
        source = sr;
        sink = sk;
        n = g.length;
    }

    //Run Ford Fulkerson
    public int ff() {
        //Set visited array and flow.
        boolean[] visited = new boolean[n];
        int flow = 0;

        while(true) {
            //Run one dfs
            Arrays.fill(visited, false);
            int res = dfs(source, visited, oo);

            //Nothing found, get out.
            if(res == 0) break;

            //Add this flow
            flow += res;
        }

        //return it
        return flow;
    }

    //DFS to find augmenting path from v with maxflow at most min
    public int dfs(int v, boolean[] visited, int min) {
        //if we are at the sing, this is our flow
        if(v == sink) return min;

        //if we have been here before, no flow
        if(visited[v]) return 0;

        //mark this node and recurse
        visited[v] = true;
        int flow = 0;

        //Loop through all possible next nodes
        for(Edge e:(ArrayList<Edge>)graph[v]){

            //we can augment in this direction if we have pos flow
            if(e.weight > 0) flow = dfs(e.v2, visited, Math.min(e.weight, min));

            //we got pos flow, return it
            if(flow > 0) {
                //subtract it going forward
                e.weight -= flow;

                //Add it going backwards (first have to find backwards edge)
                for(Edge be:(ArrayList<Edge>) graph[e.v2]) if(be.v2 == e.v1) be.weight += flow;

                //return this flow
                return flow;
            }
        }

        //If we get here there is no flow
        return 0;
    }

    public static void main(String args[])
    {
        NetworkFlow nf;
        Scanner input = new Scanner(System.in);
        ArrayList[] graph;

        if(args.length != 0)
        {
            System.out.println("Get the graph from the file "+args[0]);
            return;
        }
        else
        {
            Graph g = new Graph();
            g.Print();
            nf =  new NetworkFlow(g.graph, 4, 5);
        }

        System.out.println(nf.ff());
    }
}
