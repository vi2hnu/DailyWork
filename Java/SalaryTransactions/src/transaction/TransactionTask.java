package transaction;

public class TransactionTask implements Runnable {
    private Transaction transaction;

    public TransactionTask(Transaction transaction) {
        this.transaction = transaction;
    }

    public void run() {
        System.out.println("Processing " + transaction.getAmount() + " from " +
                transaction.getFromAccount() + " to " + transaction.getToAccount());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed transaction for " + transaction.getToAccount());
    }
}
