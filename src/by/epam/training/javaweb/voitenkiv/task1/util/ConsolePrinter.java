package by.epam.training.javaweb.voitenkiv.task1.util;

import by.epam.training.javaweb.voitenkiv.task1.util.interfaceforutil.Printer;

public class ConsolePrinter implements Printer{

	@Override
	public void print(Object obj) {
		System.out.println(obj);
	}

}
