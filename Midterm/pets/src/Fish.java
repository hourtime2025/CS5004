/**
 * Concrete pet representing a fish.
 * Extends {@link AbstractPet} and models aquarium-related considerations
 * (e.g., tank context and simple care needs).
 *
 * @see AbstractPet
 */
public class Fish extends AbstractPet {
    private String waterType;
    private double tankSize;
    private int tankMates;
    private double temperature;
    
    /**
     * 
     */
    public Fish(String name, int age, double weight, int adoptionDate,
                String owner, Color color, int lastVetVisit,
                String waterType, double tankSize, int tankMates, double temperature) {
        super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        this.waterType = waterType;
        this.tankSize = tankSize;
        this.tankMates = tankMates;
        this.temperature = temperature;
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
        return "Glub";
    }

    @Override
    public int getLifespan() {
        return 0;
    }

    /**
     * 
     */
    public void cleanTank() {
        
    }
}
