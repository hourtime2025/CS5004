import java.util.Comparator;

/**
 * Comparator for ordering {@link Pet} instances by last vet visit date.
 * Earlier (older) visit dates sort before more recent ones unless specified otherwise.
 *
 * @see Pet @see AbstractPet
 */
public class PetLastVetVisitComparator implements Comparator<Pet> {
    
    /**
     * Compare by last vet visit date (older/earlier date comes first).
     */

    // BUG #4
    // Issue: The comparison logic is incomplete—returns -1 only if pet1 < pet2, and 0 otherwise.
    //        This treats "greater-than" as equal, violating the Comparator contract and breaking sorting.
    // Approach: Use Integer.compare for clarity and correctness.
    // Solution (see fixed return below):
    @Override
    public int compare(Pet pet1, Pet pet2) {
        // double w1 = pet1.getLastVetVisit();
        // double w2 = pet2.getLastVetVisit();
        // if (w1 < w2) return -1;
        // return 0;

        // BUG #5
        // Issue: Uses double for values that are naturally ints. Unnecessary widening and
        //        misleading variable names ("w1"/"w2" suggest weight). Use int and clearer names.
        // Approach: Use int and Integer.compare; also documents intended ascending order (older first).
        // Solution:
        int d1 = pet1.getLastVetVisit();
        int d2 = pet2.getLastVetVisit();
        return Integer.compare(d1, d2);
    }
}

