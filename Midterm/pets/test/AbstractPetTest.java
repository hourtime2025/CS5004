import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for AbstractPet (two assertions per method).
 * Uses a minimal concrete subclass to instantiate AbstractPet.
 */
public class AbstractPetTest {

  /**
   * Minimal concrete subclass for testing.
   */
  private static class TestPet extends AbstractPet {
    public TestPet(String name, int age, double weight, int adoptionDate,
        String owner, Color color, int lastVetVisit) {
      super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
    }
    @Override public void feed() { /* no-op */ }
    @Override public String getExerciseNeeds() { return "Low"; }
    @Override public int getLifespan() { return 12; }
    @Override public String makeSound() { return "..."; }
  }

  private TestPet light;
  private TestPet heavy;

  @BeforeEach
  public void setUp() {
    // YYYYMMDD for dates per assignment convention
    light = new TestPet("Fido", 3, 12.5, 20240101, "Bob", Color.BLACK, 20250101);
    heavy = new TestPet("Zazu", 5, 20.0, 20231231, "Ada", Color.WHITE, 20240115);
  }

  @Test
  public void testGetName() {
    assertEquals("Fido", light.getName());
    assertEquals("Zazu", heavy.getName());
  }

  @Test
  public void testGetAge() {
    assertEquals(3, light.getAge());
    assertEquals(5, heavy.getAge());
  }

  @Test
  public void testGetWeight() {
    assertEquals(12.5, light.getWeight(), 1e-9);
    assertEquals(20.0, heavy.getWeight(), 1e-9);
  }

  @Test
  public void testGetOwner() {
    assertEquals("Bob", light.getOwner());
    assertEquals("Ada", heavy.getOwner());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, light.getColor());
    assertEquals(Color.WHITE, heavy.getColor());
  }

  @Test
  public void testGetLastVetVisit() {
    assertEquals(20250101, light.getLastVetVisit());
    assertEquals(20240115, heavy.getLastVetVisit());
  }

  @Test
  public void testToString() {
    String s1 = light.toString();
    String s2 = heavy.toString();
    // two assertions: contains class name & key fields
    assertTrue(s1.contains("TestPet") && s1.contains("name='Fido'"));
    assertTrue(s2.contains("weight=20.00") && (s2.contains("Color") || s2.contains("color")));
  }

  @Test
  public void testCompareTo() {
    // heavier should be "greater" than lighter
    assertTrue(light.compareTo(heavy) < 0);
    assertTrue(heavy.compareTo(light) > 0);

    // equal-weight tie
    TestPet sameWeight = new TestPet("Tie", 2, 20.0, 20240102, "X", Color.BROWN, 20240202);
    assertEquals(0, heavy.compareTo(sameWeight));
  }

  @Test
  public void testEqualsAndHashCode() {
    AbstractPet a1 = new TestPet("Fido", 3, 12.5, 20240101, "Bob", Color.BLACK, 20250101);
    AbstractPet a2 = new TestPet("Fido", 3, 12.5, 20231231, "Bob", Color.BLACK, 20240115); // different dates ok
    AbstractPet a3 = new TestPet("Fido", 3, 12.6, 20240101, "Bob", Color.BLACK, 20250101);

    assertEquals(a1, a2);                    // same name/owner/color/weight/age ⇒ equal
    assertEquals(a1.hashCode(), a2.hashCode());

    assertNotEquals(a1, a3);                 // weight differs
  }

  @Test
  public void testEqualsDifferentSubclassNotEqual() {
    AbstractPet base = new TestPet("Fido", 3, 12.5, 20240101, "Bob", Color.BLACK, 20250101);
    Pet dog = new Dog("Fido", 3, 12.5, 20240101, "Bob", Color.BLACK, 20250101, "Mutt", true, 30);

    assertNotEquals(base, dog); // getClass() semantics: different concrete class ⇒ not equal
  }

}
