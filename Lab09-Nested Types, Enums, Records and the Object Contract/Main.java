
package lab09enumsrecords;

public class Main {

    public static void main(String[] args) {

        int amount = 67;

        System.out.println("Available coins:");

        for (Coin coin : Coin.values()) {
            System.out.println(
                coin + " = " + coin.getValue() + " cent(s)"
            );
        }

        System.out.println("\nAmount: " + amount + " cents");
        System.out.println(
            "Fewest coins required: " + Coin.fewestCoins(amount)
        );

        // Show the combination for 67 cents
        System.out.println("Coin combination:");

        int remaining = amount;

        for (Coin coin : Coin.values()) {
            int number = remaining / coin.getValue();

            if (number > 0) {
                System.out.println(coin + ": " + number);
            }

            remaining %= coin.getValue();
        }
    }
}
