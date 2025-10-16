import java.util.Objects;

/**
 * Concrete implementation of {@link Fraction}. Instances maintain the invariant that the
 * denominator is positive and the fraction is stored in simplest terms. The sign of the value
 * is always carried by the numerator (e.g., -1/2, never 1/-2).
 */
public final class FractionImpl implements Fraction {

  private int numerator;
  private int denominator; // always > 0

  /**
   * Constructs a {@code FractionImpl} with the given numerator and denominator.
   * <p>
   * The denominator must be strictly positive. If the value is negative, the sign will be
   * carried by the numerator. The resulting fraction is reduced to simplest terms.
   *
   * @param numerator   the (possibly negative) numerator
   * @param denominator the (strictly positive) denominator
   * @throws IllegalArgumentException if {@code denominator <= 0}
   */
  public FractionImpl(int numerator, int denominator) {
    setAndNormalize(numerator, denominator);
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    // Reuse centralized normalization to avoid duplicate validation logic.
    setAndNormalize(n, this.denominator);
  }

  @Override
  public void setDenominator(int d) {
    // Centralized validation/normalization.
    setAndNormalize(this.numerator, d);
  }

  @Override
  public double toDouble() {
    return (double) numerator / (double) denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (this.numerator == 0) {
      throw new IllegalArgumentException("Cannot take reciprocal of a zero numerator.");
    }
    // Swap num/den, sign should end up on the (new) numerator after normalization.
    return new FractionImpl(this.denominator, this.numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    Objects.requireNonNull(other, "other must not be null");
    // a/b + c/d = (ad + bc) / bd
    long a = this.numerator;
    long b = this.denominator;
    long c = other.getNumerator();
    long d = other.getDenominator();

    long num = a * d + b * c;
    long den = b * d;

    // num and den fit within 64-bit long here; constructor will normalize & check.
    return new FractionImpl((int) num, (int) den);
  }

  @Override
  public int compareTo(Fraction other) {
    Objects.requireNonNull(other, "other must not be null");
    // Compare a/b ? c/d by sign of (ad - cb), using 64-bit to avoid overflow for int ranges.
    long lhs = (long) this.numerator * (long) other.getDenominator();
    long rhs = (long) other.getNumerator() * (long) this.denominator;
    return Long.compare(lhs, rhs);
  }

  /**
   * Returns a string as "n / d" where the fraction is in simplest terms and the denominator is
   * positive. Zero is rendered as "0 / 1".
   */
  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }

  // -------------------- Private helpers --------------------

  /**
   * Validates and normalizes the (n, d) pair into simplest terms, preserving the invariants:
   * denominator > 0 and sign on numerator. If n == 0, denominator is set to 1.
   */
  private void setAndNormalize(int n, int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be > 0");
    }

    if (n == 0) {
      // Canonical zero: 0/1
      this.numerator = 0;
      this.denominator = 1;
      return;
    }

    // Ensure denominator positive; carry sign via numerator only.
    // (d is already > 0 by check above; if it were negative, we'd flip both signs.)
    int g = gcd(Math.abs(n), d);
    n /= g;
    d /= g;

    // If denominator somehow negative (defensive), flip both signs.
    if (d < 0) {
      n = -n;
      d = -d;
    }

    this.numerator = n;
    this.denominator = d;
  }

  /**
   * Euclid's algorithm for greatest common divisor of two nonnegative integers.
   * Accepts zero arguments as well (gcd(x, 0) == x). Uses iteration to avoid deep recursion.
   *
   * @param a nonnegative integer
   * @param b nonnegative integer
   * @return gcd(a, b) >= 0
   */
  private static int gcd(int a, int b) {
    // Handle potential negative inputs defensively (callers pass abs, but keep robust).
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a == 0 ? 1 : a; // gcd(0,0) treated as 1 to avoid division by zero in normalization
  }
}

