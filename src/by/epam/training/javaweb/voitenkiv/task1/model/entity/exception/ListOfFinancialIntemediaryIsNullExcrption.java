package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

public class ListOfFinancialIntemediaryIsNullExcrption
	extends LogicCreditProjecException {

    private static final long serialVersionUID = 1L;

    public ListOfFinancialIntemediaryIsNullExcrption() {
    }

    public ListOfFinancialIntemediaryIsNullExcrption(String message,
	    Throwable cause) {
	super(message, cause);
    }

    public ListOfFinancialIntemediaryIsNullExcrption(Throwable cause) {
	super(cause);
    }
}
