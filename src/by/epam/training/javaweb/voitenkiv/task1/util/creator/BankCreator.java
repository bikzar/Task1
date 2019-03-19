package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.BankDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class BankCreator {

	public static Bank createBank(BankDataSupplier dataSupplier) {
		
		Bank resualt = new Bank();

		if (dataSupplier != null) {
			resualt = new Bank(
					dataSupplier.getIdNumberOfIntermediary(),
					dataSupplier.getName(),
					dataSupplier.getListOfCredit());
		}

		return resualt;
	}
}
