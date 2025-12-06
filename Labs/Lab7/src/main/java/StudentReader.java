import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();

    Path path = Paths.get("students.txt");

    try (BufferedReader br = Files.newBufferedReader(path)) {
      String line;

      while ((line = br.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) continue;

        String[] parts = line.split("\\s+");
        if (parts.length != 4) {
          System.out.println("Skipping malformed line: " + line);
          continue;
        }

        Student s = new Student(parts[0], parts[1], parts[2], parts[3]);
        students.add(s);
      }
    } catch (IOException e) {
      System.out.println("Could not read file: " + e.getMessage());
      return;
    }

    int lineNumber = 1;
    for (Student s : students) {
      System.out.println(lineNumber + ": " + s);
      lineNumber++;
    }
  }
}

