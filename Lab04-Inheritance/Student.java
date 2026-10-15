
package lab04inheritance;

// Student inherits the fields and methods from Person
public class Student extends Person {

    private String course;

    // Constructor passes name and age to the parent constructor
    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    // Displays the inherited details and the student's course
    @Override
    public void display() {
        super.display();
        System.out.println("Course: " + course);
    }
}
