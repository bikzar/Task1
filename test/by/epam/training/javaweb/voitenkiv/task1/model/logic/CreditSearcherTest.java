package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import static org.junit.Assert.*;

import org.junit.Test;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;

public class CreditSearcherTest {

	@Test
	public void checkSearchCreditWithParametrs() {
		Credit[] list = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "C",
						CurrencyType.EURO, 2, true, 300, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "CD",
						CurrencyType.EURO, 9, true, 120, true, true),
				new IndividualCredit(IndividualCreditType.FORCAR, "D",
						CurrencyType.EURO, 3, true, 450, true,
						true) };

		Bank[] bankList = new Bank[] { new Bank(1, "AB", list),
				new Bank(2, "CD", list), new Bank(3, "EF", list),
				new Bank(4, "GH", list) };

		NationalBank nationalBank = NationalBank
				.getInstance(bankList);

		Credit searchCredit = new CompanyCredit(CompanySizeType.SMALL,
				"A", CurrencyType.EURO, 6, true, 560, true, true);

		CreditHolder[] actualCreditHolder = null;

		try {
			actualCreditHolder = CreditSearcher
					.searchCreditWithParametrs(
							nationalBank.getListOfFinInterm(),
							searchCredit);
		} catch (InputNationalBankInstIsNullException e) {
		}

		Credit[] expectlist = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "A",
						CurrencyType.EURO, 6, true, 560, true, true),
				new CompanyCredit(CompanySizeType.SMALL, "B",
						CurrencyType.EURO, 1, true, 920, true,
						true) };

		CreditHolder[] expectCreditHolder = new Bank[] {
				new Bank(1, "AB", expectlist),
				new Bank(2, "CD", expectlist),
				new Bank(3, "EF", expectlist),
				new Bank(4, "GH", expectlist) };

		boolean resualt = true;

		if (expectCreditHolder.length == actualCreditHolder.length) {
			for (int i = 0; i < expectCreditHolder.length; i++) {
				if (!expectCreditHolder[i]
						.equals(actualCreditHolder[i])) {
					resualt = false;
				}
			}
		}

		assertEquals(true, resualt);
	}

}
