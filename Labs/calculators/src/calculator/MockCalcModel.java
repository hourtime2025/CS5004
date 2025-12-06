package calculator;

public class MockCalcModel implements CalcModel {

  private final StringBuilder log;

  public MockCalcModel() {
    this.log = new StringBuilder();
  }

  @Override
  public int add(int a, int b) {
    log.append("Passed: ").append(a).append(" and ").append(b);
    log.append(System.lineSeparator());
    // Returning a dummy value; controller shouldn't care in this lab
    return -12345;
  }

  public String getLog() {
    return log.toString();
  }
}
