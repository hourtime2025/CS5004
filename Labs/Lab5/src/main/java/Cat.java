import java.util.Objects;

/**
 * A Cat has a name, age (years), coat color, and an owner.
 * <p>
 * Equality uses {@code instanceof Cat} (not {@code getClass()}) so that
 * future {@code Cat} subclasses can still be considered equal to {@code Cat}
 * instances when their identity fields match.
 */
public class Cat {
  private final String name;
  private int age;
  private final CatColor color;
  private Person owner;

  /**
   * Constructs a Cat with all fields set.
   *
   * @param name  non-null name
   * @param age   age in years
   * @param color non-null coat color
   * @param owner owner (may be null if unknown)
   */
  public Cat(String name, int age, CatColor color, Person owner) {
    this.name = Objects.requireNonNull(name, "name cannot be null");
    this.age = age;
    this.color = Objects.requireNonNull(color, "color cannot be null");
    this.owner = owner; // owner may be null
  }

  /** @return the cat's name */
  public String getName() {
    return name;
  }

  /** @return the cat's age in years */
  public int getAge() {
    return age;
  }

  /** @return the cat's color */
  public CatColor getColor() {
    return color;
  }

  /** @return the owner (may be null) */
  public Person getOwner() {
    return owner;
  }

  /**
   * Updates the cat's age.
   * @param age new age in years
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Updates the cat's owner (may be null).
   * @param owner new owner
   */
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", color=" + color +
        ", owner=" + owner +
        '}';
  }

  /**
   * Equality compares the same identity fields used in {@link #hashCode()}:
   * name, age, color, and owner.
   * <ul>
   *   <li>Uses {@code instanceof Cat} (per Module 5 pattern)</li>
   *   <li>Null-safe comparison via {@link Objects#equals(Object, Object)}</li>
   * </ul>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cat)) return false; // allow subclasses
    Cat cat = (Cat) o;
    return age == cat.age
        && Objects.equals(name, cat.name)
        && color == cat.color
        && Objects.equals(owner, cat.owner);
  }

  /**
   * Hash code uses the same fields as {@link #equals(Object)} to maintain
   * the equals–hashCode contract.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, color, owner);
  }
}

