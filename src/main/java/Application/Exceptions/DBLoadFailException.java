package Application.Exceptions;

public class DBLoadFailException extends Exception {
    protected DBLoadFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DBLoadFailException(Throwable cause) {
        super(cause);
    }

    public DBLoadFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBLoadFailException(String message) {
        super(message);
    }
}
