package by.epam.training.javaweb.voitenkiv.task1.model.exception;

public class CreditProjectException extends Throwable {

	private static final long serialVersionUID = 7604923403620479478L;

	public CreditProjectException() {
	}

	public CreditProjectException(String message) {
		super(message);
	}

	public CreditProjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditProjectException(Throwable cause) {
		super(cause);
	}

}
