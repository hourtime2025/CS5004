
/**
 * Abstract base for pets implementing {@link Pet} and {@link Comparable}{@code <Pet>}.
 * Stores shared attributes (name, age, weight, adoptionDate, owner, color, lastVetVisit)
 * and defines the natural ordering by weight (heavier ⇒ greater). Subclasses (Dog, Cat,
 * Bird, Fish) extend with species-specific behavior.
 *
 * @see Pet @see Dog @see Cat @see Bird @see Fish @see PetLastVetVisitComparator
 */

import java.util.Objects;

public abstract class AbstractPet implements Pet, Comparable<Pet> {
    protected String name;
    protected int age;
    protected double weight;
    protected int adoptionDate;
    protected String owner;
    protected Color color;
    protected int lastVetVisit;

    /**
     *
     */
    public AbstractPet(String name, int age, double weight, int adoptionDate,
                       String owner, Color color, int lastVetVisit) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.adoptionDate = adoptionDate;
        this.owner = owner;
        this.color = color;

        // BUG #1
        // Issue: lastVetVisit parameter is never assigned to the field; getters will return default 0.
        // Approach: Assign the constructor parameter to the instance field.
        // Solution:
        this.lastVetVisit = lastVetVisit;
    }

    /**
     *
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     *
     */
    @Override
    public double getWeight() {
        return weight;
    }

    /**
     *
     */
    @Override
    public String getOwner() {
        return owner;
    }

    /**
     *
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     *
     */
    @Override
    public int getLastVetVisit() {
        return lastVetVisit;
    }

    /**
     *
     */
    @Override
    public String toString() {

      return String.format(
          "%s{name='%s', age=%d, weight=%.2f, adoptionDate=%d, owner='%s', color=%s, lastVetVisit=%d}",
          getClass().getSimpleName(), name, age, weight, adoptionDate, owner, color, lastVetVisit
      );
    }

    /**
     * Default "natural"/Comparable method for comparing pets
     * <p>
     * A heavy pet is "greater than" a lighter pet, based on their weight
     * Originally provided code is just a placeholder
     */
    @Override
    public int compareTo(Pet other) {
      // BUG #2
      // Issue: Always returns 0; violates Comparable contract and prevents proper sorting.
      // Approach: Compare by weight using Double.compare to avoid precision pitfalls.
      // Solution:
      if (other == null) throw new NullPointerException("other");
      return Double.compare(this.weight, other.getWeight());
      // return 0;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractPet that = (AbstractPet) o;
    return age == that.age
        && Double.compare(this.weight, that.weight) == 0
        && Objects.equals(name, that.name)
        && Objects.equals(owner, that.owner)
        && color == that.color; // enum: reference equality is fine
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, owner, color, age, Double.hashCode(weight));
  }
}
