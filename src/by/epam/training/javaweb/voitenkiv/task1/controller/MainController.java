package by.epam.training.javaweb.voitenkiv.task1.controller;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.CreditSearcher;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.Sorter;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.SortCreditTypeFactory;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.util.ConsolePrinter;
import by.epam.training.javaweb.voitenkiv.task1.util.CreditCreator;
import by.epam.training.javaweb.voitenkiv.task1.util.NationalBankCreator;

import by.epam.training.javaweb.voitenkiv.task1.viwe.SimpleViwe;

public class MainController {

	public static void main(String[] args) {

		Credit creditForUser = CreditCreator
				.createCreditFromUserChoise(
						SimpleViwe.choiseTypeOfCredit());

		SimpleViwe.chatWithUser(creditForUser);

		NationalBank nationalBank = NationalBankCreator
				.creatNationalBank();

		try {

			CreditHolder[] creditHolders;

			creditHolders = CreditSearcher.searchCreditWithParametrs(
					nationalBank, creditForUser);

			Comparator<Credit> comp = SortCreditTypeFactory
					.getComparator(SimpleViwe.choiceTypeOfSort());

			Sorter.sortCreditListInCreditHolder(creditHolders, comp);
			
			//make user choice for type of printer
			
			ConsolePrinter conPrin = new ConsolePrinter();
			
			for (CreditHolder ch : creditHolders) {
				conPrin.print(ch);
			}
			
			
		} catch (InputNationalBankInstIsNullException e) {

		}
	}
}
