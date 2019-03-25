package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.enumfiledatagenirator.CreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface.Validator;

/**
 * @author Sergey Voitenkov Mar 24, 2019
 */

public class CreditValidator implements Validator {

	private String regexPattern;
	private Validator nextValidator;
	private CreditType creditType;

	public CreditValidator(String creditPatern, CreditType creditType,
			Validator nextValidator) {
		
		if (creditPatern != null) {
			this.regexPattern = creditPatern;
		}

		if (creditType != null) {
			this.creditType = creditType;
		}
		
		this.nextValidator = nextValidator;
	}

	@Override
	public CreditType validate(String text) {

		CreditType resualt = CreditType.NOT_CREDIT;

		if (text != null) {

			if (text.matches(regexPattern)) {

				resualt = creditType;

			} else if (nextValidator != null) {

				resualt = nextValidator.validate(text);

			}
		}

		return resualt;
	}

}
