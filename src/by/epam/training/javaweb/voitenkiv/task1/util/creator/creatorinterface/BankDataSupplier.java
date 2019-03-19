package by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public interface BankDataSupplier extends FinancialIntermediaryDataSupplier {
	Credit[] getListOfCredit();
}
