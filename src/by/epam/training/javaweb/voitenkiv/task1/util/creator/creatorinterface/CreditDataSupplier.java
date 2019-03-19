package by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;

/**
 * @author Voitenkov Sergey March 16, 2019
 *	
 */

public interface CreditDataSupplier extends DataSupplier {
	CurrencyType getCurrencyType();
	double getPersentage();
	boolean isActive();
	double getMaxSizeOfCredit();
	boolean isClosing();
	boolean isFixedPercentage();
}
