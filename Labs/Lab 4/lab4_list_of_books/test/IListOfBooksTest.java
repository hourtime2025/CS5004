import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {

  private static final float EPS = 1e-6f;

  @Test
  void testEmptyNode_count() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.count());
    assertEquals(0, new EmptyNode().count());
  }

  @Test
  void testEmptyNode_totalPrice() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0.0f, empty.totalPrice(), EPS);
    assertEquals(0.0f, new EmptyNode().totalPrice(), EPS);
  }

  @Test
  void testEmptyNode_allBefore() {
    IListOfBooks empty = new EmptyNode();
    assertSame(empty, empty.allBefore(2000)); // returns this
    assertEquals("[]", empty.allBefore(0).toString());
  }

  @Test
  void testEmptyNode_addAtEnd() {
    IListOfBooks empty = new EmptyNode();
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);

    IListOfBooks one = empty.addAtEnd(b1);
    assertEquals(1, one.count());
    assertTrue(one.toString().contains(b1.toString()));
  }

  @Test
  void testEmptyNode_toString() {
    assertEquals("[]", new EmptyNode().toString());
    assertEquals("[]", new EmptyNode().toString()); // second assertion (idempotent)
  }

  @Test
  void testElementNode_count() {
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);
    Book b2 = new Book("B", "Auth2", 2005, 20.0f);
    Book b3 = new Book("C", "Auth3", 2015, 30.5f);

    IListOfBooks one = new ElementNode(b1, new EmptyNode());
    IListOfBooks three =
        new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, new EmptyNode())));

    assertEquals(1, one.count());
    assertEquals(3, three.count());
  }

  @Test
  void testElementNode_totalPrice() {
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);
    Book b2 = new Book("B", "Auth2", 2005, 20.0f);
    Book b3 = new Book("C", "Auth3", 2015, 30.5f);

    IListOfBooks one = new ElementNode(b1, new EmptyNode());
    IListOfBooks three =
        new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, new EmptyNode())));

    assertEquals(10.0f, one.totalPrice(), EPS);
    assertEquals(60.5f, three.totalPrice(), EPS);
  }

  @Test
  void testElementNode_allBefore() {
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);
    Book b2 = new Book("B", "Auth2", 2005, 20.0f);
    Book b3 = new Book("C", "Auth3", 2015, 30.5f);

    IListOfBooks two = new ElementNode(b1, new ElementNode(b2, new EmptyNode()));
    IListOfBooks three =
        new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, new EmptyNode())));

    // Before 2010 -> should include A (1990) and B (2005), exclude C (2015)
    String expectedAB = "[" + b1.toString() + "; " + b2.toString() + "]";
    assertEquals(expectedAB, three.allBefore(2010).toString());

    // Before 1995 -> only A
    String expectedA = "[" + b1.toString() + "]";
    assertEquals(expectedA, two.allBefore(1995).toString());
  }

  @Test
  void testElementNode_addAtEnd() {
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);
    Book b2 = new Book("B", "Auth2", 2005, 20.0f);
    Book b3 = new Book("C", "Auth3", 2015, 30.5f);

    IListOfBooks two = new ElementNode(b1, new ElementNode(b2, new EmptyNode()));
    IListOfBooks plus = two.addAtEnd(b3);
    assertEquals(3, plus.count());

    IListOfBooks chain = new ElementNode(b1, new EmptyNode()).addAtEnd(b2).addAtEnd(b3);
    String expected = "[" + b1.toString() + "; " + b2.toString() + "; " + b3.toString() + "]";
    assertEquals(expected, chain.toString());
  }

  @Test
  void testElementNode_toString() {
    Book b1 = new Book("A", "Auth1", 1990, 10.0f);
    Book b2 = new Book("B", "Auth2", 2005, 20.0f);
    Book b3 = new Book("C", "Auth3", 2015, 30.5f);

    IListOfBooks one = new ElementNode(b1, new EmptyNode());
    IListOfBooks three =
        new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, new EmptyNode())));

    assertEquals("[" + b1.toString() + "]", one.toString());
    assertEquals(
        "["]()
