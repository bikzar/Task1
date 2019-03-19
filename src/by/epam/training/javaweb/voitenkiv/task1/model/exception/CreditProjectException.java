package by.epam.training.javaweb.voitenkiv.task1.model.exception;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class CreditProjectException extends Throwable {

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
