/**
 * /**
 *  * Concrete pet representing a bird.
 *  * Extends {@link AbstractPet} and captures bird-specific characteristics
 *  *
 *  * @see AbstractPet
 *  */

public class Bird extends AbstractPet {
    private String species;
    private double wingSpan;
    private boolean canTalk;
    private int cageSize;
    
    /**
     * 
     */
    public Bird(String name, int age, double weight, int adoptionDate,
                String owner, Color color, int lastVetVisit,
                String species, double wingSpan, boolean canTalk, int cageSize) {
        super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        this.species = species;
        this.wingSpan = wingSpan;
        this.canTalk = canTalk;
        this.cageSize = cageSize;
    }

    /**
     * 
     */
    @Override
    public void feed() {
        
    }
    
    /**
     * 
     */
    @Override
    public String getExerciseNeeds() {
        return "";
    }
    
    /**
     * 
     */
    @Override
    public String makeSound() {
        if (this.canTalk) return "Polly want a cracker!";
        return "Chirp!";
    }

    @Override
    public int getLifespan() {
        return 0;
    }

    /**
     * 
     */
    public void cleanCage() {
        
    }
}
