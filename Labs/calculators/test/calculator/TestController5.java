package calculator;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestController5 {

  @Test
  public void testSimpleAddition() throws IOException {
    // Input as a string
    StringReader in = new StringReader("5 3");

    // Output to System.out
    Controller5 controller = new Controller5(in, System.out);

    // Run the calculator
    controller.go(new Calculator());

    // This should print "8" to the console
  }

  @Test
  public void testAnotherAddition() throws IOException {
    StringReader in = new StringReader("10 20");
    Controller5 controller = new Controller5(in, System.out);
    controller.go(new Calculator());
    // This should print "30" to the console
  }
}
