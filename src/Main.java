import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        BankAccount bankAccount = new BankAccount("Rifky Sultan", "001982929");
        bankAccount.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String name, String id) {
        customerName = name;
        customerId = id;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withDraw(int amount) {
        if (amount != 0) {
            int currentBalance = balance;
            if ((currentBalance -= amount) < 0) {
                System.out.println("Sorry, your currently balance is " + balance + ", you can't withdrawn more than current balance");
            } else {
                balance -= amount;
                previousTransaction = -amount;
            }
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("With drawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=========================================================================");
            System.out.println("Enter option ");
            System.out.println("=========================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Your balance is " + balance);
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("-----------------------------------------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Enter an amount to withdrawn: ");
                    System.out.println("-----------------------------------------------------------------------");
                    int withdrawn = scanner.nextInt();
                    withDraw(withdrawn);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("-----------------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("************************************************************************");
                    break;
                default:
                    System.out.println("Invalid operation! Please enter again");
                    break;
            }
        } while (option != 'E');

        System.out.println("Thank you for using our services");
    }

}
