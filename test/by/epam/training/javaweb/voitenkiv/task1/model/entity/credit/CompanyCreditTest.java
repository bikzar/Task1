package by.epam.training.javaweb.voitenkiv.task1.model.entity.credit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfCreditPercentage;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfMaxSizeOfCredit;

/**
 * @author Sergey Voitenkov March 10, 2019
 *
 */

public class CompanyCreditTest {

	private static CompanyCredit companyCreditTest;

	@BeforeEach
	public void createDefaulCompanuCreditObject() {
		companyCreditTest = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 15, true, 500, true,
				true);
	}

	@Test
	public void createCompanyCreditWithSizeOfCompanyLikeNull() {
		CompanyCredit companyCredit = new CompanyCredit(null, "nn",
				CurrencyType.DOLLOR, 15, true, 500, true, true);

		CompanySizeType expected = CompanySizeType.SMALL;

		assertEquals(expected, companyCredit.getSizeOfCompany());

	}

	@Test
	public void createCompanyCreditWithNameOfCreditLikeNull() {
		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, null, CurrencyType.DOLLOR, 15,
				true, 500, true, true);

		String expected = "Empty Name";

		assertEquals(expected, companyCredit.getNameOfCredit());

	}

	@Test
	public void createCompanyCreditWithTypeOfCurrensyLikeNull() {
		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "RTG", null, 15, true, 500, true,
				true);

		CurrencyType expected = CurrencyType.DOLLOR;

		assertEquals(expected, companyCredit.getTypeOfCurrency());

	}

	@Test
	public void createCompanyCreditWithNegetivePercentage() {
		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "RTG", CurrencyType.DOLLOR,
				-15, true, 500, true, true);

		int expected = 0;

		assertEquals(expected, companyCredit.getPercentage());

	}

	@Test
	public void createCompanyCreditWithNegetiveMaxSizeOfCredit() {
		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "RTG", CurrencyType.DOLLOR, 15,
				true, -300, true, true);

		int expected = 0;

		assertEquals(expected, companyCredit.getMaxSizeOfCredit());
	}

	@Test
	public void checkExtraEqualsWithTheSameObject() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 500, true, true);

		assertEquals(companyCreditTest.extraEquals(companyCredit),
				true);
	}

	@Test
	public void checkExtraEqualsObjectsWithDifferentSizeOfCompany() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.HUGE, "NTT", CurrencyType.DOLLOR, 15,
				true, 500, true, true);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsObjectsWithDifferentTypeOfCurrency() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.EURO, 15,
				true, 500, true, true);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	/*
	 * Abbreviation for this block of code 
	 * USC - users's searching credit 
	 * DC - default credit (companyCreditTest)
	 */

	@Test
	public void checkExtraEqualsOnObjectWithDifferentPercentageUSCBiggerDC() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 50,
				true, 500, true, true);

		assertEquals(true,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithDifferentPercentageUSCLowerDC() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 5,
				true, 500, true, true);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithSamePercentage() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 500, true, true);

		assertEquals(true,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithSameMaxSizeOfCredit() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 500, true, true);

		assertEquals(true,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithDiffrentMaxSizeOfCreditUSCLowerDC() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 200, true, true);

		assertEquals(true,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithDiffrentMaxSizeOfCreditUSCBiggerDC() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 900, true, true);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	/*
	 * End of block code.
	 */

	@Test
	public void checkExtraEqualsOnObjectWithDiffrentIsClosingValue() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 900, false, true);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test
	public void checkExtraEqualsOnObjectWithDiffrentIsFixedPercentageValue() {

		CompanyCredit companyCredit = new CompanyCredit(
				CompanySizeType.SMALL, "NTT", CurrencyType.DOLLOR, 15,
				true, 900, true, false);

		assertEquals(false,
				companyCreditTest.extraEquals(companyCredit));
	}

	@Test()
	public void checkSetNegativePercentage() {

		assertThrows(NegativeValueOfCreditPercentage.class, () -> {
			companyCreditTest.setPercentage(-12);
		});

	}

	@Test
	public void checkSetPercentageValue() {

		try {
			companyCreditTest.setPercentage(99.9);
		} catch (NegativeValueOfCreditPercentage e) {
			e.printStackTrace();
		}

		assertEquals(99.9, companyCreditTest.getPercentage());
	}

	@Test
	public void checkSetActive() {

		companyCreditTest.setActive(false);

		assertEquals(false, companyCreditTest.isActive());
	}

	@Test()
	public void checkSetNegativeMaxSizeOfCredit() {

		assertThrows(NegativeValueOfMaxSizeOfCredit.class, () -> {
			companyCreditTest.setMaxSizeOfCredit(-15);
		});

	}
	
	@Test
	public void checkSetMaxSizeOfCreditValue() {

		try {
			companyCreditTest.setMaxSizeOfCredit(999);
		} catch (NegativeValueOfMaxSizeOfCredit e) {
			e.printStackTrace();
		}

		assertEquals(999, companyCreditTest.getMaxSizeOfCredit());
	}
	
	@Test
	public void checkSetClosing() {

		companyCreditTest.setClosing(false);

		assertEquals(false, companyCreditTest.isClosing());
	}
	
	/*
	 * Check equals method
	 */
	
	@Test
	public void checkEqualsWithNullObject() {

		CompanyCredit companyCredit = null;

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsWithSameObject() {

		assertEquals(true,
				companyCreditTest.equals(companyCreditTest));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDiffrentIsClosingValue() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 15, true, 500, false,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDiffrentIsFixedPercentageValue() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 15, true, 500, true,
				false);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDiffrentIsActiveValue() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 15, false, 500, true,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDiffrentValueOfPercentage() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 99, true, 500, true,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDiffrentValueOfMaxSizeOfCredit() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.DOLLOR, 15, true, 35, true,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsHaveDifferentNameOfCredit() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"GHR", CurrencyType.DOLLOR, 15, true, 35, true,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}
	
	@Test
	public void checkEqualsOnObjectsWithDifferentTypeOfCurrency() {

		CompanyCredit companyCredit = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.EURO, 15, true, 500, true,
				true);

		assertEquals(false,
				companyCreditTest.equals(companyCredit));
	}

	@Test
	public void checkEqualsOnTwoSameObjects() {

		CompanyCredit companyCreditFirst = new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.EURO, 15, true, 500, true,
				true);
		
		CompanyCredit companyCreditSecond= new CompanyCredit(CompanySizeType.SMALL,
				"NTT", CurrencyType.EURO, 15, true, 500, true,
				true);

		assertEquals(true,
				companyCreditFirst.equals(companyCreditSecond));
	}
	
	/*End*/
}
