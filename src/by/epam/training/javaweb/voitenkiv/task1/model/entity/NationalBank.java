package by.epam.training.javaweb.voitenkiv.task1.model.entity;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputFinancialIntermediaryIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfFinancialIntemediaryIsNullExcrption;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class NationalBank {

	private FinancialIntermediary[] listOfFinInterm;
	private static NationalBank instanseOfNationalBank;
	private int indexOfPreviousElem;
	private int indexOfNextElement;
	private final static int DEFAULT_FINANC_INTERDMED_LIST_SIZE = 10;

	{
		listOfFinInterm = new FinancialIntermediary[DEFAULT_FINANC_INTERDMED_LIST_SIZE];
	}

	private NationalBank(
			FinancialIntermediary[] listOfFinancialIntermediary) {

		if (listOfFinancialIntermediary != null
				&& checkListForNull(listOfFinancialIntermediary)) {

			this.listOfFinInterm = listOfFinancialIntermediary;
			indexOfPreviousElem = listOfFinancialIntermediary.length
					- 1;
			indexOfNextElement = listOfFinancialIntermediary.length;
		}
	}

	public FinancialIntermediary[] getListOfFinInterm() {

		FinancialIntermediary[] newListOfFinInrem = new FinancialIntermediary[indexOfNextElement];

		for (int i = 0; i < indexOfNextElement; i++) {
			newListOfFinInrem[i] = listOfFinInterm[i]
					.getCloneOfInstance();
		}

		return newListOfFinInrem;
	}

	public static NationalBank getInstance(
			FinancialIntermediary[] listOfFinInterm) {

		if (instanseOfNationalBank == null) {
			instanseOfNationalBank = new NationalBank(
					listOfFinInterm);
		}

		return instanseOfNationalBank;
	}

	public static NationalBank getInstance() {
		return getInstance(null);
	}

	public void setListOfFinInterm(
			FinancialIntermediary[] listOfFinInterm)
			throws ListOfFinancialIntemediaryIsNullExcrption {

		if (listOfFinInterm != null
				&& checkListForNull(listOfFinInterm)) {

			this.listOfFinInterm = listOfFinInterm;
			indexOfPreviousElem = listOfFinInterm.length
					- 1;
			indexOfNextElement = listOfFinInterm.length;

		} else {
			throw new ListOfFinancialIntemediaryIsNullExcrption();
		}
	}

	private boolean checkListForNull(FinancialIntermediary[] list) {

		boolean resualt = true;

		for (FinancialIntermediary financialIntermediary : list) {

			if (financialIntermediary == null) {
				resualt = false;
			}
		}
		return resualt;
	}

	public void addFinIntermedToList(
			FinancialIntermediary newFinancialIntermediary)
			throws InputFinancialIntermediaryIsNullException {

		if (newFinancialIntermediary != null) {

			if (indexOfNextElement > listOfFinInterm.length) {
				resizeList();
			}

			listOfFinInterm[indexOfNextElement] = newFinancialIntermediary;

			indexOfNextElement++;
			indexOfPreviousElem = indexOfNextElement - 1;

		} else {
			throw new InputFinancialIntermediaryIsNullException();
		}

	}

	private void resizeList() {

		FinancialIntermediary[] newListOfFinInterm = new FinancialIntermediary[listOfFinInterm.length
				* 2];

		for (int i = 0; i < listOfFinInterm.length; i++) {
			newListOfFinInterm[i] = listOfFinInterm[i];
		}

		listOfFinInterm = newListOfFinInterm;
	}

	public void removeFinIntermedFromList(int indexOfFinIntermed)
			throws IncorrectIndexOfRemovedElemException {

		if (indexOfFinIntermed >= 0
				&& indexOfFinIntermed <= indexOfPreviousElem) {
			if (indexOfFinIntermed != indexOfPreviousElem) {
				for (int i = indexOfFinIntermed; i < indexOfPreviousElem; i++) {
					listOfFinInterm[i] = listOfFinInterm[i + 1];
				}
			}
			indexOfPreviousElem--;
			indexOfNextElement--;
		} else {
			throw new IncorrectIndexOfRemovedElemException();
		}
	}

	public void removeAllFinIntermedFromList() {
		indexOfPreviousElem = 0;
		indexOfNextElement = 0;
	}

	@Override
	public String toString() {

		StringBuilder str = new StringBuilder(
				"NationalBank \nlistOfBank:");

		for (int i = 0; i < indexOfNextElement; i++) {
			str.append("\n" + listOfFinInterm[i].toString());
		}

		return str.toString();
	}
}
