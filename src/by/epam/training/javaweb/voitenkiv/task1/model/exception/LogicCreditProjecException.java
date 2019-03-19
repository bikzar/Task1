package by.epam.training.javaweb.voitenkiv.task1.model.exception;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class LogicCreditProjecException
		extends CreditProjectException {

	public LogicCreditProjecException() {
	}

	public LogicCreditProjecException(String message) {
		super(message);
	}
}
