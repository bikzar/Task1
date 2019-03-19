package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class CreditSearcher {

	public static CreditHolder[] searchCreditWithParametrs(
			FinancialIntermediary[] financIntermedList,
			Credit creditForSearch)
			throws InputNationalBankInstIsNullException {

		if (financIntermedList != null) {

			CreditHolder[] creditHolder = new CreditHolder[financIntermedList.length];

			int i = 0; // counter for creditHolder array

			for (FinancialIntermediary finInterm : financIntermedList) {
				/*
				 * Find FinancialIntermedia object which has creditList. Remove from their
				 * creditList all elements which dosen't equals creditForSearch and write them
				 * into creditHolder.
				 */
				if (finInterm != null
						&& (finInterm instanceof CreditHolder)) {

					removeElements((CreditHolder) finInterm,
							creditForSearch);

					creditHolder[i] = (CreditHolder) finInterm;

					i++;
				}
			}
			return creditHolder;
		} else {
			throw new InputNationalBankInstIsNullException();
		}
	}

	private static void removeElements(CreditHolder creditHolder,
			Credit creditForSearch) {

		int j = 0;
		int numberOfRemoveElem = 0;

		for (Credit credit : creditHolder.getListOfCredit()) {

			if (!credit.extraEquals(creditForSearch)) {
				try {
					creditHolder.removeCreditFromList(
							j - numberOfRemoveElem);
				} catch (IncorrectIndexOfRemovedElemException e) {

				}
				numberOfRemoveElem++;
			}

			j++;
		}
	}
}