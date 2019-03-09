package by.epam.training.javaweb.voitenkiv.task1.util.creator;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;

public class BankCreator {

    public static Bank createBank() {

	Random random = new Random();

	Bank bank = new Bank(random.nextInt(500),
		"Bank " + random.nextInt(500));
	
	int sizeOfCreditList = random.nextInt(9)+1;
	
	for(int i = 0 ; i < sizeOfCreditList; i++) {
	    try {
			bank.addCreditToList(CreditCreator.createRandomCredit());
		} catch (InputCreditIsNullException e) {
			
		}
	}
	
	return bank;
    }
}
