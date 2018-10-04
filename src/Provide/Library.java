package Provide;

import java.util.Random;

public class Library {
	public final static int MIN = 1;
	public final static int MAX = 100;
	
	public static int randomChance() {
		Random randomNum = new Random();
		return MIN + randomNum.nextInt(MAX);
	}
}
