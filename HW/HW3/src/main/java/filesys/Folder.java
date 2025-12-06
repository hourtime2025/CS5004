package filesys;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a folder (directory) in the pretend file system.
 * A folder can contain other folders and files as children.
 */
public class Folder extends FileSys {

  private List<FileSys> children;

  /**
   * Constructs a folder with the given name.
   *
   * @param name the folder name
   */
  public Folder(String name) {
    super(name);
    this.children = new ArrayList<>();
  }

  /**
   * Adds a child node (file or folder) to this folder.
   *
   * @param child the node to add
   */
  public void addNode(FileSys child) {
    this.children.add(child);
  }

  @Override
  public void prettyPrintName(String indent) {
    // print this folder itself
    System.out.println(indent + "d " + getName());

    // then print all children with one extra level of indent
    for (FileSys child : children) {
      child.prettyPrintName(indent + "    ");
    }
  }
}
