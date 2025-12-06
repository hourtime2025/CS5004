import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class TextController implements IController {
  private final Scanner in;
  private final IView view;
  private final IModel model;

  /**
   * Construct a TextController that reads from any Readable.
   * In tests you can use a StringReader; in main you can still use System.in.
   */
  public TextController(IModel model, Readable readable, IView view) {
    this.model = Objects.requireNonNull(model);
    this.view = Objects.requireNonNull(view);
    Objects.requireNonNull(readable);
    this.in = new Scanner(readable);
  }

  @Override
  public void go() {
    boolean quit = false;

    while (!quit && in.hasNext()) {
      // tell view to show the string so far
      view.showString(this.model.getString());
      // tell view to show options
      view.showOptions();
      // accept user input
      String option = in.next();
      switch (option) {
        // View and controller must agree on these signals (E and Q)
        case "E":
          // ask for string input
          view.showStringEntry();
          in.nextLine();              // consume end of line after "E"
          if (!in.hasNextLine()) {
            quit = true;              // or handle as error
            break;
          }
          String input = in.nextLine();
          // give to model
          model.setString(input);
          break;
        case "Q":
          quit = true;
          break;
        default:
          view.showOptionError();
      }
    }
  }
}
