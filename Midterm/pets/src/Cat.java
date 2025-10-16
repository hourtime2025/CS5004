/**
 * Concrete pet representing a cat.
 * Extends {@link AbstractPet} and provides cat-specific details/behavior
 *
 * @see AbstractPet
 */
public class Cat extends AbstractPet {
    private boolean isIndoor;
    private boolean isDeclawed;
    private String furLength;
    
    /**
     * 
     */
    public Cat(String name, int age, double weight, int adoptionDate,
               String owner, Color color, int lastVetVisit,
               boolean isIndoor, boolean isDeclawed, String furLength) {
        super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        this.isIndoor = isIndoor;
        this.isDeclawed = isDeclawed;
        this.furLength = furLength;
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
        return "Meow";
    }

    @Override
    public int getLifespan() {
        return 0;
    }

    /**
     * 
     */
    public void useLitterBox() {
        
    }
}
