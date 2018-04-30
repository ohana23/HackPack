import java.io.*;

public class PointInPolygon {
    public final static int oo = 1000000;
    public final static double EPSILON = 1e-9;

    public static boolean PIP(Point p, Point[] pg) {
        int l = pg.length, numInter = 0;
        if(l < 3) return false;
        Point infP = new Point(oo, p.y), intersection;
        for(int i = 0; i < l; i++)
            if((intersection = LLIntersect(p.x, p.y, infP.x, infP.y, pg[i].x,
            pg[i].y, pg[(i + 1) % l].x, pg[(i + 1) % l].y)) != null)
                if(p.x > intersection.x)
                    numInter++;
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
