package by.epam.training.javaweb.voitenkiv.task1.util;

import java.util.Scanner;

public class UserInputScanner {
		
	public static int readInt() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int userInput = -1;
		
		if(scanner.hasNextInt()) {
			userInput = scanner.nextInt();
		}
		
		return userInput;
	}
	
	public static String readString() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String userInput = "";
		
		if(scanner.hasNext()) {
			userInput = scanner.nextLine();
		}
		
		return userInput;
	}
	
}
