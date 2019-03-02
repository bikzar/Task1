package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputCreditIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 6033097134788184765L;

    public InputCreditIsNullException() {
    }

    public InputCreditIsNullException(Throwable cause) {
	super(cause);
    }

    public InputCreditIsNullException(String message, Throwable cause) {
	super(message, cause);
    }
}
