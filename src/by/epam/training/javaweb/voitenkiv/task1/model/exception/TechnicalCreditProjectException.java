package by.epam.training.javaweb.voitenkiv.task1.model.exception;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class TechnicalCreditProjectException
		extends CreditProjectException {

	public TechnicalCreditProjectException() {
	}

	public TechnicalCreditProjectException(String message,
			Throwable cause) {
		super(message, cause);
	}

	public TechnicalCreditProjectException(Throwable cause) {
		super(cause);
	}
}
