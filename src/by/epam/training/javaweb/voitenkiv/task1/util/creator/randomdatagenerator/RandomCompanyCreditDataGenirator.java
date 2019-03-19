package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.CompanyCreditDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomCompanyCreditDataGenirator extends RandomCreditDataGenirator implements CompanyCreditDataSupplier{

	@Override
	public CompanySizeType getCompanySize() {
		return CompanySizeType.values()[super.getRand().nextInt(3)];
	}


}
