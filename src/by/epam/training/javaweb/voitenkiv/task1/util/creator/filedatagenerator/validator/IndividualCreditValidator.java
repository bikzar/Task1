package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.enumfiledatagenirator.CreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface.Validator;

/**
 * @author Sergey Voitenkov
 * Mar 24, 2019
 */

public class IndividualCreditValidator extends CreditValidator {

	private static String INDIVIDUAL_CREDIT_PATTERN = "^IndividualCredit\\|.*\\|(DOLLOR|EURO|RUSRUBL|UAN)\\|[0-9]+\\.[0-9]+\\|(true|false)\\|[0-9]+\\.[0-9]+\\|(true|false)\\|(true|false)\\|(FOR_CAR|FOR_HOUSE|CONSUMER_LOAN)";
	private static CreditType CREDIT_TYPE = CreditType.INDIVIDUAL_CREDIT;
	
	public IndividualCreditValidator(Validator nextValidator) {

		super(INDIVIDUAL_CREDIT_PATTERN, CREDIT_TYPE, nextValidator);

	}

}
