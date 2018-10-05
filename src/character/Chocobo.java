package character;

import simInterface.ICharacter;

public abstract class Chocobo implements ICharacter {

	protected double speed;
	protected double distance;
	
	public Chocobo() {
		this.distance = 0;
		this.speed = 0;
	}
	public double getSpeed() {
		return this.speed;
	}
	public double getDistance() {
		return this.distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int compareTo(Object o) {
		int value = 0;
		if (o instanceof character.Pikachu)  value = Double.compare(this.distance, ((character.Pikachu)o).getDistance());
		if (o instanceof character.JumperChocobo)  value = Double.compare(this.distance, ((character.JumperChocobo)o).getDistance());
		if (o instanceof RunnerChocobo)  value = Double.compare(this.distance, ((character.RunnerChocobo)o).getDistance());
		if(value < 0) {
			return -1;
		} else if (value > 0) {
			return 1;
		} else {
			if (o instanceof RunnerChocobo) {
				return 1;
			} else if ( o instanceof JumperChocobo) {
				return -1;
			} else {
				return -1;
			}
		}
	}
	
}
