package by.epam.training.javaweb.voitenkiv.task1.model.exception;

public class TechnicalCreditProjectException
		extends CreditProjectException {

	private static final long serialVersionUID = -153762781022538810L;

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
