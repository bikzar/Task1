package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class InputNameOfIntermediaryIsNullException
	extends LogicCreditProjecException {

    public InputNameOfIntermediaryIsNullException() {
    }

	public InputNameOfIntermediaryIsNullException(String message) {
		super(message);
	}
}
