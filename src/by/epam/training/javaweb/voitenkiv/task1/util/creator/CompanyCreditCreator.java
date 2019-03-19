package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.CompanyCreditDataSupplier;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class CompanyCreditCreator {
	
	public static CompanyCredit getCompanyCredit(
			CompanyCreditDataSupplier dataSupplier) {

		CompanyCredit companyCredit = new CompanyCredit();

		if (dataSupplier != null) {
			companyCredit = new CompanyCredit(
					dataSupplier.getCompanySize(),
					dataSupplier.getName(),
					dataSupplier.getCurrencyType(),
					dataSupplier.getPersentage(),
					dataSupplier.isActive(),
					dataSupplier.getMaxSizeOfCredit(),
					dataSupplier.isClosing(),
					dataSupplier.isFixedPercentage());
		}

		return companyCredit;
	}
}
