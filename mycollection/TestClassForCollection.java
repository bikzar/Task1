package by.epam.training.javaweb.voitenkiv.task1.util.mycollection;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.CompanyCredit;
import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;
import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.IncorrectIndexOfElemException;
import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.exception.InputElementIsNullException;
import by.epam.training.javaweb.voitenkiv.task1.util.mycollection.mycollectioninterface.MyList;

public class TestClassForCollection {
	
	
	
	public static void main(String ... args) {
		MyList<Credit> list = new MyArrayList<>(15);
		
		Credit credit = new CompanyCredit();
		
		try {
			
			System.out.println(list.add(credit));
			
			System.out.println(list.add(credit));
			
			System.out.println(list.add(credit));
			
			System.out.println(list.contains(credit));
			
			System.out.println(list.indexOf(credit));
			
			System.out.println(list.get(1));
			
			Object[] cred = list.toArray();
			
			cred.clone();
			
			System.out.println(list.remove(credit));
			
			System.out.println(list.remove(1));
			
			
		} catch (InputElementIsNullException | IncorrectIndexOfElemException e) {
			e.printStackTrace();
		}
		
	}
	
}
