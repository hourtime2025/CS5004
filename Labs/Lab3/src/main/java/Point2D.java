public class Point2D {
  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() { return x; }
  public double getY() { return y; }

  /** Euclidean distance to another point. */
  public double distance(Point2D other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

