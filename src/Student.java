
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
public class Student {
  private int rating = 0;
  private String name = null;
  public static int count = 0;
  private static int totalRating = 0;

  public Student(String name, int rating) {
    this.name = name;
    this.rating = rating;
    count++;
    totalRating += rating;
  }

  public Student(String name) {
    this.name = name;
    count++;
  }

  public Student() {
    count++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
    totalRating += rating;
  }

  public boolean betterStudent(Student student) {
    return rating > student.rating;
  }

  public void changeRating(int rating) {
    totalRating -= this.rating;
    setRating(rating);
  }

  public static void removeStudent(Student student) {
    count--;
    totalRating -= student.rating;
  }

  @Override
  public String toString() {
    return this.name + " " + this.rating;
  }

  public static double getAvgRating() {
    double sumRating = totalRating;
    double sumStudents = count;
    double avg = sumRating / sumStudents;
    if (count > 0) {
      return avg;
    } else {
      return 0.0;
    }
  }

  public static void main(String[] args) {
    Student student1 = new Student ("Petro", 10);
    Student student2 = new Student ("Masha", 10);
    Student student3 = new Student ("Jhon", 10);
    System.out.println(getAvgRating());
    student1.changeRating(40);
    System.out.println(getAvgRating());


  }
}
