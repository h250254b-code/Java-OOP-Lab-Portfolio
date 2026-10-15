
package lab04inheritance;

// Teacher inherits common details and behaviour from Person
public class Teacher extends Person {

    private String subject;

    // Initializes inherited fields and the teacher's subject
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Reuses Person's display() method and adds the subject
    @Override
    public void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}
