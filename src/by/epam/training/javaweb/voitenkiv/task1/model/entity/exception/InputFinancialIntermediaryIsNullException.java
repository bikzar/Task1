package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class InputFinancialIntermediaryIsNullException
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 8253800869222660248L;

    public InputFinancialIntermediaryIsNullException() {
    }

	public InputFinancialIntermediaryIsNullException(String message) {
		super(message);
	}
}
