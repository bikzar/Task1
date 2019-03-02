package by.epam.training.javaweb.voitenkiv.task1.model.logic;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

public class Sorter {

    public static void sortOfCreditList(int startElement, int lastElement,
	    Credit[] list, Comparator<Credit> comparator) {

	if (startElement >= 0 && lastElement >= 0
		&& lastElement < list.length) {

	    int leftBorder = startElement;
	    int rightBorder = lastElement;

	    Credit midle = list[(startElement + lastElement) / 2];
	    Credit buffer;

	    while (leftBorder <= rightBorder) {
		
		while (comparator.compare(list[leftBorder],
			midle) < 0) {
		    ++leftBorder;
		}
		
		while (comparator.compare(list[rightBorder],
			midle) > 0) {
		    --rightBorder;
		}

		if (leftBorder <= rightBorder) {
		    buffer = list[leftBorder];
		    list[leftBorder] = list[rightBorder];
		    list[rightBorder] = buffer;
		    ++leftBorder;
		    --rightBorder;
		}
	    }

	    if (leftBorder < lastElement) {
		sortOfCreditList(leftBorder, lastElement, list, comparator);
	    }
	    
	    if (rightBorder > startElement) {
		sortOfCreditList(startElement, rightBorder, list,
			comparator);
	    }
	}
    }
}