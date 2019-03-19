package by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class Bank extends FinancialIntermediary
		implements CreditHolder {

	private Credit[] creditList;
	private int indexOfPreviousElemOfList;
	private int indexOfNextElementOfList;
	private final static int DEFAULT_CREDIT_LIST_SIZE = 10;

	{
		creditList = new Credit[DEFAULT_CREDIT_LIST_SIZE];
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
			this.creditList = listOfCredit;
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
			newListOfCredit[i] = creditList[i].getCloneOfCredit();
		}

		return newListOfCredit;
	}

	@Override
	public void setListOfCredit(Credit[] listOfCredit)
			throws ListOfCreditIsNullException {

		if (listOfCredit != null && checkListForNull(listOfCredit)) {
			this.creditList = listOfCredit;
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
			if (indexOfNextElementOfList > creditList.length) {
				resizeList();
			}

			creditList[indexOfNextElementOfList] = inputCredit;

			indexOfNextElementOfList++;
			indexOfPreviousElemOfList = indexOfNextElementOfList - 1;

		} else {
			throw new InputCreditIsNullException();
		}
	}

	private void resizeList() {

		Credit[] newListOfCredit = new Credit[creditList.length
				* 2];

		for (int i = 0; i < creditList.length; i++) {
			newListOfCredit[i] = creditList[i];
		}

		creditList = newListOfCredit;
	}

	@Override
	public void removeCreditFromList(int indexOfCredit)
			throws IncorrectIndexOfRemovedElemException {

		if (indexOfCredit >= 0
				&& indexOfCredit <= indexOfPreviousElemOfList) {

			if (indexOfCredit != indexOfPreviousElemOfList) {

				for (int i = indexOfCredit; i < indexOfPreviousElemOfList; i++) {
					creditList[i] = creditList[i + 1];
					creditList[i + 1] = null;
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

		for (Credit credit : creditList) {
			result = prime * result
					+ ((credit == null) ? 0 : credit.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj) || getClass() != obj.getClass()) {
			return false;
		}

		Bank other = (Bank) obj;

		for (int i = 0; i < indexOfNextElementOfList; i++) {
			if (!creditList[i].equals(other.creditList[i])) {
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
			str.append(creditList[i].toString());
		}

		return str.toString();
	}

}
