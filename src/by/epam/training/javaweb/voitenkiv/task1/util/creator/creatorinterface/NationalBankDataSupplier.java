package by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;

/**
 * @author Voitenkov Sergey March 16, 2019
 */

public interface NationalBankDataSupplier {
	FinancialIntermediary[] getListOfFinInterm();
}
