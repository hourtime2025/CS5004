import java.util.Objects;

/**
 * A minimal Person used as the owner of a {@link Cat}.
 * Equality is based on the same identity fields used here (name).
 */
public class Person {
  private final String name;

  /**
   * Constructs a Person with a name.
   * @param name person's display name (non-null)
   */
  public Person(String name) {
    this.name = Objects.requireNonNull(name, "name cannot be null");
  }

  /** @return the person's name */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Person{name='" + name + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

