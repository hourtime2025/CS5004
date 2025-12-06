package calculator;

import org.junit.jupiter.api.Test;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

public class TestController7Mock {

  @Test
  public void testController7WithMockModel() throws Exception {
    StringReader in = new StringReader("+ 3 4 q");
    StringWriter out = new StringWriter();

    MockCalcModel mock = new MockCalcModel();
    Controller7 controller = new Controller7(in, out);

    controller.go(mock);

    String log = mock.getLog().trim();

    // Check that add() was called with WRONG arguments due to +1, -1
    // Expected correct call: "Passed: 3 and 4"
    // Actual buggy call will be: "Passed: 4 and 3"
    assertNotEquals("Passed: 3 and 4", log, "Controller7 should FAIL mock test");

    // When you fix Controller7, change this assertion to:
    // assertEquals("Passed: 3 and 4", log);
  }
}
