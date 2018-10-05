package character;

import simInterface.IObstructable;
import simInterface.ICharacter;

public class Pikachu implements IObstructable, ICharacter {
	private double speed;
	private double distance;
	private int obstructedDuration;
	
	public Pikachu() {
		this.speed = 4;
		this.obstructedDuration = 0;
	}
	
	public void start() {
		this.setSpeed(4);
	}
	
	public void run() {
		if(this.getObstructedDuration() == 0)
			this.setSpeed(4);
		this.setDistance(this.getDistance()+this.getSpeed());
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	// required JUnit test (What)
	
	@Override
	public void obstructed() {
		// TODO Auto-generated method stub
		if((this.getObstructedDuration()) == 0) {
			this.setSpeed(0);
			this.setObstructedDuration(1);
		}
	}

	@Override
	public void setObstructedDuration(int dur) {
		// TODO Auto-generated method stub
		this.obstructedDuration = dur;
	}

	@Override
	public int getObstructedDuration() {
		// TODO Auto-generated method stub
		return this.obstructedDuration;
	}
	
	public int compareTo(Object o) {
		if (o instanceof character.JumperChocobo) {
			int check = Double.compare(this.distance,((character.JumperChocobo)o).distance);
			if(check < 0) {
				return -1;
			} else if (check > 0) {
				return 1;
			} else {
				return 1;
			}
		} else if(o instanceof character.RunnerChocobo){
			int check = Double.compare(this.distance,((character.RunnerChocobo)o).distance);
			if(check < 0) {
				return -1;
			} else if (check > 0) {
				return 1;
			} else {
				return 1;
			}
		}
		return 1;
//		if (o instanceof character.JumperChocobo) {
//			if(this.getDistance() > ((character.JumperChocobo)o).getDistance()) return 1;
//			if(this.getDistance() < ((character.JumperChocobo)o).getDistance()) return 1;
//
//		} else if (o instanceof character.RunnerChocobo) {
//			if(this.getDistance() > ((character.RunnerChocobo)o).getDistance()) return 1;
//			if(this.getDistance() < ((character.RunnerChocobo)o).getDistance()) return 1;
//
//		} 
//		return 1;
//	}

	}
}
