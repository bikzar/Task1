package by.epam.training.javaweb.voitenkiv.task1.util;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;

public class BankCreator {

    public static Bank createBank() throws InputCreditIsNullException {

	Random random = new Random();

	Bank bank = new Bank(random.nextInt(500),
		"Bank " + random.nextInt(500));
	
	int sizeOfCreditList = random.nextInt(9)+1;
	
	for(int i = 0 ; i < sizeOfCreditList; i++) {
	    bank.addCreditToList(CreditCreator.createCredit());
	}
	
	return bank;
    }
}
