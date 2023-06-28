package hust.soict.ict.aims.exception;

public class NegativeException extends Exception {

	public NegativeException() {}

	public NegativeException(String message) {
		super(message);
	}

	public NegativeException(Throwable cause) {
		super(cause);
	}

	public NegativeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
