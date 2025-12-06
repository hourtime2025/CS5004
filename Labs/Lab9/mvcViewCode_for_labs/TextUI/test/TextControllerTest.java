import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

class TextControllerTest {

  @Test
  void go_updatesModelWhenUserEntersString() {
    // Simulate: E + "hello" + Q
    Readable input = new StringReader("E\nhello\nQ\n");
    StringBuilder out = new StringBuilder();

    IModel model = new Model();
    IView view = new TextView(out);
    IController controller = new TextController(model, input, view);

    controller.go();

    // 1: model got updated
    assertEquals("hello", model.getString());

    // 2: view output contains the entered string somewhere
    assertTrue(out.toString().contains("hello"));
  }

  @Test
  void go_handlesInvalidOptionAndQuit() {
    // Simulate: X (invalid), then Q
    Readable input = new StringReader("X\nQ\n");
    StringBuilder out = new StringBuilder();

    IModel model = new Model();
    IView view = new TextView(out);
    IController controller = new TextController(model, input, view);

    controller.go();

    String text = out.toString();

    // two assertions about behavior
    assertTrue(text.toLowerCase().contains("invalid")); // error printed
    assertEquals("", model.getString());                // model unchanged
  }
}

