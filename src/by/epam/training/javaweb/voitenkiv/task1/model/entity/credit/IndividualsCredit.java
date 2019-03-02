package by.epam.training.javaweb.voitenkiv.task1.model.entity.credit;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfCurrensy;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfIndividualsCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputTypeOfIndividualCreditIsNullException;

public class IndividualsCredit extends Credit {

	private TypeOfIndividualsCredit typeOfIndivCredit;
	private static final TypeOfIndividualsCredit DEF_TYPE_OF_INDIVID_CREDIT = TypeOfIndividualsCredit.ConsumerLoan;

	{
		typeOfIndivCredit = DEF_TYPE_OF_INDIVID_CREDIT;
	}

	public IndividualsCredit() {
	}

	public IndividualsCredit(
			TypeOfIndividualsCredit typeOfIndivCredit,
			String nameOfCredit, TypeOfCurrensy typeOfCurrency,
			double percentage, boolean isActive,
			double maxSizeOfCredit, boolean isClosing,
			boolean isFixedPercentage) {

		super(nameOfCredit, typeOfCurrency, percentage, isActive,
				maxSizeOfCredit, isClosing, isFixedPercentage);

		if (typeOfIndivCredit != null) {
			this.typeOfIndivCredit = typeOfIndivCredit;
		}
	}

	@Override
	public boolean extraEquals(Credit credit) {

		if (!super.extraEquals(credit)) {
			return false;
		}

		if (credit.getClass() != this.getClass()) {
			return false;
		}

		IndividualsCredit individualsCredit = (IndividualsCredit) credit;

		if (typeOfIndivCredit != individualsCredit.typeOfIndivCredit) {
			return false;
		}

		return true;

	}

	@Override
	public IndividualsCredit getCloneOfCredit() {

		return new IndividualsCredit(this.typeOfIndivCredit,
				this.getNameOfCredit(), this.getTypeOfCurrency(),
				this.getPercentage(), this.isActive(),
				this.getMaxSizeOfCredit(), this.isClosing(),
				this.isFixedPercentage());
	}

	public TypeOfIndividualsCredit getTypeOfIndivCredit() {
		return typeOfIndivCredit;
	}

	public void setTypeOfIndivCredit(
			TypeOfIndividualsCredit typeOfIndivCredit)
			throws InputTypeOfIndividualCreditIsNullException {

		if (typeOfIndivCredit != null) {
			this.typeOfIndivCredit = typeOfIndivCredit;
		} else {
			throw new InputTypeOfIndividualCreditIsNullException();
		}
	}

	@Override
	public String toString() {
		return "\nIndividualsCredit: " + super.toString()
				+ ", typeOfIndivCredit= " + typeOfIndivCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((typeOfIndivCredit == null) ? 0
				: typeOfIndivCredit.hashCode());
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
		IndividualsCredit other = (IndividualsCredit) obj;
		if (typeOfIndivCredit != other.typeOfIndivCredit) {
			return false;
		}
		return true;
	}
}
