import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

  @Test
  void getString_defaultsToEmptyAndReflectsLastSetValue() {
    IModel model = new Model();

    // first assertion: default state
    assertEquals("", model.getString());

    // second assertion: after setString
    model.setString("hello");
    assertEquals("hello", model.getString());
  }

  @Test
  void setString_handlesEmptyAndOverwritesPreviousValue() {
    IModel model = new Model();
    model.setString("first");
    model.setString("");  // overwrite with empty

    // two assertions for setString behavior
    assertEquals("", model.getString());
    model.setString("second");
    assertEquals("second", model.getString());
  }
}

