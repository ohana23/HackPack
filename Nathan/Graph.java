import java.io.*;
import java.util.*;

public class Graph{
    public ArrayList[] graph;
    public int numVertices;

    public Graph(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many vertices are in this graph?");
        numVertices = input.nextInt();

        //Setting up graph in java
        graph = new ArrayList[numVertices];
        for(int i = 0; i < numVertices; i++)
            graph[i] = new ArrayList<Edge>();


        for(int i = 0; i < numVertices; i++)
        {
            char thisNode = (char)(i + 'A');
            System.out.println("How many edges are leaving node "+thisNode);
            int numEdgesOutThisNode = input.nextInt();

            System.out.println("Enter those edges in form '<node> <weight>'");
            for(int j = 0; j < numEdgesOutThisNode; j++)
            {
                char connectedTo = input.next().charAt(0);
                int weight = input.nextInt();
                int thisRealNode = connectedTo - 'A';
                graph[i].add(new Edge(i, thisRealNode, weight));
            }
        }
    }

    public Graph(int n){
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<Edge>();
        numVertices = n;
    }

    public Graph(ArrayList[] g) {
        graph = g;
        numVertices = g.length;
    }

    public void AddEdge(int v1, int v2, int w){graph[v1].add(new Edge(v1, v2, w));}

    public void Print(){
        System.out.println("Printing graph with "+numVertices+" vertices");
        for(int i = 0; i < numVertices; i++)
            System.out.println((char)(i + 'A')+": "+graph[i]);
    }

    public String toString() {
        return "print graph";
    }
}

class Edge implements Comparable<Edge> {
    public int v1, v2, weight;

    public Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public int compareTo(Edge e)
    {
        return Integer.compare(this.weight, e.weight);
    }

    public String toString(){
        return "("+(char)(v1 + 'A')+", "+(char)(v2 + 'A')+", "+weight+")";
    }
}
