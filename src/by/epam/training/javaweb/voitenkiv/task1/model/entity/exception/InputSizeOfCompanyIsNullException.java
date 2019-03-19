package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class InputSizeOfCompanyIsNullException
	extends LogicCreditProjecException {

    public InputSizeOfCompanyIsNullException() {
    }

	public InputSizeOfCompanyIsNullException(String message) {
		super(message);
	}
}
