/**
 * The empty (sentinel) node for a recursive list of books.
 * Represents an empty list.
 */
public class EmptyNode implements IListOfBooks {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public float totalPrice() {
    return 0.0f;
  }

  @Override
  public IListOfBooks allBefore(int year) {
    // Filtering an empty list yields an empty list.
    return this; // or: new EmptyNode();
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    // Appending to empty creates a single-element list.
    return new ElementNode(book, new EmptyNode());
  }

  @Override
  public String toString() {
    return "[]";
  }
}
