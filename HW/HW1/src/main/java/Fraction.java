/**
 * A rational number with an integer numerator and a positive integer denominator.
 * <p>
 * All {@code Fraction} instances conceptually represent {@code numerator / denominator}.
 * The denominator is always positive; if the overall value is negative, the sign appears
 * on the numerator. Implementations should normalize results returned from operations
 * (e.g., reciprocals, sums) to simplest terms with a positive denominator.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction. The sign of the fraction is carried by the numerator.
   *
   * @return the (possibly negative) integer numerator
   */
  int getNumerator();

  /**
   * Returns the (always positive) denominator of this fraction.
   *
   * @return the positive integer denominator
   */
  int getDenominator();

  /**
   * Sets the numerator of this fraction. Implementations should maintain normalization
   * (e.g., handle {@code 0} specially and reduce if needed).
   *
   * @param n the (possibly negative) numerator to set
   */
  void setNumerator(int n);

  /**
   * Sets the denominator of this fraction. The denominator must be strictly positive.
   * Implementations must throw {@link IllegalArgumentException} if {@code d <= 0} and
   * maintain the class invariant that denominators are always positive. Implementations
   * should also keep the fraction in simplest terms after the change.
   *
   * @param d the new denominator; must be {@code > 0}
   * @throws IllegalArgumentException if {@code d <= 0}
   */
  void setDenominator(int d);

  /**
   * Returns the decimal (scientific) value of this fraction.
   *
   * @return the value of {@code numerator / denominator} as a {@code double}
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction, i.e., {@code denominator / numerator}.
   * The result must follow the same sign and positivity rules (denominator positive,
   * sign on numerator) and be returned in simplest form.
   *
   * @return a new {@code Fraction} that is the reciprocal of this one
   * @throws IllegalArgumentException if the numerator is {@code 0} (reciprocal undefined)
   */
  Fraction reciprocal();

  /**
   * Returns the sum of this fraction and {@code other}, normalized to simplest terms with
   * a positive denominator.
   *
   * @param other the addend; must not be {@code null}
   * @return a new {@code Fraction} equal to {@code this + other}
   * @throws NullPointerException if {@code other} is {@code null}
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to {@code other} using exact arithmetic (no double rounding).
   * Returns a negative integer, zero, or a positive integer if this fraction is less than,
   * equal to, or greater than the specified fraction, respectively.
   *
   * @param other the fraction to compare to; must not be {@code null}
   * @return a negative integer, zero, or a positive integer as this object is less than,
   *     equal to, or greater than the specified object
   * @throws NullPointerException if {@code other} is {@code null}
   */
  @Override
  int compareTo(Fraction other);
}

