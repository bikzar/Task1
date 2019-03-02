package by.epam.training.javaweb.voitenkiv.task1.model.logic.comparator;

import java.util.Comparator;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;

public class CompanyCreditTypeOfCompanyComparator
	implements Comparator<CompanyCredit> {

    @Override
    public int compare(CompanyCredit arg0, CompanyCredit arg1) {
	return arg0.getSizeOfCompany()
		.compareTo(arg1.getSizeOfCompany());
    }

}
