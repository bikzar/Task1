package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputSizeOfCompanyIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 6165986675971020079L;

    public InputSizeOfCompanyIsNullException() {
    }

	public InputSizeOfCompanyIsNullException(String message) {
		super(message);
	}
}
