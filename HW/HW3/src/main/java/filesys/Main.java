package filesys;

/**
 * Demonstrates the pretend file system tree using the Composite pattern.
 */
public class Main {
  public static void main(String[] args) {
    Folder root = new Folder("root");
    Folder home = new Folder("home");
    Folder mlmiller = new Folder("mlmiller");

    File markFileA = new File("markFileA.txt");
    File markFileB = new File("markFileB.txt");

    // build the hierarchy
    root.addNode(home);
    home.addNode(mlmiller);
    mlmiller.addNode(markFileA);
    mlmiller.addNode(markFileB);

    // pretty-print the whole tree
    root.prettyPrintName("");
  }
}
