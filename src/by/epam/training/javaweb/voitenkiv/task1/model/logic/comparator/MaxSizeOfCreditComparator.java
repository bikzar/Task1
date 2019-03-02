package by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

public class MaxSizeOfCreditComparator implements Comparator<Credit> {

    @Override
    public int compare(Credit arg0, Credit arg1) {
	return Double.compare(arg0.getMaxSizeOfCredit(),
		arg1.getMaxSizeOfCredit());
    }

}
