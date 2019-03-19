package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.BankCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.NationalBankDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomNationalBankDataGenerator extends MainRandom
		implements NationalBankDataSupplier {
	
	@Override
	public FinancialIntermediary[] getListOfFinInterm() {
		
		FinancialIntermediary[] finInterm = new FinancialIntermediary[super.getRand().nextInt(15)];
		
		for(int i = 0; i < finInterm.length; i++) {
			finInterm[i] = BankCreator.createBank(new RandomBankDataGenirator());
		}
		
		return finInterm;
	}

}
