// With help from Alexander Hristov at
// http://www.ahristov.com/tutorial/geometry-games.html

public class LineLineIntersect {
  public static void main(String[] args) {
    // Line 1 from (1,1) to (5,6)
    // Line 2 from (3,5) to (6,2)
    Point P = LLIntersect(1,1,5,6,3,5,6,2);

    if (P != null)
      System.out.printf("%.2f, %.2f\n", P.x, P.y);
  }

  // This returns a point if the two lines intersect or null if they don't.
  // (x1, y1) and (x2, y2) are the starting and ending points for line 1.
  // (x3, y3) and (x4, y4) are the starting and ending points for line 2.
  public static Point LLIntersect(double x1, double y1, double x2, double y2, 
    double x3, double y3, double x4, double y4) {
    
    double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);

    if (d == 0)
      return null;
    
    double xi = ((x3-x4)*(x1*y2-y1*x2) - (x1-x2)*(x3*y4-y3*x4)) / d;
    double yi = ((y3-y4)*(x1*y2-y1*x2) - (y1-y2)*(x3*y4-y3*x4)) / d;

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
}
