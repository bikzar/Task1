/**
 * 
 */
package by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputNameOfIntermediaryIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfIdException;
import by.epam.training.javaweb.voitenkiv.task1.model.exception.LogicCreditProjecException;

/**
 * @author Sergey Voitenkov March 10, 2019
 *
 */
public class BankTest {

	private Bank firstBank;
	private Bank secondBank;

	@BeforeEach
	public void creatObject() {
		firstBank = new Bank(15, "GG");
		secondBank = new Bank(79, "YY");
	}

	@Test
	public void checkConstructorWithNegativeValId() {

		Bank bank = new Bank(-12, "FF");

		assertEquals(-1, bank.getIdNumberOfIntermediary());
	}

	@Test
	public void checkConstructorWithNullNameOfBank() {

		Bank bank = new Bank(12, null);

		assertEquals("Defaul Name", bank.getNameOfIntermediary());
	}

	@Test
	public void checksetIdWithNegativeVal() {
		assertThrows(NegativeValueOfIdException.class, () -> {
			firstBank.setIdNumberOfIntermediary(-12);
		});
	}

	@Test
	public void checksetNameOfBankWithNullVal() {

		assertThrows(InputNameOfIntermediaryIsNullException.class,
				() -> {
					firstBank.setNameOfIntermediary(null);
				});
	}

	/*
	 * Check equals method
	 */

	@Test
	public void checkEqualsWithNullObject() {
		assertEquals(false, firstBank.equals(null));
	}

	@Test
	public void checkEqualsWithSameObject() {
		assertEquals(true, firstBank.equals(firstBank));
	}

	@Test
	public void checkEqualsOnObjectsWithDiffrentIdValue() {
		// But name has the same value
		try {
			secondBank.setNameOfIntermediary("GG");
		} catch (InputNameOfIntermediaryIsNullException e) {
		}

		assertEquals(false, firstBank.equals(secondBank));
	}

	@Test
	public void checkEqualsOnObjectsWithDiffrentName() {
		// But idNumber has the same value
		try {
			secondBank.setIdNumberOfIntermediary(15);
		} catch (NegativeValueOfIdException e) {
		}

		assertEquals(false, firstBank.equals(secondBank));
	}

	@Test
	public void checkEqualsOnObjectsWithDifferentCreditList() {
		// But with the same id and name
		Credit[] firstList = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "NTT",
						CurrencyType.EURO, 1, true, 500, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "BNT",
						CurrencyType.DOLLOR, 5, true, 500, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "RUNT",
						CurrencyType.RUSRUBL, 21, true, 500, true,
						true),
				new CompanyCredit(CompanySizeType.SMALL, "FTP",
						CurrencyType.EURO, 5, true, 500, true, true),
				new IndividualCredit(IndividualCreditType.FORCAR,
						"First", CurrencyType.DOLLOR, 54, true, 500,
						true, true) };

		Credit[] secondList = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "NTT",
						CurrencyType.EURO, 1, true, 500, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "BNT",
						CurrencyType.DOLLOR, 5, true, 500, true,
						true),
				new IndividualCredit(IndividualCreditType.FORCAR,
						"First", CurrencyType.DOLLOR, 54, true, 500,
						true, true) };

		try {
			firstBank.setListOfCredit(firstList);
			secondBank.setListOfCredit(secondList);
		} catch (ListOfCreditIsNullException e) {
			e.printStackTrace();
		}

		assertEquals(false, firstBank.equals(secondBank));

	}

	@Test
	public void checkEqualsOnTwoEqualsObjects() {

		Credit[] list = new Credit[] {
				new CompanyCredit(CompanySizeType.SMALL, "NTT",
						CurrencyType.EURO, 1, true, 500, true, true),
				new CompanyCredit(CompanySizeType.HUGE, "BNT",
						CurrencyType.DOLLOR, 5, true, 500, true,
						true),
				new IndividualCredit(IndividualCreditType.FORCAR,
						"First", CurrencyType.DOLLOR, 54, true, 500,
						true, true) };
		try {
			firstBank.setListOfCredit(list);

			secondBank.setIdNumberOfIntermediary(15);
			secondBank.setNameOfIntermediary("GG");
			secondBank.setListOfCredit(list);
		} catch (LogicCreditProjecException e) {}

		assertEquals(true, firstBank.equals(secondBank));
	}

	/* End */

}
