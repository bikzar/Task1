/*
 
 It's just only for me. It's only Test.
 
 */

package by.epam.training.javaweb.voitenkiv.task1.viwe;

import by.epam.training.javaweb.voitenkiv.task1.model.appinterface.CreditHolder;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.NationalBank;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.SizeOfCompany;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.entityenum.TypeOfCurrensy;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.InputFinancialIntermediaryIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.exception.ListOfCreditIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.financialintermediary.Bank;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.CreditSearcher;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.Sorter;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator.CreditPercentageComparator;
import by.epam.training.javaweb.voitenkiv.task1.model.logic.exception.InputNationalBankInstIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.util.NationalBankCreator;

public class Test {

	public static void main(String[] args) {
		try {
			
			NationalBank nationalBank = NationalBankCreator.creatNationalBank();
			
			Credit credit = null;
			
			Credit[] listcred = new Credit[] {credit};
			
			Bank bank = new Bank(55, "My bank");
			
			bank.setListOfCredit(listcred);
			
			nationalBank.addFinIntermedToList(bank);
						
			Credit creditForSearch = new CompanyCredit(
					SizeOfCompany.High, "133", TypeOfCurrensy.Dollor,
					999, true, 10000000, true, true);

			for (CreditHolder cred : CreditSearcher
					.searchCreditWithParametrs(nationalBank,
							creditForSearch)) {

				Credit[] list = cred.getListOfCredit();

				Sorter.sortOfCreditList(0, list.length - 1, list,
						new CreditPercentageComparator());

				cred.setListOfCredit(list);

				System.out.println(cred);
			}

		} catch (InputFinancialIntermediaryIsNullException
				| InputCreditIsNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputNationalBankInstIsNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ListOfCreditIsNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
