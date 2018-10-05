package main;

import java.util.*;

import simInterface.ICharacter;



public class RacingManager {
	
	public static final double GOAL = 100;
	public static ICharacter characters[] = new ICharacter[3];
	private static Scanner kb;
	public static boolean hasWinner;
	

	public static double getGoal() {
		return GOAL;
	}
	
	public static ICharacter[] getCharacters() {
		return characters;
	}
	
	public static boolean hasWinner() {
		return hasWinner;
	}
	
	public static void initializeCharacter() {
		characters[0] = new character.RunnerChocobo();
		characters[0].start();
		characters[1] = new character.JumperChocobo();
		characters[1].start();
		characters[2] = new character.Pikachu();
		characters[2].start();
	}
	
	public static void sortCharacter() {
		Arrays.sort(characters);
	}
	
	public static boolean checkWinner(ICharacter crt) {
		if(crt.getDistance() >= GOAL) {
			hasWinner = true;
			return true;
		} else {
			return false;
		}
	}
	
	public static void randomObstrusctedCharacters() {
		int randomNum = Provide.Library.randomChance();
		if(randomNum <= 20) {
			for(ICharacter mem : characters) {
				if(mem instanceof character.JumperChocobo) {
					((character.JumperChocobo) mem).obstructed();
				}
			}
		} else if (randomNum <= 40) {
			for(ICharacter mem : characters) {
				if(mem instanceof character.Pikachu) {
					((character.Pikachu) mem).obstructed();
				}
			}	
		} else if (randomNum <= 60) {
			for(ICharacter mem : characters) {
				if(mem instanceof character.JumperChocobo) {
					((character.JumperChocobo) mem).obstructed();
				} else if(mem instanceof character.Pikachu){
					((character.Pikachu) mem).obstructed();
				}
			}	
		} else {

		}
	}
	
	public static void decreaseObstructedDuration() {
		for(int i=0;i<characters.length;i++) {
			if(characters[i] instanceof character.Pikachu) {
				if(((character.Pikachu)characters[i]).getObstructedDuration() == 0) {
					((character.Pikachu)characters[i]).setSpeed(4);
				} else {
					int dur = ((character.Pikachu)characters[i]).getObstructedDuration();
					((character.Pikachu)characters[i]).setObstructedDuration(dur-1);
				}
			} else if (characters[i] instanceof character.JumperChocobo) {
				if(((character.JumperChocobo)characters[i]).getObstructedDuration() == 0) {
					((character.JumperChocobo)characters[i]).setSpeed(7.5);
				} else {
					int dur = ((character.JumperChocobo)characters[i]).getObstructedDuration();
					((character.JumperChocobo)characters[i]).setObstructedDuration(dur-1);
				}
			}
		}
	}


	public static void main(String[] args) {
		kb = new Scanner(System.in);
		System.out.println("Welcome to CHOCOBO RACING.\nThe goal at distance 100 m.\n");
		System.out.println("Press 'any key' to START.");
		kb.nextLine();

		System.out.printf("Initialized Characters\n");
		initializeCharacter();
		int i = 0;
		while(!hasWinner) {
			printRound(i++);
			sortCharacter();
			decreaseObstructedDuration();
			randomObstrusctedCharacters();
			for(ICharacter mem : characters) {
				mem.run();
				printCharacterDistance(mem.getClass().toString(),mem.getDistance());
				if (checkWinner(mem)) {
					printTheWinner(mem.getClass().toString().substring(11, mem.getClass().toString().length()));
				}
			}
		}
	}          

	public static void printRound(int round) {
		System.out.printf("\nRound %d\n", round);
	}

	public static void printCharacterDistance(String characterName, double characterDistance) {
		System.out.printf("- %s distance : %.2f\n", characterName, characterDistance);
	}

	public static void printJumperChocoboPreparingToJump(double jumperChocoboDistance) {
		System.out.printf("- JumperChocobo distance : %.2f and preparing to jump\n", jumperChocoboDistance);
	}

	public static void printJumperChocoboObstructed() {
		System.out.printf("+ JumperChocobo has obstructed > speed down for 2 seconds\n");
	}

	public static void printPikachuObstructed() {
		System.out.printf("+ Pikachu has obstructed > stop running for 1 second\n");
	}

	public static void printTheWinner(String characterName) {
		System.out.printf("\n%s is the WINNER!", characterName);
	}
	

}
