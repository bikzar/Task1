package by.epam.training.javaweb.voitenkiv.task1.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.exception.TechnicalCreditProjectException;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.parser.CreditParser;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.MyFileReader;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.exception.IncorrectFilePathTechnicalCreditProjectException;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.CompanyCreditValidator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.IndividualCreditValidator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface.Validator;
import by.epam.training.javaweb.voitenkiv.task1.view.printer.FilePrinter;
import by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class MainController {

	private static final Logger LOGGER;

	static {
		LOGGER = LogManager.getRootLogger();
	}

	public static void main(String[] args) {

		/*
		 * NationalBank nationalBank = null; try { nationalBank = NationalBankCreator
		 * .creatNationalBank(new RandomNationalBankDataGenerator());
		 * 
		 * CreditHolder[] creditHolders;
		 * 
		 * creditHolders = CreditSearcher.searchCreditWithParametrs(
		 * nationalBank.getListOfFinInterm(), new CompanyCredit());
		 * 
		 * Sorter.sortCreditListInCreditHolder(creditHolders, new
		 * CreditNameComparator());
		 * 
		 * Printable conPrin = new FilePrinter("/home/sergey/c.txt");
		 * 
		 * for (CreditHolder ch : creditHolders) { try { conPrin.print(ch); } catch
		 * (TechnicalCreditProjectException e) {
		 * 
		 * e.printStackTrace(); } }
		 * 
		 * 
		 * } catch (InputNationalBankInstIsNullException |
		 * ListOfFinancialIntemediaryIsNullExcrption e) {
		 * 
		 * }
		 */

		MyFileReader fileReader = new MyFileReader(
				"/home/sergey/newCredit.txt");

		Validator validator = new CompanyCreditValidator(
				new IndividualCreditValidator(null));

		CreditParser creditParser = new CreditParser(validator);

		try {
			
			String text = fileReader.read();
			
			ArrayList<Credit> creditList = creditParser.parseCredit(text);

			Printable conPrin = new FilePrinter("/home/sergey/c.txt");
			
			for(Credit credit : creditList) {
				LOGGER.debug("Inside for");
				System.out.println(credit);
				conPrin.print(credit);
			}
			
			
		} catch (TechnicalCreditProjectException e) {
			LOGGER.warn("Incorrect file path", e);
		}
	}
}
