package Application.Exceptions;

public class DBUploadFailException extends Exception {
    public DBUploadFailException(String message) {
        super(message);
    }

    public DBUploadFailException(Throwable cause) {
        super(cause);
    }

    public DBUploadFailException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DBUploadFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
