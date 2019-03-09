package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;

public class CreditSearcher {

	public static CreditHolder[] searchCreditWithParametrs(
			NationalBank nationalBank, Credit creditForSearch)
			throws InputNationalBankInstIsNullException {

		if (nationalBank != null) {

			FinancialIntermediary[] listOfElem = nationalBank
					.getListOfFinInterm();

			CreditHolder[] listOfCreditHolder = new CreditHolder[listOfElem.length];

			int i = 0;

			for (FinancialIntermediary finInterm : listOfElem) {

				if (finInterm != null
						&& (finInterm instanceof CreditHolder)) {

					/**
					 * find element which has listOfCredit and write them into
					 * listOFSearchingElements
					 **/
					listOfCreditHolder[i] = (CreditHolder) finInterm;

					removElements(listOfCreditHolder[i],
							creditForSearch);

					i++;
				}
			}
			return listOfCreditHolder;
		} else {
			throw new InputNationalBankInstIsNullException();
		}
	}

	private static void removElements(CreditHolder listOfCreditHolder,
			Credit creditForSearch) {

		int j = 0;
		int numberOfRemovElem = 0;

		/**
		 * Remove elements from credit's list in every CreditHolder if it doesn't have
		 * equal object's parameters
		 **/
		for (Credit credit : listOfCreditHolder.getListOfCredit()) {

			if (!credit.extraEquals(creditForSearch)) {
				try {
					listOfCreditHolder.removeCreditFromList(
							j - numberOfRemovElem);
				} catch (IncorrectIndexOfRemovedElemException e) {

				}
				numberOfRemovElem++;
			}

			j++;
		}
	}
}