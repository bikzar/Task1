package by.epam.training.javaweb.voitenkiv.task1.viwe;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.IndividualsCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.SizeOfCompany;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfIndividualsCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputSizeOfCompanyIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputTypeOfIndividualCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfCreditPercentage;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.NegativeValueOfMaxSizeOfCredit;
import by.epam.training.javaweb.voitenkiv.task1.util.UserInputScanner;

public class SimpleViwe {

	public static int choiseTypeOfCredit() {
		System.out.println("Find credit of your dream.\n ");
		System.out.println("Choice which type of credit you search:\n"
				+ "1) Credit for company\n2) Individual credit");

		int userChoise = -1;

		while (!(userChoise <= 2 && userChoise >= 1)) {
			userChoise = UserInputScanner.readInt();
			if (userChoise > 2 && userChoise < 1) {
				System.out.println(
						"Incorrect input. Please Try again.");
			}
		}

		return userChoise;
	}

	public static void chatWithUser(Credit credit) {

		System.out.println("You should enter credit's parameters.");

		credit.setActive(true);

		/*
		 * User input for isClosing field
		 */
		if (isYesOrNo(
				"Are you going to close credit befor it will end?(y/n):")) {
			credit.setClosing(true);
		} else {
			credit.setClosing(false);
		}

		/*
		 * User input for isFixedPercentage field
		 */
		if (isYesOrNo(
				"Would you like credit with fixed persentage?(y/n):")) {
			credit.setFixedPercentage(true);
		} else {
			credit.setFixedPercentage(false);
		}

		/*
		 * User input for MaxSizeOfCredit field
		 */
		while (true) {
			System.out.println(
					"How mach money are you gioing to take?");

			try {
				credit.setMaxSizeOfCredit(UserInputScanner.readInt());
				break;
			} catch (NegativeValueOfMaxSizeOfCredit e) {
				System.out.println("Incorrect input. Value shuold be "
						+ "bigger than 0!");
			}
		}

		/*
		 * User input for Percentage field
		 */
		while (true) {
			System.out.println(
					"Enter max value of credit's persentage:");
			try {
				credit.setPercentage(UserInputScanner.readInt());
				break;
			} catch (NegativeValueOfCreditPercentage e) {
				System.out.println("Incorrect input. Value shuold be "
						+ "bigger than 0!");
			}
		}

		if (CompanyCredit.class == credit.getClass()) {
			CompanyCredit companyCredit = (CompanyCredit) credit;

			while (true) {

				System.out.println("Choice size of your company: "
						+ "\n1) Small;\n" + "2) Medium;\n"
						+ "3) High;");

				int userInput = UserInputScanner.readInt();

				if (userInput > 0 && userInput <=3) {

					try {
						companyCredit.setSizeOfCompany(
								getSizeOfCompany(userInput));
						break;
					} catch (InputSizeOfCompanyIsNullException e) {

					}
				}
			}
		}

		if (IndividualsCredit.class == credit.getClass()) {
			IndividualsCredit individualsCredit = (IndividualsCredit) credit;

			while (true) {

				System.out.println("Choice type of credit:\n"
						+ "1) For car;\n" + "2) For House;\n"
						+ "3) Consumer Loan;");

				int userInput = UserInputScanner.readInt();

				if (userInput > 0 && userInput < 4) {

					try {
						individualsCredit.setTypeOfIndivCredit(
								getTypeOfIndividCredit(userInput));
						break;
					} catch (InputTypeOfIndividualCreditIsNullException e) {

					}
				}
			}
		}
	}

	public static int choiceTypeOfSort() {

		while (true) {
			System.out.println("Choice type of sorting:\n"
					+ "1) By name\n" + "2) By persentage"
					+ "\n3) By max size of credit");

			int userIput = UserInputScanner.readInt();

			if (!(userIput >= 1 && userIput <= 3)) {
				System.out.println("Incorrect input. Try again.");
				continue;
			}
			break;
		}
		return 1;
	}

	private static boolean isYesOrNo(String message) {
		String systemMesagge = "Incorrect input. Please Try again.";
		String userStringInput = "";
		boolean resualt = false;

		while (!userStringInput.equalsIgnoreCase("Y")
				&& !userStringInput.equalsIgnoreCase("N")) {

			System.out.println(message);

			userStringInput = UserInputScanner.readString();

			if (!userStringInput.equalsIgnoreCase("Y")
					&& !userStringInput.equalsIgnoreCase("N")) {

				System.out.println(systemMesagge);
			} else if (userStringInput.equalsIgnoreCase("Y")) {
				resualt = true;
			}
		}
		return resualt;
	}

	private static SizeOfCompany getSizeOfCompany(int userChoise) {
		return SizeOfCompany.values()[userChoise - 1];
	}

	private static TypeOfIndividualsCredit getTypeOfIndividCredit(
			int userChoise) {

		return TypeOfIndividualsCredit.values()[userChoise - 1];
	}
}
