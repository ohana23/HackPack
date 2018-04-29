// With help from Rosetta Code.
// https://rosettacode.org/wiki/Find_the_intersection_of_a_line_with_a_plane

public class LinePlaneIntersection {
    public static void main(String [] args) {
    	// This points make up a LINE defined by a vector and a point.
        Point3D lineVector = new Point3D(0.0, -1.0, -1.0);
        Point3D linePoint = new Point3D(0.0, 0.0, 10.0);

        // These points make up a PLANE defined by a normal line and a point.
        Point3D planeNormal = new Point3D(0.0, 0.0, 1.0);
        Point3D planePoint = new Point3D(0.0, 0.0, 5.0);

        // Here's the point of intersection.
        Point3D i = LPIntersection(lineVector, linePoint, planeNormal, planePoint);
        System.out.printf("(%.2fx, %.2fy, %.2fz)\n", i.x, i.y, i.z);
    }

    // Returns the point of intersection between a line (or, 2 points that make
    // up a line), and a plane (2 points that make up a plane - normal and point).
    public static Point3D LPIntersection(Point3D lineVector, Point3D linePoint,
      Point3D planeNormal, Point3D planePoint)
    {
        Point3D difference = linePoint.subtract(planePoint);
        double prod1 = difference.dot(planeNormal);
        double prod2 = lineVector.dot(planeNormal);
        double prod3 = prod1 / prod2;

        return linePoint.subtract(lineVector.multiply(prod3));
    }
}

// A single point in 3-dimensional space.
class Point3D {
    public double x;
    public double y;
    public double z;

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Vector multiplication.
    Point3D multiply(double d) {
        return new Point3D(x*d, y*d, z*d);
    }

    // Vector subtraction.
    Point3D subtract(Point3D otherLine) {
        return new Point3D(x-otherLine.x, y-otherLine.y, z-otherLine.z);
    }

    // Vector dot product.
    double dot(Point3D otherLine) {
            return (x*otherLine.x) + (y*otherLine.y) + (z*otherLine.z);
    }
}
