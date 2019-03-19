package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfFinancialIntemediaryIsNullExcrption;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.NationalBankDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class NationalBankCreator {

	public static NationalBank creatNationalBank(
			NationalBankDataSupplier dataSupplier) throws ListOfFinancialIntemediaryIsNullExcrption {

		NationalBank resualt = NationalBank.getInstance();

		if (dataSupplier != null) {
			resualt.setListOfFinInterm(
					dataSupplier.getListOfFinInterm());

		}

		return resualt;
	}
}
