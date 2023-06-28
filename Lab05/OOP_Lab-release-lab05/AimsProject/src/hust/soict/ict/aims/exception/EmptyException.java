package hust.soict.ict.aims.exception;

public class EmptyException extends Exception {

	public EmptyException() {}

	public EmptyException(String message) {
		super(message);
	}

	public EmptyException(Throwable cause) {
		super(cause);
	}

	public EmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
