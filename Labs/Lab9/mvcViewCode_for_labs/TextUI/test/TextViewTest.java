import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextViewTest {

  @Test
  void showString_appendsLabelAndValue() {
    StringBuilder out = new StringBuilder();
    IView view = new TextView(out);

    view.showString("hi");

    String text = out.toString();
    assertTrue(text.contains("String:"));
    assertTrue(text.contains("hi"));
  }

  @Test
  void showOptions_printsBothOptions() {
    StringBuilder out = new StringBuilder();
    IView view = new TextView(out);

    view.showOptions();

    String text = out.toString();
    assertTrue(text.contains("E")); // mentions E
    assertTrue(text.contains("Q")); // mentions Q
  }

  @Test
  void showStringEntry_promptsUser() {
    StringBuilder out = new StringBuilder();
    IView view = new TextView(out);

    view.showStringEntry();

    String text = out.toString();
    assertTrue(text.toLowerCase().contains("enter"));
    assertTrue(text.toLowerCase().contains("string"));
  }

  @Test
  void showOptionError_printsErrorMessage() {
    StringBuilder out = new StringBuilder();
    IView view = new TextView(out);

    view.showOptionError();

    String text = out.toString();
    assertTrue(text.toLowerCase().contains("invalid"));
    assertTrue(text.toLowerCase().contains("option"));
  }
}
