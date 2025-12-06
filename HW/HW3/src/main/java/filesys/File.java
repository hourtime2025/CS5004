package filesys;

/**
 * Represents a file (leaf node) in the pretend file system.
 * Files cannot contain children.
 */
public class File extends FileSys {

  /**
   * Constructs a file with the given name.
   *
   * @param name the file name
   */
  public File(String name) {
    super(name);
  }

  @Override
  public void prettyPrintName(String indent) {
    // files have no "d " prefix
    System.out.println(indent + getName());
  }
}
