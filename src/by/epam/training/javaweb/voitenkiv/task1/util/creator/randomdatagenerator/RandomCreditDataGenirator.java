package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.CreditDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class RandomCreditDataGenirator extends MainRandom
		implements CreditDataSupplier {

	@Override
	public String getName() {
		return "Credit" + super.getRand().nextInt(900);
	}

	@Override
	public CurrencyType getCurrencyType() {
		return CurrencyType.values()[super.getRand().nextInt(3)];
	}

	@Override
	public double getPersentage() {
		return super.getRand().nextDouble() * 100;
	}

	@Override
	public boolean isActive() {
		return super.getRand().nextBoolean();
	}

	@Override
	public double getMaxSizeOfCredit() {
		return super.getRand().nextDouble() * 1031;
	}

	@Override
	public boolean isClosing() {
		return super.getRand().nextBoolean();
	}

	@Override
	public boolean isFixedPercentage() {
		return super.getRand().nextBoolean();
	}

}
