package by.epam.training.javaweb.voitenkiv.task1.model.entity.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

@SuppressWarnings("serial")
public class NegativeValueOfMaxSizeOfCredit
	extends LogicCreditProjecException {

    public NegativeValueOfMaxSizeOfCredit() {
    }

	public NegativeValueOfMaxSizeOfCredit(String message) {
		super(message);
	}
}
