
package lab05polymorphism;

// Parent class for all employees
public abstract class Employee {

    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Subclasses must calculate their own pay
    public abstract double calculatePay();
}
