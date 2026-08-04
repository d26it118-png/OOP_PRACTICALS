import java.util.Scanner;

public class A1_vendingmachine   {

    // declare coins
    enum CurrencyCoins {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) {
        int itemPrice = 15;
        int totalInserted = 0;

        System.out.println("Snack Price: " + itemPrice + "\nPlease Insert Coins (ONE, TWO, FIVE, TEN):\n");

        // create object of Scanner class to take user input
        Scanner scanner = new Scanner(System.in);

        while (totalInserted < itemPrice) {
            // take coins value
            System.out.print("Coins: ");
            String userInput = scanner.next().toUpperCase();

            CurrencyCoins selectedCoin;

            try {
                selectedCoin = CurrencyCoins.valueOf(userInput);
            } catch (Exception e) {
                System.out.println("Please enter a Valid Coin.\n!! Try Again !!\n");
                continue;
            }

            int coinValue = 0;

            switch (selectedCoin) {
                case ONE:
                    coinValue = 1;
                    break;
                case TWO:
                    coinValue = 2;
                    break;
                case FIVE:
                    coinValue = 5;
                    break;
                case TEN:
                    coinValue = 10;
                    break;
            }

            totalInserted += coinValue;
            System.out.println("Inserted so far: " + totalInserted);
        }

        System.out.println("Paid. Change: " + (totalInserted - itemPrice));
        scanner.close();
    }
}