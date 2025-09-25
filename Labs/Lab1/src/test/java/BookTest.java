import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

  private Book cleanCode;

  @BeforeEach
  void setUp() {
    this.cleanCode = new Book("Clean Code", "Robert C. Martin", 464);
  }

  @Test
  void getTitle() {
    assertEquals("Clean Code", this.cleanCode.getTitle());
  }

  @Test
  void getAuthor() {
    assertEquals("Robert C. Martin", this.cleanCode.getAuthor());
  }

  @Test
  void getPages() {
    assertEquals(464, this.cleanCode.getPages());
  }
}