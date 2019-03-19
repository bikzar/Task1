package by.epam.training.javaweb.voitenkiv.task1.util.creator.randomdatagenerator;

import java.util.Random;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class MainRandom {
	private static final Random MAIN_RANDOM;
	
	static{
		MAIN_RANDOM = new Random();
	}
	
	public static Random getRand(){
		return MAIN_RANDOM;
	}	
}
