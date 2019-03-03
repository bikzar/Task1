package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;

public class Sorter {

	public static void sortCreditListInCreditHolder(
			CreditHolder[] list, Comparator<Credit> comp) {

		for (CreditHolder cred : list) {

			Credit[] listOfCredits = cred.getListOfCredit();

			sortOfCreditList(0, list.length - 1, listOfCredits, comp);

			try {
				cred.setListOfCredit(listOfCredits);
			} catch (ListOfCreditIsNullException e) {

			}
		}
	}

	private static void sortOfCreditList(int startElement,
			int lastElement, Credit[] list,
			Comparator<Credit> comparator) {

		if (startElement >= 0 && lastElement >= 0
				&& lastElement < list.length) {

			int leftBorder = startElement;
			int rightBorder = lastElement;

			Credit midle = list[(startElement + lastElement) / 2];
			Credit buffer;

			while (leftBorder <= rightBorder) {

				while (comparator.compare(list[leftBorder],
						midle) < 0) {
					++leftBorder;
				}

				while (comparator.compare(list[rightBorder],
						midle) > 0) {
					--rightBorder;
				}

				if (leftBorder <= rightBorder) {
					buffer = list[leftBorder];
					list[leftBorder] = list[rightBorder];
					list[rightBorder] = buffer;
					++leftBorder;
					--rightBorder;
				}
			}

			if (leftBorder < lastElement) {
				sortOfCreditList(leftBorder, lastElement, list,
						comparator);
			}

			if (rightBorder > startElement) {
				sortOfCreditList(startElement, rightBorder, list,
						comparator);
			}
		}
	}
}