import java.io.IOException;
import java.util.Objects;

public class TextView implements IView {
  private final Appendable out;

  public TextView(Appendable out) {
    this.out = Objects.requireNonNull(out);
  }

  @Override
  public void showString(String s) {
    try {
      out.append("String: ")
          .append(s)
          .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to out failed", e);
    }
  }

  @Override
  public void showOptions() {
    try {
      out.append("Menu: ").append(System.lineSeparator());
      out.append("E: Enter a string").append(System.lineSeparator());
      out.append("Q: Quit the program").append(System.lineSeparator());
      out.append("Enter your choice: ");
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to out failed", e);
    }
  }

  @Override
  public void showStringEntry() {
    try {
      out.append("\nEnter the string to be echoed: ");
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to out failed", e);
    }
  }

  @Override
  public void showOptionError() {
    try {
      out.append("\nInvalid option.\n");
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to out failed", e);
    }
  }
}
