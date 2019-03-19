package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.IndividualCreditDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class IndividualCreditCreator {

	public static IndividualCredit getCompanyCredit(
			IndividualCreditDataSupplier dataSupplier) {

		IndividualCredit individualCredit = new IndividualCredit();

		if (dataSupplier != null) {
			individualCredit = new IndividualCredit(
					dataSupplier.getIndivCreditType(),
					dataSupplier.getName(),
					dataSupplier.getCurrencyType(),
					dataSupplier.getPersentage(),
					dataSupplier.isActive(),
					dataSupplier.getMaxSizeOfCredit(),
					dataSupplier.isClosing(),
					dataSupplier.isFixedPercentage());
		}

		return individualCredit;
	}
}
