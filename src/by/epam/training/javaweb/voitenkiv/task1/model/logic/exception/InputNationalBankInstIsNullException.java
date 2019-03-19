package by.epam.training.javaweb.voitenkiv.task1.model.logic.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class InputNationalBankInstIsNullException
	extends LogicCreditProjecException {

    public InputNationalBankInstIsNullException() {
    }

	public InputNationalBankInstIsNullException(String message) {
		super(message);
	}
}
