package by.epam.training.javaweb.voitenkiv.task1.model.appinterface;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.IncorrectIndexOfRemovedElemException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public interface CreditHolder {

    public Credit[] getListOfCredit();

    public void addCreditToList(Credit newCredit)
	    throws InputCreditIsNullException;

    public void removeCreditFromList(int indexOfCredit)
	    throws IncorrectIndexOfRemovedElemException;

    public void removeAllCreditsFromList();

    public void setListOfCredit(Credit[] listOfCredit)
	    throws ListOfCreditIsNullException;
    
    public String toString();
}
