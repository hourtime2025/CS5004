import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Demonstrates alternative ways to sort collections of {@link Pet}.
 * Shows usage of the natural order (weight) and custom comparators (e.g., last vet visit).

 * Create multiple Pets and then demonstrate sorting three different ways:
 * 1. Natural order (heavier is greater)
 * 2. Sorting by last vet visit (using external Comparator class)
 * 3. Sorting by name (using Comparator.comparing)
 */
public class SortingWays {

  public static void main(String[] args) {

    Pet fido = new Dog("Fido", 1, 50, 20250101,
        "Mark", Color.BROWN, 20250115, "Mutt", true, 30);
    Pet jake = new Cat("Jake", 4, 16, 20210101,
        "Mark", Color.BLACK, 20240110, true, false, "long");
    Pet elwood = new Cat("Elwood", 4, 15, 20210101,
        "Mark", Color.BLACK, 20250120, true, false, "long");

    ArrayList<Pet> pets = new ArrayList<>();
    pets.add(jake);
    pets.add(fido);
    pets.add(elwood);

    System.out.println("Unsorted ArrayList of Pets:");
    System.out.println(pets);

    // (compareTo in AbstractPet, by weight)
    Collections.sort(pets);
    System.out.println("\nSorted by weight (natural order):");
    System.out.println(pets);

    // Sort by last vet visit (using external Comparator class)
    Collections.sort(pets, new PetLastVetVisitComparator());
    System.out.println("\nSorted by last vet visit (older first):");
    System.out.println(pets);

    // Sort by name (using Comparator.comparing, different style)
    Collections.sort(pets, Comparator.comparing(Pet::getName, String.CASE_INSENSITIVE_ORDER));
    System.out.println("\nSorted by name (alphabetical):");
    System.out.println(pets);
  }
}
