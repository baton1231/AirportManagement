package airplane;

import java.util.List;

import pilots.Pilots;

public interface AirplaneInterface {
	
	public int getPassengerCapacity();
	public void setPassengerCapacity(int passengerCapacity);
	public int getEconomyCapacity();
	public void setEconomyCapacity(int economyCapacity);
	public int getBussinesCapacity();
	public void setBussinesCapacity(int bussinesCapacity);
	public List<Pilots> getAll();
	
	
}
