// Uses the Gauss''s shoelace formula.
// Written with help from https://rosettacode.org/wiki/Shoelace_formula_for_polygonal_area#Java

// Plug values into an ArrayList of x,y coordinates, or Points.
// Call 'shoelaceArea()' with the ArrayList as input.

public class PolygonArea {
  public static void main(String[] args) {
    ArrayList<Point> polygon = new ArrayList<>();
    
    polygon.add(new Point(3, 4));
    polygon.add(new Point(5, 11));
    polygon.add(new Point(12, 8));
    polygon.add(new Point(9, 5));
    polygon.add(new Point(5, 6));

    double area = shoelaceArea(polygon);
    System.out.printf("This polygon's area is %.2f", area);
  }

  public static double shoelaceArea(ArrayList<Point> poly) {
    int N = poly.size();
    double a = 0.0;

    for (int i = 0; i < N - 1; i++)
      a += (poly.get(i).x * poly.get(i+1).y) - (poly.get(i+1).x * poly.get(i).y);

    return Math.abs(a + (poly.get(N-1).x * poly.get(0).y) - (poly.get(0).x * poly.get(N-1).y)) / 2.0;
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
