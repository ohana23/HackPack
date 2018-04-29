import java.io.*;

public class PointInPolygon {
    public final static int oo = 1000000;
    public final static double EPSILON = 1e-9;

    public static boolean PIP(Point p, Point[] pg) {
        int l = pg.length;
        if(l < 3) return false; //three points are required for a Polygon

        //create a point for the infinite line segment
        Point infP = new Point(oo, p.y);
        Point intersection;

        //count the number of intersection of the above line with sides of polygon
        int numInter = 0;
        for(int i = 0; i < l; i++) {
            int next = (i + 1) % l;
            //see if p -> infP intersects polygon[i] -> polygon[next]
            if((intersection = LLIntersect(p.x, p.y, infP.x, infP.y, pg[i].x, pg[i].y, pg[next].x, pg[next].y)) != null) {
                System.out.println("Found intersection at "+intersection);
                numInter++;
            }
        }

        System.out.println("There were "+numInter+" intersections");
        return (numInter % 2) == 1;
    }

    //Daniels Code
    public static Point LLIntersect(double x1, double y1, double x2, double y2,
        double x3, double y3, double x4, double y4) {
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (Math.abs(d) < EPSILON) return null;
        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
        return (new Point(xi, yi));
    }

    public static void main(String args[])
    {
        Point[] pg = {new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10)};
        Point insideP = new Point(5, 5);
        Point outsideP = new Point(20, 20);
        System.out.println("This should be true: "+PIP(insideP, pg));
    }
}

class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
      return String.format("(%f, %f)", x, y);
  }
}
