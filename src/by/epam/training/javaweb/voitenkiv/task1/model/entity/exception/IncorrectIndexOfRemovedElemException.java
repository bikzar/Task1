package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class IncorrectIndexOfRemovedElemException
		extends LogicCreditProjecException {

	private static final long serialVersionUID = -4984278119200470649L;

	public IncorrectIndexOfRemovedElemException() {
	}

	public IncorrectIndexOfRemovedElemException(String message) {
		super(message);
	}

}
