
package lab05polymorphism;

// Employee paid according to hours worked
public class PartTimeEmployee extends Employee {

    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(
            String name, double hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePay() {
        return hoursWorked * hourlyRate;
    }
}
