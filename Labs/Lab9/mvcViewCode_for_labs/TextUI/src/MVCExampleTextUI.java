import java.io.InputStreamReader;

public class MVCExampleTextUI {
  public static void main(String[] args) {
    IModel model = new Model();
    IView view = new TextView(System.out);

    // Wrap System.in as a Readable
    Readable in = new InputStreamReader(System.in);

    // Use the new constructor: (IModel, Readable, IView)
    IController controller = new TextController(model, in, view);
    controller.go();
  }
}
