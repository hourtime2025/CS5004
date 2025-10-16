import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for {@link FractionImpl}.
 * Covers construction, normalization, getters/setters, arithmetic, comparison,
 * reciprocal, toDouble, and toString.
 */
public class FractionImplTest {

  // ---------- Constructor & normalization ----------

  @Test
  void constructsAndNormalizesPositive() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals(2, f.getNumerator());
    assertEquals(1, f.getDenominator());
    assertEquals("2 / 1", f.toString());
  }

  @Test
  void constructsAndNormalizesNegativeSignOnNumerator() {
    Fraction f1 = new FractionImpl(-2, 4);
    assertEquals(-1, f1.getNumerator());
    assertEquals(2, f1.getDenominator());
    assertEquals("-1 / 2", f1.toString());

    Fraction f2 = new FractionImpl(2, 3);
    assertEquals(2, f2.getNumerator());
    assertEquals(3, f2.getDenominator());
  }

  @Test
  void zeroNumeratorCanonicalForm() {
    Fraction f = new FractionImpl(0, 5);
    assertEquals(0, f.getNumerator());
    assertEquals(1, f.getDenominator(), "Zero should normalize to 0/1");
    assertEquals("0 / 1", f.toString());
  }

  @Test
  void constructorDenominatorMustBePositive() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(5, -3));
  }

  // ---------- Getters / Setters ----------

  @Test
  void setNumeratorKeepsSimplestForm() {
    Fraction f = new FractionImpl(1, 2);
    f.setNumerator(4);
    assertEquals(2, f.getNumerator());
    assertEquals(1, f.getDenominator());
  }

  @Test
  void setDenominatorValidatesAndNormalizes() {
    Fraction f = new FractionImpl(3, 9); // -> 1/3
    f.setDenominator(6);
    assertEquals(1, f.getNumerator());
    assertEquals(6, f.getDenominator());
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(-5));
  }

  @Test
  void settersMaintainSignRule() {
    Fraction f = new FractionImpl(-1, 2);
    f.setDenominator(4);
    assertEquals(-1, f.getNumerator());
    assertEquals(4, f.getDenominator());
    // confirm simplified:
    assertEquals("-1 / 4", f.toString());
  }

  // ---------- toDouble ----------

  @Test
  void toDoubleWorksForTypicalCases() {
    assertEquals(0.5, new FractionImpl(1, 2).toDouble(), 1e-12);
    assertEquals(-0.25, new FractionImpl(-1, 4).toDouble(), 1e-12);
    assertEquals(0.0, new FractionImpl(0, 7).toDouble(), 1e-12);
  }

  // ---------- toString (simplest form, sign, zero) ----------

  @Test
  void toStringShowsSimplestFormAndPositiveDenominator() {
    assertEquals("2 / 1", new FractionImpl(4, 2).toString());
    assertEquals("-3 / 5", new FractionImpl(-9, 15).toString());
    assertEquals("0 / 1", new FractionImpl(0, 12345).toString());
  }

  @Test
  void reciprocalOfZeroThrows() {
    Fraction z = new FractionImpl(0, 7);
    assertThrows(IllegalArgumentException.class, z::reciprocal);
  }

  // ---------- add ----------

  @Test
  void addCommonDenominator() {
    Fraction a = new FractionImpl(1, 5);
    Fraction b = new FractionImpl(2, 5);
    Fraction sum = a.add(b);
    assertEquals(3, sum.getNumerator());
    assertEquals(5, sum.getDenominator());
  }

  @Test
  void addDifferentDenominatorAndSimplify() {
    Fraction a = new FractionImpl(1, 6);
    Fraction b = new FractionImpl(1, 4);
    Fraction sum = a.add(b); // 1/6 + 1/4 = 5/12
    assertEquals(5, sum.getNumerator());
    assertEquals(12, sum.getDenominator());
  }

  @Test
  void addWithNegativesAndZero() {
    Fraction a = new FractionImpl(-1, 3);
    Fraction b = new FractionImpl(1, 3);
    Fraction sum = a.add(b); // 0
    assertEquals(0, sum.getNumerator());
    assertEquals(1, sum.getDenominator());
  }

  @Test
  void addNullThrows() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(NullPointerException.class, () -> a.add(null));
  }

  // ---------- compareTo ----------

  @Test
  void compareToLessGreaterEqual() {
    Fraction a = new FractionImpl(1, 3);
    Fraction b = new FractionImpl(2, 5);
    Fraction c = new FractionImpl(2, 6); // equals 1/3 after normalization

    assertTrue(a.compareTo(b) < 0, "1/3 < 2/5");
    assertTrue(b.compareTo(a) > 0, "2/5 > 1/3");
    assertEquals(0, a.compareTo(c), "1/3 == 2/6");
  }

  @Test
  void compareToWithNegatives() {
    Fraction a = new FractionImpl(-1, 2);
    Fraction b = new FractionImpl(1, 3);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertEquals(0, a.compareTo(new FractionImpl(-2, 4)));
  }
}
