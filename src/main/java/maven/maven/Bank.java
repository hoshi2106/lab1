
package maven.maven;

public class Bank {

    private double balance;

    public Bank(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Invalid initial balance");
        }
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    // Main function
    public static void main(String[] args) {

        Bank bank = new Bank(5000);

        System.out.println("Initial Balance: " + bank.getBalance());

        bank.deposit(2000);
        System.out.println("After Deposit: " + bank.getBalance());

        bank.withdraw(1000);
        System.out.println("After Withdrawal: " + bank.getBalance());

        System.out.println("Current Balance: " + bank.getBalance());
    }
}
