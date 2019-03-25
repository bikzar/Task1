/**
 * 
 */
package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.exception;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.TechnicalCreditProjectException;

/**
 * @author Sergey Voitenkov
 * Mar 24, 2019
 */

public class IncorrectFilePathTechnicalCreditProjectException
		extends TechnicalCreditProjectException {

	public IncorrectFilePathTechnicalCreditProjectException() {
	}

	public IncorrectFilePathTechnicalCreditProjectException(
			String message, Throwable cause) {
		super(message, cause);
	}


	public IncorrectFilePathTechnicalCreditProjectException(
			Throwable cause) {
		super(cause);
	}

}
