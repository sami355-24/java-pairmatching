package pairmatching.Exception;

public class RetryException extends IllegalArgumentException{
    public RetryException(String message, Throwable cause) {
        super(message, cause);
    }
}
