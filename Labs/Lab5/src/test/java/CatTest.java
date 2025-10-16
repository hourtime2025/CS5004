import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Cat setters, equals, and hashCode.
 */
public class CatTest {

  @Test
  void setter_updatesAge() {
    Cat c = new Cat("Miso", 2, CatColor.CALICO, new Person("Ava"));
    c.setAge(3);
    assertEquals(3, c.getAge());
  }

  @Test
  void setter_updatesOwner() {
    Person ava = new Person("Ava");
    Person ben = new Person("Ben");
    Cat c = new Cat("Miso", 2, CatColor.CALICO, ava);
    c.setOwner(ben);
    assertEquals(ben, c.getOwner());
  }

  @Test
  void equals_positive_sameAllFields() {
    Person owner = new Person("Kai");
    Cat a = new Cat("Luna", 4, CatColor.GRAY, owner);
    Cat b = new Cat("Luna", 4, CatColor.GRAY, new Person("Kai")); // equal owner by name
    assertEquals(a, b);
    assertEquals(b, a); // symmetry
    assertEquals(a, a); // reflexive
    assertNotEquals(a, null); // non-null
  }

  @Test
  void equals_negative_differentName() {
    Person owner = new Person("Kai");
    Cat a = new Cat("Luna", 4, CatColor.GRAY, owner);
    Cat b = new Cat("Nova", 4, CatColor.GRAY, owner);
    assertNotEquals(a, b);
  }

  @Test
  void equals_negative_differentAge() {
    Person owner = new Person("Kai");
    Cat a = new Cat("Luna", 4, CatColor.GRAY, owner);
    Cat b = new Cat("Luna", 5, CatColor.GRAY, owner);
    assertNotEquals(a, b);
  }

  @Test
  void equals_negative_differentColor() {
    Person owner = new Person("Kai");
    Cat a = new Cat("Luna", 4, CatColor.GRAY, owner);
    Cat b = new Cat("Luna", 4, CatColor.BLACK, owner);
    assertNotEquals(a, b);
  }

  @Test
  void equals_negative_differentOwner() {
    Cat a = new Cat("Luna", 4, CatColor.GRAY, new Person("Kai"));
    Cat b = new Cat("Luna", 4, CatColor.GRAY, new Person("Zoe"));
    assertNotEquals(a, b);
  }

  @Test
  void equals_allowsSubclass_instanceofPattern() {
    class FancyCat extends Cat {
      FancyCat(String name, int age, CatColor color, Person owner) {
        super(name, age, color, owner);
      }
    }

    Person owner = new Person("Kai");
    Cat base = new Cat("Luna", 4, CatColor.GRAY, owner);
    Cat sub = new FancyCat("Luna", 4, CatColor.GRAY, new Person("Kai"));
    assertEquals(base, sub);
    assertEquals(sub, base);
  }

  @Test
  void hashCode_equalObjects_sameHash() {
    Cat a = new Cat("Luna", 4, CatColor.GRAY, new Person("Kai"));
    Cat b = new Cat("Luna", 4, CatColor.GRAY, new Person("Kai"));
    assertEquals(a.hashCode(), b.hashCode());
  }

  @Test
  void hashCode_nonEqualUsuallyDifferent() {
    // Not guaranteed, but likely different.
    Cat a = new Cat("Luna", 4, CatColor.GRAY, new Person("Kai"));
    Cat b = new Cat("Nova", 5, CatColor.BLACK, new Person("Zoe"));
    assertNotEquals(a, b);
    // If this ever collides, it's still legal per the contract; the test documents typical behavior.
    assertNotEquals(a.hashCode(), b.hashCode(),
        "Unequal cats produced the same hash; collisions are allowed but uncommon.");
  }
}
