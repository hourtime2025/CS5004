import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person alex;

  @BeforeEach
  void setUp() {
    this.alex = new Person("Alex White", "alex.white@gmail.com", "San Jose, CA, USA");
  }
  @Test
  void getName() {
    assertEquals("Alex White", this.alex.getName());
  }

  @Test
  void getEmail() {
    assertEquals("alex.white@gmail.com", this.alex.getEmail());
  }

  @Test
  void getAddress() {
    assertEquals("San Jose, CA, USA", this.alex.getAddress());
  }
}