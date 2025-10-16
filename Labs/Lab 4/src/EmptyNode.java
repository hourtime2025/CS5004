public class EmptyNode /**
 * EmptyNode represents an empty list of books.
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
    // No books to filter; remain empty
    return this;
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    // Add the first element
    return new ElementNode(book, this);
  }

  @Override
  public String toString() {
    return "[]";
  }
}
{

}
