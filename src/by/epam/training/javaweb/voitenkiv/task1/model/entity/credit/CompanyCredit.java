package by.epam.training.javaweb.voitenkiv.task1.model.entity.credit;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.SizeOfCompany;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfCurrensy;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputSizeOfCompanyIsNullException;

public class CompanyCredit extends Credit {

	private SizeOfCompany sizeOfCompany;
	private static final SizeOfCompany DEF_SIZE_OF_COMPANY = SizeOfCompany.Small;

	{
		sizeOfCompany = DEF_SIZE_OF_COMPANY;
	}

	public CompanyCredit() {
	}

	public CompanyCredit(SizeOfCompany sizeOfCompany,
			String nameOfCredit, TypeOfCurrensy typeOfCurrency,
			double percentage, boolean isActive,
			double maxSizeOfCredit, boolean isClosing,
			boolean isFixedPercentage) {

		super(nameOfCredit, typeOfCurrency, percentage, isActive,
				maxSizeOfCredit, isClosing, isFixedPercentage);

		if (sizeOfCompany != null) {
			this.sizeOfCompany = sizeOfCompany;
		}
	}

	@Override
	public boolean extraEquals(Credit credit) {

		if (!super.extraEquals(credit)) {
			return false;
		}

		if (this.getClass() != credit.getClass()) {
			return false;
		}

		CompanyCredit companyCredit = (CompanyCredit) credit;

		if (sizeOfCompany != companyCredit.sizeOfCompany) {
			return false;
		}

		return true;
	}

	@Override
	public CompanyCredit getCloneOfCredit() {

		return new CompanyCredit(this.sizeOfCompany,
				this.getNameOfCredit(), this.getTypeOfCurrency(),
				this.getPercentage(), this.isActive(),
				this.getMaxSizeOfCredit(), this.isClosing(),
				this.isFixedPercentage());
	}

	public SizeOfCompany getSizeOfCompany() {
		return sizeOfCompany;
	}

	public void setSizeOfCompany(SizeOfCompany sizeOfCompany)
			throws InputSizeOfCompanyIsNullException {

		if (sizeOfCompany != null) {
			this.sizeOfCompany = sizeOfCompany;
		} else {
			throw new InputSizeOfCompanyIsNullException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sizeOfCompany == null) ? 0
				: sizeOfCompany.hashCode());
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

		CompanyCredit other = (CompanyCredit) obj;

		if (sizeOfCompany != other.sizeOfCompany) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "\nCompanysCredit:" + super.toString()
				+ ", sizeOfCompany=" + sizeOfCompany + "]";
	}
}
