package HomeWorks.lesson10.exception;

public class UserExpectedError extends RuntimeException {
    public UserExpectedError(String message) {
        super(message);
    }
}
