/**
 * A non-empty node in a recursive list of books:
 * stores one Book (first) and the rest of the list (rest).
 */
public class ElementNode implements IListOfBooks {
  private final Book first;
  private final IListOfBooks rest;

  /**
   * Construct a node with a first book and the rest of the list.
   * @param first the first (head) book
   * @param rest  the remainder of the list
   */
  public ElementNode(Book first, IListOfBooks rest) {
    this.first = first;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public float totalPrice() {
    return first.getPrice() + rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (first.before(year)) {
      return new ElementNode(first, rest.allBefore(year));
    } else {
      return rest.allBefore(year);
    }
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(first, rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    // Render as: [<book1>; <book2>; ...]
    return "[" + joinContents(this) + "]";
  }

  // Helper to build the inner contents without the outer brackets.
  private static String joinContents(IListOfBooks list) {
    if (list instanceof EmptyNode) {
      return "";
    }
    ElementNode node = (ElementNode) list;
    String tail = joinContents(node.rest);
    String here = node.first.toString();
    return tail.isEmpty() ? here : (here + "; " + tail);
  }
}
