package by.epam.training.javaweb.voitenkiv.task1.model.entity.credit;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.ParameterizedSearch;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfCurrensy;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfCreditPercentage;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfMaxSizeOfCredit;

public abstract class Credit implements ParameterizedSearch {

	private String nameOfCredit;
	private TypeOfCurrensy typeOfCurrency;
	private double percentage;
	private boolean isActive;
	private double maxSizeOfCredit;
	private boolean isClosing;
	private boolean isFixedPercentage;

	private static final String DEFAUL_NAME_OF_CREDIT = "Empty Name";
	private static final TypeOfCurrensy DEFAULT_TYPE_OF_CUR = TypeOfCurrensy.Dollor;

	{
		nameOfCredit = DEFAUL_NAME_OF_CREDIT;
		typeOfCurrency = DEFAULT_TYPE_OF_CUR;
	}

	public Credit() {
	}

	public Credit(String nameOfCredit, TypeOfCurrensy typeOfCurrency,
			double percentage, boolean isActive,
			double maxSizeOfCredit, boolean isClosing,
			boolean isFixedPercentage) {

		if (nameOfCredit != null) {
			this.nameOfCredit = nameOfCredit;
		}

		if (typeOfCurrency != null) {
			this.typeOfCurrency = typeOfCurrency;
		}

		if (percentage > 0) {
			this.percentage = percentage;
		}

		if (maxSizeOfCredit > 0) {
			this.maxSizeOfCredit = maxSizeOfCredit;
		}

		this.isActive = isActive;
		this.isClosing = isClosing;
		this.isFixedPercentage = isFixedPercentage;
	}

	public abstract Credit getCloneOfCredit();

	public boolean extraEquals(Credit credit) {

		if (credit == null) {
			return false;
		}

		if (this == credit) {
			return true;
		}

		if (this.isActive == false) {
			return false;
		}

		if (this.isClosing != credit.isClosing) {
			return false;
		}

		if (this.isFixedPercentage != credit.isFixedPercentage) {
			return false;
		}

		if (this.typeOfCurrency != credit.typeOfCurrency) {
			return false;
		}

		if (!(Double.doubleToLongBits(percentage) <= Double
				.doubleToLongBits(credit.percentage))) {
			return false;
		}

		if (!(Double.doubleToLongBits(maxSizeOfCredit) <= Double
				.doubleToLongBits(credit.maxSizeOfCredit))) {
			return false;
		}

		return true;
	}

	public String getNameOfCredit() {
		return nameOfCredit;
	}

	public TypeOfCurrensy getTypeOfCurrency() {
		return typeOfCurrency;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage)
			throws NegativeValueOfCreditPercentage {

		if (percentage > 0) {
			this.percentage = percentage;
		} else {
			throw new NegativeValueOfCreditPercentage();
		}

	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getMaxSizeOfCredit() {
		return maxSizeOfCredit;
	}

	public void setMaxSizeOfCredit(double maxSizeOfCredit)
			throws NegativeValueOfMaxSizeOfCredit {

		if (maxSizeOfCredit > 0) {
			this.maxSizeOfCredit = maxSizeOfCredit;
		} else {
			throw new NegativeValueOfMaxSizeOfCredit();
		}
	}

	public boolean isClosing() {
		return isClosing;
	}

	public void setClosing(boolean isClosing) {
		this.isClosing = isClosing;
	}

	public boolean isFixedPercentage() {
		return isFixedPercentage;
	}

	public void setFixedPercentage(boolean isFixedPercentage) {
		this.isFixedPercentage = isFixedPercentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isClosing ? 1231 : 1237);
		result = prime * result + (isFixedPercentage ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(maxSizeOfCredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nameOfCredit == null) ? 0
				: nameOfCredit.hashCode());
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeOfCurrency == null) ? 0
				: typeOfCurrency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Credit credit = (Credit) obj;

		if (isClosing != credit.isClosing) {
			return false;
		}

		if (isActive != credit.isActive) {
			return false;
		}

		if (isFixedPercentage != credit.isFixedPercentage) {
			return false;
		}

		if (Double.doubleToLongBits(percentage) != Double
				.doubleToLongBits(credit.percentage)) {
			return false;
		}

		if (Double.doubleToLongBits(maxSizeOfCredit) != Double
				.doubleToLongBits(credit.maxSizeOfCredit)) {
			return false;
		}

		if (nameOfCredit == null) {
			if (credit.nameOfCredit != null) {
				return false;
			}
		} else if (!nameOfCredit.equals(credit.nameOfCredit)) {
			return false;
		}

		if ((typeOfCurrency == null && credit.typeOfCurrency != null)
				|| (typeOfCurrency != null
						&& credit.typeOfCurrency == null)) {
			return false;
		} else if (!(typeOfCurrency == credit.typeOfCurrency)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "nameOfDeposit=" + nameOfCredit + ", typeOfCurrency="
				+ typeOfCurrency + ", percentage=" + percentage
				+ ", isActive=" + isActive + ", maxSizeOfCredit="
				+ maxSizeOfCredit + ", isClosing=" + isClosing
				+ ", isFixedPercentage=" + isFixedPercentage;
	}
}
