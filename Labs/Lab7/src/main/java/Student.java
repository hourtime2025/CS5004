public class Student {
  private final String firstName;
  private final String lastName;
  private final String studentId;
  private final String email;

  public Student(String firstName, String lastName, String studentId, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentId = studentId;
    this.email = email;
  }

  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public String getStudentId() { return studentId; }
  public String getEmail() { return email; }

  @Override
  public String toString() {
    return firstName + " " + lastName + " (" + studentId + ") - " + email;
  }
}
