/**
 * ElementNode represents a non-empty list node with a head Book and a tail IListOfBooks.
 */
public class ElementNode implements IListOfBooks {
  private final Book first;
  private final IListOfBooks rest;

  public ElementNode(Book first, IListOfBooks rest) {
    if (first == null || rest == null) {
      throw new IllegalArgumentException("first and rest must be non-null");
    }
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
    // Include this.first if its year is strictly before `year`
    IListOfBooks filteredRest = rest.allBefore(year);
    if (first.getYear() < year) {
      return new ElementNode(first, filteredRest);
    } else {
      return filteredRest;
    }
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    // Rebuild the list preserving order; attach new element at the very end
    return new ElementNode(this.first, this.rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    appendToString(sb);
    sb.append("]");
    return sb.toString();
  }

  /** Helper for building the comma-separated list content. */
  private void appendToString(StringBuilder sb) {
    sb.append(first.toString());
    if (rest instanceof ElementNode) {
      sb.append(", ");
      ((ElementNode) rest).appendToString(sb);
    } else if (rest instanceof EmptyNode) {
      // nothing
    } else {
      // Fallback for any other implementation
      String r = rest.toString();
      if (!"[]".equals(r) && r.length() > 2) {
        sb.append(", ");
        sb.append(r.substring(1, r.length() - 1)); // strip outer brackets
      }
    }
  }
}

