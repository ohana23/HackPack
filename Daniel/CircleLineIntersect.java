public class CircleLineIntersect {
  public static void main(String[] args) {
    Circle circle = new Circle(x, y, r);
    Line line = new Line(x1, y1, x2, y2);
   
    if ( quad(line.a(), line.b(circle), line.c(circle)) ) {
      System.out.println("The line segment intersects the circle.");
    } else {
      System.out.println("The line segment does not intersect the circle.");
    }
  }
}
  

// Returns true if line and circle intersect. Otherwise, returns false.
// This essentially runs the quadratic formula for quadratic equations.
// (-b +/- sqrt(b^2 - 4-ac)) / 2a
public static boolean quad(double a, double b, double c) {
  boolean hasSolution = true;
  double discriminant = (b*b) - (4*a*c);
  
  // Negative discriminant means no solution.
  if (discriminant < 0) return false;
  
  double plusVal = (-b + Math.sqrt(discriminant)) / (2*a);
  double minusVal = (-b - Math.sqrt(discriminant)) / (2*a);
  
  if (!(plusVal > 0 && plusVal < 1))
    if (!(minusVal > 0 && minusVal < 1))
      hasSolution = false;
      
  if (plusVal >= 0 && plusVal <= 1) hasSolution = true;
  if (minusVal >= 0 && minusVal <= 1) hasSolution = true;
  
  return hasSolution;
}

class Circle {
  public double centX;
  public double centY;
  public double r;
  
  public Circle(double x, double y, double R) {
    centX = x;
    centY = y;
    r = R;
  }
}

class Line {
  public double x1, y1, x2, y2;
  public double dx, dy;
  
  public Line(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    
    dx = x2 - x1;
    dy = y2 - y1;
  }
  
  public double a() {
    return (this.dx*this.dx) + (this.dy*this.dy);
  }
  
  public double b(Circle circle) {
    return 2 * (this.dx*(this.x1 - circle.centX) + this.dy*(this.y1 - circle.centY));
  }
  
  public double c(Circle circle) {
    return (this.x1 - circle.centX)*(this.x1 - circle.centX) + (this.y1 - circle.centY)*(this.y1 - circle.centY) - (circle.r*circle.r);
  }
}
