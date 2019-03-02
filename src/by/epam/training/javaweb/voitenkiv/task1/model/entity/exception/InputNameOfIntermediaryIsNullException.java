package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputNameOfIntermediaryIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = -2116702197459391191L;

    public InputNameOfIntermediaryIsNullException() {
    }

    public InputNameOfIntermediaryIsNullException(String message,
	    Throwable cause) {
	super(message, cause);
    }

    public InputNameOfIntermediaryIsNullException(Throwable cause) {
	super(cause);
    }

}
