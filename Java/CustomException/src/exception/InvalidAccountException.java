package exception;

public class InvalidAccountException extends BusinessRuleException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
