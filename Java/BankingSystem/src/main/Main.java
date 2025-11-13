package main;
import Login.LoginImplementation;
import Login.LoginInterface;
import java.util.*;
import payment.*;
import transaction.*;
import user.User;


public class Main {
	private static Scanner input = new Scanner(System.in);
    public static void makePayment(User fromUser) {
        System.out.println("Enter username and account number of the account you want to transfer money to:");
        String username = input.next();
        Long accountNumber = input.nextLong();
        User toUser = new User(username, accountNumber, "password"); 
        System.out.println("Enter amount to transfer:");
        double amount = input.nextDouble();
        System.out.println("Select mode of payment :\n1. UPI\n2. Net Banking\n3. Card Payment\n4. Wallet");
        int choice = input.nextInt();
        TransactionInterface transactionHandler = new TransactionImplementation();
        switch (choice) {
            case 1:
                System.out.println("UPI Payment Selected");
                Upi upiPayment = new Upi(transactionHandler);
                upiPayment.makePayment(fromUser, toUser, amount);
                break;
            case 2:
                System.out.println("Net Banking Selected");
                NetBanking netBankingPayment = new NetBanking(transactionHandler);
                netBankingPayment.makePayment(fromUser, toUser, amount);
                break;
            case 3:
                System.out.println("Card Payment Selected");
                CreditCard cardPayment = new CreditCard(transactionHandler);
                cardPayment.makePayment(fromUser, toUser, amount);
                break;
            case 4:
                System.out.println("Wallet Payment Selected");
                Wallet walletPayment = new Wallet(transactionHandler);
                walletPayment.makePayment(fromUser, toUser, amount);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }   
    
    public static void addBene(User user) {
        System.out.println("Enter beneficiary name and account number:");
        String beneName = input.next();
        Long beneAccNum = input.nextLong();
        user.addBeneficiary(new User(beneName,beneAccNum,"password")); //hardcoding password for demonstration purpose in real time we would find the user from db
        System.out.println("Beneficiary added successfully.");
    }
    
    public static void main(String[] args) {
        LoginInterface loginHandler = new LoginImplementation();
        System.out.println("Enter username, account number and password:");
        String username = input.next();
        Long accountNumber = input.nextLong();
        String password = input.next();
        User user = loginHandler.login(username, accountNumber, password);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option: 1. Transaction 2. Add beneficiary 3. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    makePayment(user);
                    break;
                case 2:
                    addBene(user);
                    break;
                case 3:
                    exit = true;   
                    break;
            }
        }
        input.close();
    }
}
