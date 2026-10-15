
package lab06abstractinterfaces;

public class CurrentAccount extends Account {

    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public double monthlyFee() {
        return 5.00;
    }
}
