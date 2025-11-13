package main;

import exception.*;

public class Main {
    public static void main(String[] args) {
        try {
            double balance = 5000;
            double withdrawAmount = 7000;

            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Withdrawal exceeds balance!");
            }

            String accountNumber = null;
            if (accountNumber == null || accountNumber.isEmpty()) {
                throw new InvalidAccountException("Invalid account number!");
            }

        } catch (BusinessRuleException e) {
            System.out.println("Business rule violated: " + e.getMessage());
        }
    }
}
