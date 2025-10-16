import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
Question A :
Using ArrayList.remove(0) for frequent dequeues forces all remaining elements to shift left (O(n) each),
causing significant performance degradation and unnecessary memory churn.

Question B:
Use a circular-buffer (ring) implementation or keep a moving head index (and occasionally compact) so dequeues
are O(1) without shifting elements.

*/


/**
 * A simple generic FIFO queue backed by an {@link ArrayList}.
 * <p>
 * This class supports enqueue (add to tail), dequeue (remove from head),
 * peek (read head without removing), and isEmpty operations.
 * It also overrides {@code toString}, {@code equals}, and {@code hashCode}.
 *
 * <p><b>Note:</b> A queue is a First-In, First-Out (FIFO) data structure.
 *
 * @param <T> the reference type of elements held in this queue
 */
public class MyQueue<T> {

  /** Internal storage for queue elements (head is at index 0). */
  private final List<T> data;

  /**
   * Creates an empty queue.
   */
  public MyQueue() {
    this.data = new ArrayList<>();
  }

  /**
   * Adds an element to the tail of the queue.
   *
   * @param e the element to add (may be {@code null})
   */
  public void enqueue(T e) {
    data.add(e);
  }

  /**
   * Removes and returns the head element of the queue.
   *
   * @return the head element
   * @throws NoSuchElementException if the queue is empty
   *
   * Question A (inline): Frequent {@code dequeue()} operations call
   * {@code remove(0)} on an {@code ArrayList}, which shifts all remaining elements left —
   * causing O(n) time per dequeue and potential performance degradation.
   *
   * Question B (inline): Use a circular buffer (ring) or maintain a head index to
   * avoid shifting elements on every dequeue.
   */
  public T dequeue() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return data.remove(0); // O(n) shift on ArrayList
  }

  /**
   * Returns (but does not remove) the head element of the queue.
   *
   * @return the head element
   * @throws NoSuchElementException if the queue is empty
   */
  public T peek() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return data.get(0);
  }

  /**
   * Indicates whether this queue contains no elements.
   *
   * @return {@code true} if empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return data.isEmpty();
  }

  /**
   * Returns a string in the form:
   * <pre>
   * Queue: e1 e2 e3
   * </pre>
   * where each element is rendered via its {@code toString()}.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Queue: ");
    for (int i = 0; i < data.size(); i++) {
      sb.append(Objects.toString(data.get(i)));
      if (i < data.size() - 1) sb.append(' ');
    }
    return sb.toString();
  }

  /**
   * Two queues are equal if they are both {@code MyQueue} instances and
   * contain the same sequence of elements (by {@code equals}) in the same order.
   *
   * @param o the other object
   * @return {@code true} if equal; {@code false} otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MyQueue<?> other)) return false;
    return data.equals(other.data);
  }

  /**
   * Computes a hash code based on the underlying element sequence.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return data.hashCode();
  }
}
