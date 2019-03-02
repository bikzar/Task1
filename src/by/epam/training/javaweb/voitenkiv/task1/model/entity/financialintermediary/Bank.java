package by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;

public class Bank extends FinancialIntermediary
		implements CreditHolder {

	private Credit[] listOfCredit;
	private int indexOfPreviousElemOfList;
	private int indexOfNextElementOfList;
	private final static int DEFAULTSIZE = 10;

	{
		listOfCredit = new Credit[DEFAULTSIZE];
	}

	public Bank() {
	}

	public Bank(int idNumberOfBank, String nameOfBank) {

		// Is it need to check input parameters?
		// Can i think that super constructor protected for
		// this parameters?

		super(idNumberOfBank, nameOfBank);
	}

	public Bank(int idNumberOfBank, String nameOfBank,
			Credit[] listOfCredit) {

		// Is it need to check input parameters?
		// Can i think that super constructor protected for
		// this parameters?

		super(idNumberOfBank, nameOfBank);

		if (listOfCredit != null && checkListForNull(listOfCredit)) {
			this.listOfCredit = listOfCredit;
			indexOfPreviousElemOfList = listOfCredit.length - 1;
			indexOfNextElementOfList = listOfCredit.length;
		}
	}

	@Override
	public Bank getCloneOfInstance() {
		return new Bank(super.getIdNumberOfIntermediary(),
				super.getNameOfIntermediary(), getListOfCredit());
	}

	@Override
	public Credit[] getListOfCredit() {

		Credit[] newListOfCredit = new Credit[indexOfNextElementOfList];

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			newListOfCredit[i] = listOfCredit[i].getCloneOfCredit();
		}

		return newListOfCredit;
	}

	@Override
	public void setListOfCredit(Credit[] listOfCredit)
			throws ListOfCreditIsNullException {

		if (listOfCredit != null && checkListForNull(listOfCredit)) {
			this.listOfCredit = listOfCredit;
			indexOfPreviousElemOfList = listOfCredit.length - 1;
			indexOfNextElementOfList = listOfCredit.length;
		} else {
			throw new ListOfCreditIsNullException();
		}
	}

	@Override
	public void addCreditToList(Credit inputCredit)
			throws InputCreditIsNullException {

		if (inputCredit != null) {
			if (indexOfNextElementOfList < listOfCredit.length) {

				listOfCredit[indexOfNextElementOfList] = inputCredit;

			} else {

				Credit[] newListOfCredit = new Credit[listOfCredit.length
						* 2];
				int i;

				for (i = 0; i < listOfCredit.length; i++) {
					newListOfCredit[i] = listOfCredit[i];
				}

				newListOfCredit[i] = inputCredit;

				listOfCredit = newListOfCredit;
			}

			indexOfNextElementOfList++;
			indexOfPreviousElemOfList = indexOfNextElementOfList - 1;

		} else {
			throw new InputCreditIsNullException();
		}

	}

	@Override
	public void removeCreditFromList(int indexOfCredit)
			throws IncorrectIndexOfRemovedElemException {

		if (indexOfCredit >= 0
				&& indexOfCredit <= indexOfPreviousElemOfList) {

			if (indexOfCredit != indexOfPreviousElemOfList) {

				for (int i = indexOfCredit; i < indexOfPreviousElemOfList; i++) {
					listOfCredit[i] = listOfCredit[i + 1];
					listOfCredit[i + 1] = null;
				}

			}

			indexOfPreviousElemOfList--;
			indexOfNextElementOfList--;

		} else {
			throw new IncorrectIndexOfRemovedElemException();
		}
	}

	@Override
	public void removeAllCreditsFromList() {
		indexOfPreviousElemOfList = 0;
		indexOfNextElementOfList = 0;
	}

	private boolean checkListForNull(Credit[] list) {

		for (Credit credit : list) {

			if (credit == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		for (Credit credit : listOfCredit) {
			result = prime * result
					+ ((credit == null) ? 0 : credit.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Bank other = (Bank) obj;

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			if (!listOfCredit[i].equals(other.listOfCredit[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {

		StringBuilder str = new StringBuilder(
				super.toString() + "\nlistOfCredit: ");

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			str.append(listOfCredit[i].toString());
		}

		return str.toString();
	}

}
