package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

public class TestController7 {

    @Test
    public void testSimpleAddition() throws IOException {
      // Input as a string
      StringReader in = new StringReader("+ 5 3 + 11 12 q");

      // Output to a StringBuilder
      StringBuilder out = new StringBuilder();

      Controller7 controller = new Controller7(in, out);

      // Run the calculator
      controller.go(new Calculator());

      // This should print "8 and then 23" to the console
      // System.out.println(out);

      assertEquals("8\n23\n", out.toString());
    }
  }
