package character;

public class RunnerChocobo extends Chocobo {

	public RunnerChocobo() {
		super.setSpeed(3);
	}
	
	public void start() {
		super.setSpeed(0);
	}
	public void run() {
		super.setDistance(super.getDistance()+super.getSpeed());
	}
	
}
