package character;

import simInterface.IObstructable;

public class JumperChocobo extends Chocobo implements IObstructable {

	private int turnCount;
	private int obstructedDuration;
	
	public JumperChocobo() {
		super.setSpeed(7.5);
		this.obstructedDuration = 0;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.setDistance(0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(this.getObstructedDuration() == 0) {
			this.setSpeed(7.5);
		}
		this.turnCount ++;
		if(this.turnCount %2 ==0)
			super.setDistance(super.getDistance()+super.getSpeed());
	}

	@Override
	public void obstructed() {
		// TODO Auto-generated method stub
		int check = this.getObstructedDuration();
		if(check == 0) {
			super.setSpeed(super.getSpeed()/2);
			this.setObstructedDuration(2);
		}
	}

	@Override
	public void setObstructedDuration(int durationOb) {
		// TODO Auto-generated method stub
		this.obstructedDuration = durationOb;
	}

	@Override
	public int getObstructedDuration() {
		// TODO Auto-generated method stub
		return this.obstructedDuration;
	}
	
}
