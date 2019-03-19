package by.epam.training.javaweb.voitenkiv.task1.controller;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfFinancialIntemediaryIsNullExcrption;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.TechnicalCreditProjectException;

import by.epam.training.javaweb.voitenkiv.task1.model.logic.CreditSearcher;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.Sorter;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.CreditNameComparator;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.NationalBankCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator.RandomNationalBankDataGenerator;
import by.epam.training.javaweb.voitenkiv.task1.view.printer.FilePrinter;
import by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class MainController {

	private MainController() {
	}

	public static void main(String[] args) {


		NationalBank nationalBank = null;
		try {
			nationalBank = NationalBankCreator
					.creatNationalBank(new RandomNationalBankDataGenerator());

			CreditHolder[] creditHolders;

			creditHolders = CreditSearcher.searchCreditWithParametrs(
					nationalBank.getListOfFinInterm(), new CompanyCredit());

			Sorter.sortCreditListInCreditHolder(creditHolders, new CreditNameComparator());
			
			Printable conPrin = new FilePrinter("/home/sergey/c.txt");
						
			for (CreditHolder ch : creditHolders) {
				try {
					conPrin.print(ch);
				} catch (TechnicalCreditProjectException e) {
					
					e.printStackTrace();
				}
			}
			
			
		} catch (InputNationalBankInstIsNullException | ListOfFinancialIntemediaryIsNullExcrption e) {

		}
	}
}
