package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class ListOfCreditIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 3971281310295955511L;

    public ListOfCreditIsNullException() {
    }

	public ListOfCreditIsNullException(String message) {
		super(message);
	}
}
