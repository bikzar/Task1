package by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputNameOfIntermediaryIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfIdException;

public abstract class FinancialIntermediary {

	private int idNumberOfIntermediary;
	private String nameOfIntermediary;
	private static final int DEFAULT_ID_NUMBER = -1;
	private static final String DEFAULT_INTERM_NAME = "Defaul Name";

	{
		idNumberOfIntermediary = DEFAULT_ID_NUMBER;
		nameOfIntermediary = DEFAULT_INTERM_NAME;
	}

	public FinancialIntermediary() {
	}

	public FinancialIntermediary(int idNumberOfIntermediary,
			String nameOfIntermediary) {

		if (idNumberOfIntermediary > 0) {
			this.idNumberOfIntermediary = idNumberOfIntermediary;
		}

		if (nameOfIntermediary != null) {
			this.nameOfIntermediary = nameOfIntermediary;
		}
	}

	public abstract FinancialIntermediary getCloneOfInstance();

	public int getIdNumberOfIntermediary() {
		return idNumberOfIntermediary;
	}

	public void setIdNumberOfIntermediary(int idNumberOfIntermediary)
			throws NegativeValueOfIdException {

		if (idNumberOfIntermediary > 0) {
			this.idNumberOfIntermediary = idNumberOfIntermediary;
		} else {
			throw new NegativeValueOfIdException();
		}

	}

	public String getNameOfIntermediary() {
		return nameOfIntermediary;
	}

	public void setNameOfIntermediary(String nameOfIntermediary)
			throws InputNameOfIntermediaryIsNullException {

		if (nameOfIntermediary != null) {
			this.nameOfIntermediary = nameOfIntermediary;
		} else {
			throw new InputNameOfIntermediaryIsNullException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNumberOfIntermediary;
		result = prime * result + ((nameOfIntermediary == null) ? 0
				: nameOfIntermediary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		FinancialIntermediary other = (FinancialIntermediary) obj;

		if (idNumberOfIntermediary != other.idNumberOfIntermediary) {
			return false;
		}

		if (nameOfIntermediary == null) {
			if (other.nameOfIntermediary != null) {
				return false;
			}
		} else if (!nameOfIntermediary
				.equals(other.nameOfIntermediary)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "\n[idNumberOfIntermediary: " + idNumberOfIntermediary
				+ ", nameOfIntermediary: " + nameOfIntermediary + "]";
	}
}
