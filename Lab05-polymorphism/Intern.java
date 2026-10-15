
package lab05polymorphism;

// Intern receives a fixed stipend
public class Intern extends Employee {

    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}
