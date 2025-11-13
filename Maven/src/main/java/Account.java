class Account {
    private int accountNumber;
    private double balance;
    private Account beneficiary;

    public Account(int accountNumber, double balance, Account beneficiary) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.beneficiary = beneficiary;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBeneficiary(Account account) {
        return account == beneficiary;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
