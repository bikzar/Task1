package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class CreditForUseChoiceCreator {

	public static Credit createCreditFromUserChoise(int userChoise) {

		Credit credit = new IndividualCredit();

		switch (userChoise) {
		case 1:
			credit = new CompanyCredit();
			break;
		}

		return credit;
	}

}