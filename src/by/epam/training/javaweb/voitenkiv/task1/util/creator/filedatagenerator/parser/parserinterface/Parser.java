
package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.parser.parserinterface;

import java.util.ArrayList;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

/**
 * @author Sergey Voitenkov
 * Mar 24, 2019
 */

public interface Parser {
	ArrayList<Credit> parseCredit(String tetxt);
}
