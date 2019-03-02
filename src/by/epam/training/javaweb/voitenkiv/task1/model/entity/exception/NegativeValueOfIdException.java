package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class NegativeValueOfIdException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = -1220649081083217782L;

    public NegativeValueOfIdException() {
    }

    public NegativeValueOfIdException(String message,
	    Throwable cause) {
	super(message, cause);
    }

    public NegativeValueOfIdException(Throwable cause) {
	super(cause);
    }
}
