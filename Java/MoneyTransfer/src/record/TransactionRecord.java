package record;
import account.Account;

public record TransactionRecord(Account sender,Account receiver,double amount) {

}
