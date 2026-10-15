
package lab09enumsrecords;

public enum Coin {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Return the fewest coins needed for an amount
    public static int fewestCoins(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative."
            );
        }

        int count = 0;

        for (Coin coin : Coin.values()) {
            count += amount / coin.getValue();
            amount %= coin.getValue();
        }

        return count;
    }
}
