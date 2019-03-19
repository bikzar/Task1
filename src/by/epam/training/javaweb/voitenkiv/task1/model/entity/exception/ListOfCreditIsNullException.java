package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class ListOfCreditIsNullException
	extends LogicCreditProjecException {

    public ListOfCreditIsNullException() {
    }

	public ListOfCreditIsNullException(String message) {
		super(message);
	}
}
