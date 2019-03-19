package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.BankDataSupplier;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator.randomfactory.CreditFactory;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomBankDataGenirator
		extends RandomFinancialIntermediaryDataGenerator
		implements BankDataSupplier {

		
	@Override
	public Credit[] getListOfCredit() {

		int listSize = super.getRand().nextInt(15);
		
		Credit[] creditList = new Credit[listSize];
		
		for(int i = 0; i < creditList.length; i++) {
			creditList[i] = CreditFactory.getCredit();
		}
		
		return creditList;
	}

	@Override
	public String getName() {
		return "Bank" + super.getRand().nextInt(900);
	}

}
