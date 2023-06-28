package hust.soict.ict.aims.exception;

public class AlreadyExistedException extends Exception {

	public AlreadyExistedException() {}

	public AlreadyExistedException(String message) {
		super(message);
	}

	public AlreadyExistedException(Throwable cause) {
		super(cause);
	}

	public AlreadyExistedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
