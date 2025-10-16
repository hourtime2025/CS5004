import org.junit.Test;
import static org.junit.Assert.assertEquals;
// BUG #3
// Issue: Uses JUnit 5 annotation @BeforeEach while importing JUnit 4 (org.junit.Test/Assert).
// Approach: Align with JUnit 4 by replacing @BeforeEach with @Before and importing org.junit.Before.
// Solution: See fixed annotation and import below.
import org.junit.Before;

/**
 *
 */
public class BirdTest {

  /**
   *
   */
  // @BeforeEach   // BUGGY (JUnit 5)
  @Before         // FIXED (JUnit 4)
  public void setUp() {
    // initialize shared Bird test fixture if needed
  }

  /**
   *
   */
  @Test
  public void testFeed() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetExerciseNeeds() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testMakeSound() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testCleanCage() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetName() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetAge() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetWeight() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetOwner() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testGetColor() {
    // stub ok for exam; not a "bug"
  }

  /**
   *
   */
  @Test
  public void testCompareTo() {
    // stub ok for exam; not a "bug"
  }
}
