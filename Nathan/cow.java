import java.io.*;
import java.util.*;

public class cow{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();

        for(int l = 0; l < numCases; l++){
            ArrayList hLines = new ArrayList<Line>();
            ArrayList vLines = new ArrayList<Line>();

            int n = in.nextInt();
            Graph g = new Graph(n);

            for(int i = 0; i < n; i++) {
                Line thisLine = new Line(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

                if(thisLine.isVertical)
                    vLines.add(thisLine);
                else
                    hLines.add(thisLine);
            }

            System.out.println(hLines.size()+" horizontal lines");
            System.out.println(vLines.size()+" vertical lines");

            for(int i = 0; i < hLines.size(); i++) {
                for(int j = 0; j < vLines.size(); j++) {
                    if(Line.Intersect((Line)hLines.get(i), (Line)vLines.get(j))) {
                        g.AddEdge(i, j + hLines.size(), 1);
                        System.out.println("Intersection between hline "+i+" and vline"+j);
                    }
                }
            }

            System.out.println("Finding network flow in graph");
            g.Print();
            NetworkFlow nf = new NetworkFlow(g.graph, hLines.size());
            int ff_res = nf.ff();
            System.out.println("Num intersections: "+ff_res);
            System.out.println("Answer: "+(n - ff_res));
        }
    }
}

class Line {
    public int x1, x2, y1, y2;
    public boolean isVertical;

    Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        isVertical = (x1 == x2);
    }

    public static boolean Intersect(Line /*horizontal line*/l1, Line /*vertical line*/l2) {
        if(l1.isVertical && l2.isVertical || !l1.isVertical && !l2.isVertical)
            return  false;

        return Math.min(l1.x1, l1.x2) <= l2.x1 && Math.max(l1.x1, l1.x2) >= l2.x1 &&
			   Math.min(l2.y1, l2.y2) <= l1.y1 && Math.max(l2.y1, l2.y2) >= l1.y1;
    }
}
