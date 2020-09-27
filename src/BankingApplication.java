import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("John Dow", "007");
        bankAccount.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    String getPreviousTransaction() {
        if (previousTransaction > 0) {
            return new String("Depeposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            return new String("Withdrawn: " + -previousTransaction);
        } else {
            return new String("No transaction occurred");
        }
    }

    void message(String message) {
        System.out.println("---------------------------------");
        System.out.println(message);
        System.out.println("---------------------------------");
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Welcome %s \nYour ID is %s \n\n", customerName, customerId);


        do {
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("=================================");
            System.out.println("Enter option");
            System.out.println("=================================");
            option = scanner.next().toUpperCase().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    message("Balance = " + balance);
                    System.out.println("\n");
                    break;

                case 'B':
                    message("Enter an amount to deposit:");
                    int deposit = scanner.nextInt();
                    deposit(deposit);
                    System.out.println("\n");
                    break;

                case 'C':
                    message("Enter an amount to withdraw:");
                    int withdraw = scanner.nextInt();
                    withdraw(withdraw);
                    System.out.println("\n");
                    break;

                case 'D':
                    message(getPreviousTransaction());
                    System.out.println("\n");
                    break;

                case 'E':
                    break;

                default:
                    System.out.println("Invalid option! Please try again");
            }
        } while (option != 'E');

        System.out.println("Thank You for using our services!");
    }
}