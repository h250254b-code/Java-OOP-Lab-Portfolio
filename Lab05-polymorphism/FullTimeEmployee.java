
package lab05polymorphism;

// Employee who receives a fixed monthly salary
public class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}
