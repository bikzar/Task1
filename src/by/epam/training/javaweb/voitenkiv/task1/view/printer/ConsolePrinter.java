package by.epam.training.javaweb.voitenkiv.task1.view.printer;

import by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class ConsolePrinter implements Printable{

	@Override
	public void print(Object obj) {
		System.out.println(obj);		
	}
	
}
