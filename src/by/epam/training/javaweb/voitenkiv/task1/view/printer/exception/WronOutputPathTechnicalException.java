package by.epam.training.javaweb.voitenkiv.task1.view.printer.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.TechnicalCreditProjectException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class WronOutputPathTechnicalException
		extends TechnicalCreditProjectException {

	public WronOutputPathTechnicalException() {
	}

	public WronOutputPathTechnicalException(String message,
			Throwable cause) {
		super(message, cause);
	}

	public WronOutputPathTechnicalException(Throwable cause) {
		super(cause);
	}

}
