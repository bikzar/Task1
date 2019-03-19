package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator.randomfactory;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.CompanyCreditCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.IndividualCreditCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator.RandomCompanyCreditDataGenirator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator.RandomIndividyalCreditDataGenerator;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class CreditFactory {

	public static Credit getCredit() {

		Credit resualt = IndividualCreditCreator.getCompanyCredit(
				new RandomIndividyalCreditDataGenerator());

		int random = new Random().nextInt(2);

		switch (random) {
		case 1:
			resualt = CompanyCreditCreator.getCompanyCredit(
					new RandomCompanyCreditDataGenirator());
			break;
		}

		return resualt;
	}
}
