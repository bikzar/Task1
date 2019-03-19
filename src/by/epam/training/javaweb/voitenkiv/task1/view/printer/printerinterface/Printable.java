package by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.exception.TechnicalCreditProjectException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public interface Printable {
	void print(Object obj) throws TechnicalCreditProjectException;
}
