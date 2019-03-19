package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class InputCreditIsNullException
		extends LogicCreditProjecException {

	public InputCreditIsNullException() {
	}

	public InputCreditIsNullException(String message) {
		super(message);
	}
}
