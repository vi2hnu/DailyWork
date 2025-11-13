package transaction;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionProcessor {
    public void processTransactions(List<Transaction> transactions) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Transaction t : transactions) {
            executor.submit(new TransactionTask(t));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
    }
}
