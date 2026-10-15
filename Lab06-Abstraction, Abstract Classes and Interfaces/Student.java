
package lab06abstractinterfaces;

public class Student implements Comparable<Student> {

    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Default sorting: alphabetical order by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " - " + marks + " marks";
    }
}
