package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.parser;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CompanySizeType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.CurrencyType;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.IndividualCreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.CompanyCreditCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.IndividualCreditCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.CompanyCreditDataSupplier;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.creatorinterface.IndividualCreditDataSupplier;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.enumfiledatagenirator.CreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.parser.parserinterface.Parser;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface.Validator;

/**
 * @author Sergey Voitenkov Mar 24, 2019
 */

public class CreditParser implements Parser,
		CompanyCreditDataSupplier, IndividualCreditDataSupplier {

	private Validator validator;
	private String[] creditAttribute;

	private static final Logger LOGGER;

	static {
		LOGGER = LogManager.getRootLogger();
	}

	public CreditParser(Validator validator) {
		if (validator != null) {
			this.validator = validator;
		}
	}

	@Override
	public ArrayList<Credit> parseCredit(String text) {

		ArrayList<Credit> resualt = new ArrayList<>();

		if (text != null) {

			String[] dataArray = text.split("\n");

			for (String credit : dataArray) {

				LOGGER.debug("Credit line value: " + credit);

				CreditType creditType = validator.validate(credit);

				LOGGER.debug(
						"Credit type from validator: " + creditType);

				if (creditType != null) {

					creditAttribute = credit.split("\\|");

					switch (creditType) {
					case COMPANY_CREDIT:
						
						LOGGER.debug("Create company credit");
						
						CompanyCredit companyCredit = CompanyCreditCreator
								.getCompanyCredit(this);
						resualt.add(companyCredit);
						break;
					
					case INDIVIDUAL_CREDIT:
						
						LOGGER.debug("Create individual credit");
						
						IndividualCredit individualcredit = IndividualCreditCreator
								.getCompanyCredit(this);
						resualt.add(individualcredit);
						break;
					}

				}
			}
		}
		return resualt;
	}

	@Override
	public CurrencyType getCurrencyType() {
		String currencyType = creditAttribute[2];
		LOGGER.debug("CurType: " + currencyType);
		return CurrencyType.valueOf(currencyType);
	}

	@Override
	public double getPersentage() {
		String persentage = creditAttribute[3];
		LOGGER.debug("Persentage: " + persentage);
		return Double.parseDouble(persentage);
	}

	@Override
	public boolean isActive() {
		String isActive = creditAttribute[4];
		LOGGER.debug("isActive: " + isActive);
		return Boolean.parseBoolean(isActive);
	}

	@Override
	public double getMaxSizeOfCredit() {
		String maxCreditSize = creditAttribute[5];
		LOGGER.debug("CreditSize: " + maxCreditSize);
		return Double.parseDouble(maxCreditSize);
	}

	@Override
	public boolean isClosing() {
		String isClosing = creditAttribute[6];
		LOGGER.debug("isClosing: " + isClosing);
		return Boolean.parseBoolean(isClosing);
	}

	@Override
	public boolean isFixedPercentage() {
		String isFixedPercentage = creditAttribute[7];
		LOGGER.debug("isFix: " + isFixedPercentage);
		return Boolean.parseBoolean(isFixedPercentage);
	}

	@Override
	public String getName() {
		return creditAttribute[1];
	}

	@Override
	public CompanySizeType getCompanySize() {
		String companySize = creditAttribute[8];
		LOGGER.debug("CompSize: " + companySize);
		return CompanySizeType.valueOf(companySize);
	}

	@Override
	public IndividualCreditType getIndivCreditType() {
		String individualCreditType = creditAttribute[8];
		LOGGER.debug("IndividyalCreditType: " + individualCreditType);
		return IndividualCreditType.valueOf(individualCreditType);
	}
}
