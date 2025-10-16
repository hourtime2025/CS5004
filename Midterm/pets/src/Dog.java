/**
 * Concrete pet representing a dog.
 * Extends {@link AbstractPet} and provides dog-specific details/behavior
 *
 * @see AbstractPet
 */
public class Dog extends AbstractPet {
  private String breed;
  private boolean isTrained;
  private int walkMinutesPerDay;

  /**
   *
   */
//  public Dog(String name, int age, int weight, int adoptionDate, String owner, Color color,  int lastVetVisit,
//      String breed, boolean isTrained, int walkMinutesPerDay) {
//
//    // BUG #1
//    // Issue: Inherited fields (name, age, weight, adoptionDate, owner, color, lastVetVisit)
//    // are never initialized because super(...) is not called.
//    // Approach: Call the AbstractPet constructor to properly set base fields.
//    // Solution (shown in corrected constructor below).
//
//    // BUG #2
//    // Issue: Parameter type for weight is int, but AbstractPet uses double.
//    // This causes a type mismatch/precision loss and complicates super(...) call.
//    // Approach: Change the parameter type to double to match AbstractPet.
//    // Solution: See corrected constructor below.
//
//    // (Existing assignments only initialize Dog-specific fields.)
//    this.breed = breed;
//    this.isTrained = isTrained;
//    this.walkMinutesPerDay = walkMinutesPerDay;
//  }

  // Solution for BUG #1 and BUG #2:
  // Commented out above buggy constructor and provide a corrected overload.

    /*
    // BUGGY VERSION (kept for reference):
    public Dog(String name, int age, int weight, int adoptionDate, String owner, Color color,  int lastVetVisit,
        String breed, boolean isTrained, int walkMinutesPerDay) {
        this.breed = breed;
        this.isTrained = isTrained;
        this.walkMinutesPerDay = walkMinutesPerDay;
    }
    */

  // FIXED VERSION:
  public Dog(String name, int age, double weight, int adoptionDate, String owner, Color color, int lastVetVisit,
      String breed, boolean isTrained, int walkMinutesPerDay) {
    super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
    this.breed = breed;
    this.isTrained = isTrained;
    this.walkMinutesPerDay = walkMinutesPerDay;
  }

  /**
   *
   */
  @Override
  public void feed() {
    System.out.println("Good food!");
  }

  /**
   *
   */
  @Override
  public String getExerciseNeeds() {
    // Stub (stubs do not count as bugs per instructions)
    return "";
  }

  /**
   *
   */
  @Override
  public int getLifespan() {
    // Stub (stubs do not count as bugs per instructions)
    return 0; // Calculate based on breed
  }

  /**
   *
   */
  @Override
  public String makeSound() {
    return "Woof!";
  }

  /**
   *
   */
  public void fetch() {
    // optional behavior; empty body is acceptable
  }
}

