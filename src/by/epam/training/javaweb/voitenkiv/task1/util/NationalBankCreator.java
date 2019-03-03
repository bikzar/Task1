package by.epam.training.javaweb.voitenkiv.task1.util;

import java.util.Random;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputFinancialIntermediaryIsNullException;

public class NationalBankCreator {

	public static NationalBank creatNationalBank() {

		Random random = new Random();

		NationalBank nationalBank = NationalBank.getInstance();

		int numberOfBank = random.nextInt(7) + 1;

		for (int i = 0; i < numberOfBank; i++) {
			try {
				nationalBank
						.addFinIntermedToList(BankCreator.createBank());
			} catch (InputFinancialIntermediaryIsNullException e) {
				
			}
		}

		return nationalBank;
	}
}
