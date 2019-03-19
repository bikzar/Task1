package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

@SuppressWarnings("serial")
public class ListOfFinancialIntemediaryIsNullExcrption
	extends LogicCreditProjecException {

    public ListOfFinancialIntemediaryIsNullExcrption() {
    }

	public ListOfFinancialIntemediaryIsNullExcrption(String message) {
		super(message);
	}
}
