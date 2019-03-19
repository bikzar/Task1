package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.CreditNameComparator;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.CreditPercentageComparator;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.MaxSizeOfCreditComparator;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class SorterTest {

	private CreditHolder[] creditHolder;

	@Before
	public void creatDefaultBank() {

		Credit[] list = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "C",
						CurrencyType.DOLLOR, 2, true, 320, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "CD",
						CurrencyType.RUSRUBL, 9, true, 120, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true, true),
				new IndividualCredit(IndividualCreditType.FORCAR, "D",
						CurrencyType.DOLLOR, 3, true, 450, true,
						true) };

		creditHolder = new CreditHolder[] {
				new Bank(962, "BPS", list) };

	}

	@Test
	public void checkSortByName() {
		Credit[] expectList = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "C",
						CurrencyType.DOLLOR, 2, true, 320, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "CD",
						CurrencyType.RUSRUBL, 9, true, 120, true,
						true),
				new IndividualCredit(IndividualCreditType.FORCAR, "D",
						CurrencyType.DOLLOR, 3, true, 450, true,
						true) };

		Sorter.sortCreditListInCreditHolder(creditHolder,
				new CreditNameComparator());

		assertArrayEquals(expectList,
				creditHolder[0].getListOfCredit());
	}

	@Test
	public void checkSortByPersentage() {
		Credit[] expectList = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "C",
						CurrencyType.DOLLOR, 2, true, 320, true,
						true),
				new IndividualCredit(IndividualCreditType.FORCAR, "D",
						CurrencyType.DOLLOR, 3, true, 450, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "CD",
						CurrencyType.RUSRUBL, 9, true, 120, true,
						true) };

		Sorter.sortCreditListInCreditHolder(creditHolder,
				new CreditPercentageComparator());

		assertArrayEquals(expectList,
				creditHolder[0].getListOfCredit());
	}

	@Test
	public void checkSortByMaxCreditSize() {
		Credit[] expectList = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "CD",
						CurrencyType.RUSRUBL, 9, true, 120, true,
						true),
				new CompanyCredit(CompanySizeType.HUGE, "C",
						CurrencyType.DOLLOR, 2, true, 320, true,
						true),
				new IndividualCredit(IndividualCreditType.FORCAR, "D",
						CurrencyType.DOLLOR, 3, true, 450, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true,
						true) };

		Sorter.sortCreditListInCreditHolder(creditHolder,
				new MaxSizeOfCreditComparator());

		assertArrayEquals(expectList,
				creditHolder[0].getListOfCredit());
	}
}
