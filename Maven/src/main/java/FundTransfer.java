class FundTransfer {
    public static String transfer(Account from, Account to, double amount) {
        if (!from.isBeneficiary(to)) {
            return "Transfer failed: destination is not the beneficiary of source account";
        }
        if (from.getBalance() < amount) {
            return "Transfer failed: insufficient balance";
        }

        if (from.withdraw(amount)) {
            to.deposit(amount);
            return "Transferred " + amount + " from source to beneficiary";
        }
        else{
            return "error";
        }
    }
}