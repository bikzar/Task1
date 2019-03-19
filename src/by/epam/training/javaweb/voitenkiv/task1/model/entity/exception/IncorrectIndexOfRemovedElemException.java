package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class IncorrectIndexOfRemovedElemException
		extends LogicCreditProjecException {

	public IncorrectIndexOfRemovedElemException() {
	}

	public IncorrectIndexOfRemovedElemException(String message) {
		super(message);
	}

}
