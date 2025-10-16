import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for {@link MyQueue}.
 * Each public method in MyQueue has at least two assertions here,
 * including exception paths for methods that can throw.
 */
public class MyQueueTest {

  /** Minimal helper type to test generics with a non-String class. */
  static class Book {
    final String title;
    final String author;

    Book(String title, String author) {
      this.title = title;
      this.author = author;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Book b)) return false;
      return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode() {
      return title.hashCode() * 31 + author.hashCode();
    }

    @Override
    public String toString() {
      return "\"" + title + "\"/" + author;
    }
  }

  // ---------- enqueue ----------
  @Test
  @DisplayName("enqueue adds to tail; order preserved")
  void testEnqueue() {
    MyQueue<String> q = new MyQueue<>();
    q.enqueue("A");
    q.enqueue("B");
    assertFalse(q.isEmpty());                 // assertion 1
    assertEquals("A", q.peek());              // assertion 2 (head unchanged)
  }

  // ---------- dequeue ----------
  @Test
  @DisplayName("dequeue removes head and throws when empty")
  void testDequeue() {
    MyQueue<String> q = new MyQueue<>();
    q.enqueue("first");
    q.enqueue("second");
    assertEquals("first", q.dequeue());       // assertion 1
    assertEquals("second", q.dequeue());      // assertion 2

    assertThrows(NoSuchElementException.class, q::dequeue); // exception case
  }

  // ---------- peek ----------
  @Test
  @DisplayName("peek returns head without removing; throws when empty")
  void testPeek() {
    MyQueue<Book> q = new MyQueue<>();
    Book b1 = new Book("CS", "Aida");
    Book b2 = new Book("DS", "Ada");
    q.enqueue(b1);
    q.enqueue(b2);

    assertEquals(b1, q.peek());               // assertion 1
    assertEquals(b1, q.peek());               // assertion 2 (still there)

    MyQueue<Integer> empty = new MyQueue<>();
    assertThrows(NoSuchElementException.class, empty::peek); // exception case
  }

  // ---------- isEmpty ----------
  @Test
  @DisplayName("isEmpty reflects emptiness correctly")
  void testIsEmpty() {
    MyQueue<Character> q = new MyQueue<>();
    assertTrue(q.isEmpty());                  // assertion 1
    q.enqueue('x');
    assertFalse(q.isEmpty());                 // assertion 2
  }

  // ---------- toString ----------
  @Test
  @DisplayName("toString prints 'Queue: ' followed by elements separated by single spaces")
  void testToString() {
    MyQueue<String> q = new MyQueue<>();
    assertEquals("Queue: ", q.toString());    // assertion 1 (empty format)
    q.enqueue("one");
    q.enqueue("two");
    assertEquals("Queue: one two", q.toString()); // assertion 2
  }

  // ---------- equals ----------
  @Test
  @DisplayName("equals is order- and content-sensitive; type parameter erased at runtime but element equality matters")
  void testEquals() {
    MyQueue<String> a = new MyQueue<>();
    MyQueue<String> b = new MyQueue<>();
    a.enqueue("x"); a.enqueue("y");
    b.enqueue("x"); b.enqueue("y");

    assertEquals(a, b);                       // assertion 1

    b.dequeue();
    b.enqueue("z");
    assertNotEquals(a, b);                    // assertion 2
  }

  // ---------- hashCode ----------
  @Test
  @DisplayName("hashCode aligns with equals (same sequence -> same hash)")
  void testHashCode() {
    MyQueue<Book> a = new MyQueue<>();
    MyQueue<Book> b = new MyQueue<>();
    Book b1 = new Book("Algo", "CLRS");
    Book b2 = new Book("Patterns", "GoF");
    a.enqueue(b1); a.enqueue(b2);
    b.enqueue(b1); b.enqueue(b2);

    assertEquals(a.hashCode(), b.hashCode()); // assertion 1
    b.dequeue();
    assertNotEquals(a.hashCode(), b.hashCode()); // assertion 2
  }

  // ---------- constructor (implicit) ----------
  @Test
  @DisplayName("0-parameter constructor creates an empty queue")
  void testConstructor() {
    MyQueue<Float> q = new MyQueue<>();
    assertTrue(q.isEmpty());                  // assertion 1
    assertEquals("Queue: ", q.toString());    // assertion 2
  }
}
