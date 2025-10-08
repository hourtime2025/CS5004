
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @Test
  void identicalPointsThrowException() {
    Point2D a = new Point2D(0, 0);
    Point2D b = new Point2D(1, 0);
    assertThrows(IllegalArgumentException.class, () -> new Triangle(a, a, b));
    assertThrows(IllegalArgumentException.class, () -> new Triangle(a, b, b));
  }

  @Test
  void collinearPoints_areaZero_perimeterOK() {
    Triangle t = new Triangle(new Point2D(0, 0), new Point2D(1, 0), new Point2D(2, 0));
    assertEquals(0.0, t.area(), 1e-9);
    assertEquals(1.0 + 1.0 + 2.0, t.perimeter(), 1e-9);
  }

  @Test
  void threeFourFiveTriangle_correctAreaAndPerimeter() {
    Triangle t = new Triangle(new Point2D(0, 0), new Point2D(3, 0), new Point2D(0, 4));
    assertEquals(12.0, t.perimeter(), 1e-9);
    assertEquals(6.0, t.area(), 1e-9);
  }

  @Test
  void referencePointAndToString() {
    Point2D p1 = new Point2D(0, 0);
    Triangle t = new Triangle(p1, new Point2D(1, 1), new Point2D(2, 0));
    assertSame(p1, t.getReferencePoint());
    assertTrue(t.toString().startsWith("Triangle["));
    assertTrue(t.toString().contains("(0.0, 0.0)"));
  }
}
