package by.epam.training.javaweb.voitenkiv.task1.model.entity;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputFinancialIntermediaryIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfFinancialIntemediaryIsNullExcrption;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.FinancialIntermediary;

public class NationalBank {

	private FinancialIntermediary[] listOfFinInterm;
	private static NationalBank instanseOfNationalBank;
	private int indexOfPreviousElem;
	private int indexOfNextElement;
	private final static int DEFAULTSIZE = 10;

	{
		listOfFinInterm = new FinancialIntermediary[DEFAULTSIZE];
	}

	private NationalBank(
			FinancialIntermediary[] listOfFinancialIntermediary) {

		if (listOfFinancialIntermediary != null
				&& checkListForNull(listOfFinInterm)) {

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
		} else {
			throw new ListOfFinancialIntemediaryIsNullExcrption();
		}
	}

	private boolean checkListForNull(FinancialIntermediary[] list) {

		for (FinancialIntermediary financialIntermediary : list) {

			if (financialIntermediary == null) {
				return false;
			}
		}
		return true;
	}

	public void addFinIntermedToList(
			FinancialIntermediary newFinancialIntermediary)
			throws InputFinancialIntermediaryIsNullException {

		if (newFinancialIntermediary != null) {

			if (indexOfNextElement < listOfFinInterm.length) {

				listOfFinInterm[indexOfNextElement] = newFinancialIntermediary;

			} else {
				FinancialIntermediary[] newListOfFinInterm = new FinancialIntermediary[listOfFinInterm.length
						* 2];
				int i;

				for (i = 0; i < listOfFinInterm.length; i++) {
					newListOfFinInterm[i] = listOfFinInterm[i];
				}

				newListOfFinInterm[i] = newFinancialIntermediary;

				listOfFinInterm = newListOfFinInterm;
			}

			indexOfNextElement++;
			indexOfPreviousElem = indexOfNextElement - 1;

		} else {
			throw new InputFinancialIntermediaryIsNullException();
		}

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
