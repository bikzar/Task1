package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.FinancialIntermediaryDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomFinancialIntermediaryDataGenerator
		extends MainRandom implements FinancialIntermediaryDataSupplier {
	
	@Override
	public String getName() {
		return "FinancialIntermediary" + super.getRand().nextInt(900);
	}

	@Override
	public int getIdNumberOfIntermediary() {
		return super.getRand().nextInt(Integer.MAX_VALUE);
	}
}
