package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class NegativeValueOfIdException
	extends LogicCreditProjecException {

    public NegativeValueOfIdException() {
    }

	public NegativeValueOfIdException(String message) {
		super(message);
	}
}
