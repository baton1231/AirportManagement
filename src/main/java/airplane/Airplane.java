package airplane;

import java.util.List;

import pilots.Pilots;

public class Airplane implements AirplaneInterface {

	private int passengerCapacity;
	private int economyCapacity;
	private int bussinesCapacity;
	private List<Pilots> pilotsList;

	
	
	public int getPassengerCapacity() {
		
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity=passengerCapacity;

	}

	public int getEconomyCapacity() {
		
		return economyCapacity;
	}

	public void setEconomyCapacity(int economyCapacity) {
		this.economyCapacity=economyCapacity;

	}

	public int getBussinesCapacity() {
		
		return bussinesCapacity;
	}

	public void setBussinesCapacity(int bussinesCapacity) {
		this.bussinesCapacity=bussinesCapacity;

	}

	public List<Pilots> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
