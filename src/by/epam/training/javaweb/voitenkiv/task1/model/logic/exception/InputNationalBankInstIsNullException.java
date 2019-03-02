package by.epam.training.javaweb.voitenkiv.task1.model.logic.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputNationalBankInstIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = -6784625585956444365L;

    public InputNationalBankInstIsNullException() {
    }

    public InputNationalBankInstIsNullException(String message,
	    Throwable cause) {
	super(message, cause);
    }

    public InputNationalBankInstIsNullException(Throwable cause) {
	super(cause);
    }

}
