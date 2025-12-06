package filesys;

/**
 * Abstract base class representing a node in the pretend file system.
 * Both files and folders extend this class.
 */
public abstract class FileSys {

  private String name;

  /**
   * Constructs a FileSys node with the given name.
   *
   * @param name the name of the file or folder
   */
  public FileSys(String name) {
    this.name = name;
  }

  /**
   * Returns the name of this node.
   *
   * @return the node name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Pretty-prints this node's name using the given indentation.
   *
   * @param indent leading whitespace for this node
   */
  public abstract void prettyPrintName(String indent);
}
