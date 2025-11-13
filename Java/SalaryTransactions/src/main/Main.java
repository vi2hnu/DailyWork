package main;

import transaction.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("transactions.txt");
        Scanner reader = new Scanner(file);
        List<Transaction> transactions = new ArrayList<>();

        while (reader.hasNextLine()) {
            String[] parts = reader.nextLine().split(",");
            transactions.add(new Transaction(parts[0], parts[1], Double.parseDouble(parts[2])));
        }
        reader.close();

        TransactionProcessor processor = new TransactionProcessor();
        processor.processTransactions(transactions);
    }
}
