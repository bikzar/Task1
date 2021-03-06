package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualsCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.SizeOfCompany;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfCurrency;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfIndividualsCredit;

public class CreditCreator {

	public static Credit createRandomCredit() {

		Random random = new Random();
		Credit newInstanse;

		if (random.nextBoolean()) {
			newInstanse = new CompanyCredit(
					SizeOfCompany.values()[random.nextInt(2)],
					"CopanuCredit" + random.nextInt(900),
					TypeOfCurrency.values()[random.nextInt(3)],
					random.nextDouble() * 100, true,
					random.nextDouble() * 1031, random.nextBoolean(),
					random.nextBoolean());
		} else {
			newInstanse = new IndividualsCredit(
					TypeOfIndividualsCredit.values()[random
							.nextInt(2)],
					"IndividualCredit" + random.nextInt(900),
					TypeOfCurrency.values()[random.nextInt(3)],
					random.nextDouble() * 10, true,
					random.nextDouble() * 1000, random.nextBoolean(),
					random.nextBoolean());
		}

		return newInstanse;
	}

	public static Credit createCreditFromUserChoise(int userChoise) {

		Credit credit;

		switch (userChoise) {
		case 1:
			credit = new CompanyCredit();
			break;
		case 2:
			credit = new IndividualsCredit();
			break;
		default:
			credit = new IndividualsCredit();
		}

		return credit;
	}

}
