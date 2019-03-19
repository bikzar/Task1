package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class InputTypeOfIndividualCreditIsNullException
	extends LogicCreditProjecException {

    public InputTypeOfIndividualCreditIsNullException() {
    }

	public InputTypeOfIndividualCreditIsNullException(
			String message) {
		super(message);
	}
}
