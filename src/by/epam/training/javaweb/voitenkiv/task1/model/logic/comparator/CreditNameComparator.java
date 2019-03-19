package by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class CreditNameComparator implements Comparator<Credit> {

    @Override
    public int compare(Credit arg0, Credit arg1) {
	return arg0.getNameOfCredit()
		.compareTo(arg1.getNameOfCredit());
    }
}
