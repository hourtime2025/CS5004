/**
 * Core interface for pets in the model.
 * Exposes identity, basic stats (age, weight, color), ownership, and last vet visit;
 * designed to be implemented by species (Dog, Cat, Bird, Fish) and to support natural
 * ordering via {@link Comparable} (implemented in {@link AbstractPet}).
 *
 * @see AbstractPet @see Dog @see Cat @see Bird @see Fish
 */
public interface Pet extends Comparable<Pet> {

    /**
     *
     */
    String getName();

    /**
     *
     */
    int getAge();

    /**
     *
     */
    double getWeight();

    /**
     *
     */
    String getOwner();

    /**
     *
     */
    void feed();

    /**
     *
     */
    Color getColor();

    /**
     *
     */
    String getExerciseNeeds();

    /**
     *
     */
    String makeSound();

    /**
     *
     */
    int getLifespan();
    /**
     *
     */
    int getLastVetVisit();
}