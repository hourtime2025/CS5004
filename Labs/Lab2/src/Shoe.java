/**
 * Represents a shoe with a kind, color, brand, and size.
 * <p>Some colors are grouped to default labels (e.g., "Neutral").</p>
 */

public class Shoe {
  private Kind kind;    //enum
  private Color color;  //enum
  private Brand brand;  //enum
  private double size;  //numeric val


  /**
   * Constructs a Shoe.
   * Throws IllegalArgumentException if brand == NIKE and kind == DRESS.
   * */
  /**
   * Constructs a {@code Shoe}.
   *
   * @param kind  the kind of shoe (e.g., SNEAKER, DRESS)
   * @param color the color of the shoe (e.g., ORANGE, GREEN, BLUE)
   * @param brand the brand of the shoe
   * @param size  the numeric size (e.g., 9.5)
   * @throws IllegalArgumentException if {@code brand == NIKE && kind == DRESS}
   *                                  or if {@code size <= 0} or any enum is {@code null}
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (kind == null || color == null || brand == null) {
      throw new IllegalArgumentException("kind, color, brand must be non-null");
    }
    if (size <= 0) {
      throw new IllegalArgumentException("size must be positive");
    }
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("Dress is not a valid shoe kind for NIKE");
    }

    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }
  // Getters: the tiny public method to return (read) a private field’s value—part of encapsulation.
  /** @return the kind of this shoe */
  public Kind getKind()   { return kind; }
  /** @return the color of this shoe */
  public Color getColor() { return color; }
  /** @return the brand of this shoe */
  public Brand getBrand() { return brand; }
  /** @return the size of this shoe */
  public double getSize() { return size; }

  // promises replacing Object.toString() with my own version (the compiler will warn if the signature is wrong).
  /**
   * Returns a human-readable summary using default color categories and
   * custom brand/kind capitalization.
   *
   * @return summary string, e.g. {@code "Nike Sneaker in Neutral (size 9.5)"}.
   */
  @Override
  public String toString() {
    String brandStr = displayBrand(brand);
    String kindStr  = displayKind(kind);
    String colorStr = displayColor(color);
    return String.format("%s %s in %s (size %.1f)", brandStr, kindStr, colorStr, size);
  }

  // --- helpers that use switch for custom spelling/capitalization ---
  private String displayKind(Kind k) {
    return switch (k) {
      case SNEAKER -> "Sneaker";
      case BOOT -> "Boot";
      case SANDAL -> "Sandal";
      case DRESS -> "Dress";
    };
  }

  private String displayBrand(Brand b) {
    return switch (b) {
      case NIKE   -> "Nike";
      case UGG    -> "Ugg";
      case PUMA   -> "Puma";
    };
  }

  private String displayColor(Color c) {
    return switch (c) {
      case GREEN, BLUE -> "Neutral";   // group into Neutral
      // no pastel defined in enum, so just use default for ORANGE
      default -> titleCase(c.name());  // ORANGE -> "Orange"
    };
  }

  private String titleCase(String s) {
    s = s.toLowerCase();
    return Character.toUpperCase(s.charAt(0)) + s.substring(1);
  }



}
