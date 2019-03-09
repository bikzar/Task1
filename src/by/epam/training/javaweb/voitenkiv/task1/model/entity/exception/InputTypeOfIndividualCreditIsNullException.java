package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputTypeOfIndividualCreditIsNullException
	extends LogicCreditProjecException {
  
    private static final long serialVersionUID = 1186049105257686505L;

    public InputTypeOfIndividualCreditIsNullException() {
    }

	public InputTypeOfIndividualCreditIsNullException(
			String message) {
		super(message);
	}
}
