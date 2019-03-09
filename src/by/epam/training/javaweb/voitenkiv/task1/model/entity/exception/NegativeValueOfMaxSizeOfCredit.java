package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class NegativeValueOfMaxSizeOfCredit
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 1L;

    public NegativeValueOfMaxSizeOfCredit() {
    }

	public NegativeValueOfMaxSizeOfCredit(String message) {
		super(message);
	}
}
