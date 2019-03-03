package by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

public enum SortCreditTypeFactory {
	BY_NAME, BY_PERSENTAGE, BY_MAX_SIZE_OF_CREDIT;

	public static Comparator<Credit> getComparator(int userChoise) {

		Comparator<Credit> resualt = new CreditPercentageComparator();

		switch (SortCreditTypeFactory.values()[userChoise - 1]) {
		case BY_NAME:
			resualt = new CreditNameComparator();
			break;
		case BY_PERSENTAGE:
			break;
		case BY_MAX_SIZE_OF_CREDIT:
			resualt = new MaxSizeOfCreditComparator();
			break;
		}

		return resualt;
	}
}
