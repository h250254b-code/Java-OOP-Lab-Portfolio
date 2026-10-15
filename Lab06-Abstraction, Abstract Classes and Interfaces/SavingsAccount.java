
package lab06abstractinterfaces;

public class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double monthlyFee() {
        return 2.00;
    }
}
