
package lab03encapsulation;

// Represents a student and protects their information
public class Student {

    // Private fields store the student's name and marks
    private String name;
    private int marks;

    // Constructor initializes the student's details
    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    // Returns the student's name
    public String getName() {
        return name;
    }

    // Validates and updates the student's name
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty.");
        }

        this.name = name;
    }

    // Returns the student's marks
    public int getMarks() {
        return marks;
    }

    // Accepts only marks between 0 and 100
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100.");
        }

        this.marks = marks;
    }

    // Calculates the grade from the current marks
    public char getGrade() {
        if (marks >= 80) {
            return 'A';
        } else if (marks >= 70) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else {
            return 'F';
        }
    }
}
