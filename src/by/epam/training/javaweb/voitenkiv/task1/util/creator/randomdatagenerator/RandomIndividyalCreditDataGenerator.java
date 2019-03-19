package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.IndividualCreditDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomIndividyalCreditDataGenerator extends RandomCreditDataGenirator implements IndividualCreditDataSupplier {

	@Override
	public IndividualCreditType getIndivCreditType() {
		return IndividualCreditType.values()[super.getRand().nextInt(3)];
	}

}
