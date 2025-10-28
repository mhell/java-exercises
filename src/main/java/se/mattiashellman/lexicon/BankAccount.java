package se.mattiashellman.lexicon;

public class BankAccount {
    private static int accountNumbers;
    private int accountNumber;
    private int balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    BankAccount(int balance, String customerName, String email, String phoneNumber) {
        setAccountNumber(accountNumbers++);
        setBalance(balance);
        setCustomerName(customerName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit (int amount) {
        balance += amount;
    }

    public void withdraw (int amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Withdrawal amount exceeded by " + (amount-balance));
        balance -= amount;
    }

    public static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100, "Erik", "erik@erik.se", "0705287778");
        bankAccount.deposit(100);
        try {
            bankAccount.withdraw(500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Account number: " + bankAccount.getAccountNumber());
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}
