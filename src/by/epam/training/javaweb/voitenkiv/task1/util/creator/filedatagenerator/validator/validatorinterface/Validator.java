package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.validator.validatorinterface;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.enumfiledatagenirator.CreditType;

public interface Validator {
	CreditType validate(String text);
}
