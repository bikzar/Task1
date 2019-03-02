package by.epam.training.javaweb.voitenkiv.task1.util;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputFinancialIntermediaryIsNullException;

public class NationalBankCreator {
    
    public static NationalBank creatNationalBank()
	    throws InputFinancialIntermediaryIsNullException, InputCreditIsNullException {
	
	Random random =  new Random();
	
	NationalBank nationalBank = NationalBank.getInstance();
	
	int numberOfBank = random.nextInt(7)+1;
	
	for(int i = 0; i < numberOfBank; i++) {
	    nationalBank.addFinIntermedToList(BankCreator.createBank());
	}
	
	return nationalBank; 
    }
}
