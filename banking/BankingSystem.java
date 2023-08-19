import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {

    private Map<String, Double> accountBalances;

    public BankingSystem() {
        accountBalances = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accountBalances.containsKey(accountNumber)) {
            accountBalances.put(accountNumber, initialBalance);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            accountBalances.put(accountNumber, currentBalance + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                accountBalances.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public double getBalance(String accountNumber) {
        return accountBalances.getOrDefault(accountNumber, 0.0);
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bankingSystem.createAccount(accountNumber, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankingSystem.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankingSystem.withdraw(accountNumber, withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    double balance = bankingSystem.getBalance(accountNumber);
                    System.out.println("Account balance: " + balance);
                    break;
                case 5:
                    System.out.println("Exiting the banking system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}