package main;
import java.io.*;
import java.util.*;
import transaction.*;
import payment.*;
import record.AccountRecord;
import record.TransactionRecord;
import account.*;
import java.nio.file.*;
import record.BeneficiaryRecord;
import Comparator.AccountComparator;

public class Main {
    private static TransactionImplementation handler = new TransactionImplementation();
    public static String reply(String msg) {
        return switch (msg.toLowerCase()) {
            case "hi", "hello" -> {
                yield """
                    Hey there,
                    Nice to see you.
                    """;
            }
            case "bye", "goodbye" -> {
                yield """
                    See you later,
                    Take care.
                    """;
            }
            default -> {
                yield """
                    Hmm,
                    I don’t know what to say.
                    """;
            }
        };
    }
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        var lines = Files.readAllLines(Paths.get("input.txt"));        
        Scanner reader = new Scanner(file);
        ArrayList<AccountRecord> accounts = new ArrayList<AccountRecord>();
        Map<String,Account> dict = new HashMap<>();
        
        while (reader.hasNextLine()) {
            String line = reader.nextLine().trim();
            if (line.isEmpty()) continue;

            var parts = line.split(",");

            String senderName = parts[0];
            String senderCountry = parts[1];
            String senderAccNum = parts[2];
//            String senderIfsc = parts[3];
            double senderBalance = Double.parseDouble(parts[4]);
            double amount = Double.parseDouble(parts[5]);
            String paymentType = parts[6];
            AccountRecord senderRecord = new AccountRecord(senderName,senderCountry,senderAccNum);
            
            String receiverName = parts[7];
            String receiverCountry = parts[8];
            String receiverAccNum = parts[9];
//            String receiverIfsc = parts[10]; 
            AccountRecord receiverRecord = new AccountRecord(receiverName,receiverCountry,receiverAccNum);
            Account sender = new Account(senderName, senderCountry, senderAccNum, senderBalance);
            Account receiver = new Account(receiverName, receiverCountry, receiverAccNum, 0);
            accounts.add(senderRecord);
            accounts.add(receiverRecord);
            PaymentProcess payment = null;
            BeneficiaryRecord b = new BeneficiaryRecord(senderName,senderAccNum);
            if(b.validate()==true) {
            	System.out.print("Benificiary detected");
            }
            if (paymentType.equalsIgnoreCase("NEFT")) {
                payment = new Neft(handler);
            }
            
            if (payment != null) {
            	TransactionRecord transaction = new TransactionRecord(sender,receiver,amount);
                payment.makePayment(transaction);
                System.out.println("Transaction complete: " + senderRecord.name()+", "+senderRecord.accountNo() + " to " + receiverRecord.name()+", "+senderRecord.accountNo());
                System.out.println("Sender balance: " + sender.getBalance());
                System.out.println("Receiver balance: " + receiver.getBalance());
            }
            if(dict.containsKey(sender.getAccountNumber())) {
            	dict.get(sender.getAccountNumber()).reduceAmount(amount);
            }
            else {
            	dict.put(senderAccNum, sender);
            }
            if(dict.containsKey(receiver.getAccountNumber())) {
            	dict.get(receiver.getAccountNumber()).addAmount(amount);
            }
            else {
            	dict.put(receiverAccNum, receiver);
            }
            System.out.println();
        }
        double total = lines.stream()
        		.map(String::trim)
        		.filter(line -> !line.isEmpty())
                .map(line -> line.split(","))
                .filter(parts -> parts[3].startsWith("HDFC"))
                .mapToDouble(parts -> Double.parseDouble(parts[5])) 
                .sum();
        System.out.println("total by hdfc "+total);
        
        accounts.stream().sorted(new AccountComparator()).forEach(System.out::println);
        ArrayList<Account> acc = new ArrayList<>();
        for(String key:dict.keySet()) {
        	acc.add(dict.get(key));
        }
        acc.stream().sorted((x,y)->Double.compare(x.getBalance(), y.getBalance())).forEach(a -> System.out.println(a.getAccountNumber()));
        
        System.out.print(reply("Hi"));
        reader.close();
    }
}
