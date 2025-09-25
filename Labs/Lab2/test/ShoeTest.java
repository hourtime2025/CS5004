import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {

  private Shoe shoe;

  @BeforeEach
  void setUp() {
    shoe = new Shoe(Kind.SNEAKER, Color.ORANGE, Brand.NIKE, 9.5);
  }

  // constructor: ≥2 assertions
  @Test
  void constructorInitializesAllFields() {
    assertNotNull(shoe);
    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(Color.ORANGE, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(9.5, shoe.getSize(), 1e-9);
  }

  // getters: ≥2 assertions
  @Test
  void gettersReturnExpectedValues() {
    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(Color.ORANGE, shoe.getColor());
    assertTrue(shoe.getSize() > 0);
  }

  // toString: ≥2 assertions
  @Test
  void toStringIsHumanReadable() {
    String s = shoe.toString();
    // Expect the friendly display values:
    assertTrue(s.contains("Nike"));     // from displayBrand(Brand.NIKE)
    assertTrue(s.contains("Sneaker"));  // from displayKind(Kind.SNEAKER)
    assertTrue(s.contains("Orange"));   // from displayColor(Color.ORANGE)
    assertTrue(s.contains("9.5"));      // size formatted with one decimal
  }

  // exception test (lambda): NIKE + DRESS should be invalid
  @Test
  void nikeDressThrowsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.ORANGE, Brand.NIKE, 10.0));
  }
}
