package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.enumfiledatagenirator.CreditType;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface.Validator;

/**
 * @author Sergey Voitenkov Mar 24, 2019
 */

public class CompanyCreditValidator extends CreditValidator {

	private static String COMPANY_CREDIT_PATTERN = "^CompanyCredit\\|.*\\|(DOLLOR|EURO|RUSRUBL|UAN)\\|[0-9]+\\.[0-9]+\\|(true|false)\\|[0-9]+\\.[0-9]+\\|(true|false)\\|(true|false)\\|(SMAL|MEDIUM|HUGE)";
	private static CreditType CREDIT_TYPE = CreditType.COMPANY_CREDIT;

	public CompanyCreditValidator(Validator nextValidator) {

		super(COMPANY_CREDIT_PATTERN, CREDIT_TYPE, nextValidator);

	}
}
