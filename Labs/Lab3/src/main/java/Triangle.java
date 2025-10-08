public class Triangle implements Shape {
  private final Point2D p1; // reference point (first arg)
  private final Point2D p2;
  private final Point2D p3;

  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
    if (same(p1, p2) || same(p1, p3) || same(p2, p3)) {
      throw new IllegalArgumentException("Triangle cannot have two (or more) identical points.");
    }
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  private static boolean same(Point2D a, Point2D b) {
    return a.getX() == b.getX() && a.getY() == b.getY();
  }

  private double a() { return p1.distance(p2); }
  private double b() { return p2.distance(p3); }
  private double c() { return p3.distance(p1); }

  @Override
  public Point2D getReferencePoint() { return p1; }

  @Override
  public double perimeter() { return a() + b() + c(); }

  @Override
  public double area() {
    double s = perimeter() / 2.0;                 // Heron's formula
    double areaSq = s * (s - a()) * (s - b()) * (s - c());
    return Math.sqrt(Math.max(0.0, areaSq));      // guard FP roundoff
  }

  @Override
  public String toString() {
    return "Triangle[" + p1 + ", " + p2 + ", " + p3 + "]";
  }
}
