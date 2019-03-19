package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class NegativeValueOfCreditPercentage
	extends LogicCreditProjecException {

    public NegativeValueOfCreditPercentage() {
    }

	public NegativeValueOfCreditPercentage(String message) {
		super(message);
	}
}
