package calculator;

import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator. In this example, the
 * model and controller are factored out.
 */
public class SimpleCalc3 {
  public static void main(String[] args) {
    new Controller3().go(new Calculator());  // OK now, Calculator implements CalcModel
  }
}

class Controller3 implements CalcController {
  @Override
  public void go(CalcModel calc) {
    Objects.requireNonNull(calc);
    Scanner scan = new Scanner(System.in);
    int num1 = scan.nextInt();
    int num2 = scan.nextInt();
    System.out.printf("%d", calc.add(num1, num2));
  }
}


