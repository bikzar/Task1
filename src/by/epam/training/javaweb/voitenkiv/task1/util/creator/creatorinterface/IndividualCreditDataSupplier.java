package by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;

/**
 * @author Voitenkov Sergey March 16, 2019
 *	
 */

public interface IndividualCreditDataSupplier extends CreditDataSupplier {
	IndividualCreditType getIndivCreditType();
}
