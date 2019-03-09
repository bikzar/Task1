package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class NegativeValueOfCreditPercentage
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 8129207623907754675L;

    public NegativeValueOfCreditPercentage() {
    }

	public NegativeValueOfCreditPercentage(String message) {
		super(message);
	}
}
