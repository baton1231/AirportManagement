package airportManagement.airplane;

import java.util.ArrayList;

import javax.persistence.Entity;

import airportManagement.pilots.Pilots;


@Entity
public class PassengerAirplane extends Airplane {

	private String name;
	private String capacity;
	public ArrayList<Pilots> pilots;

	public PassengerAirplane(String name, String capacity) {
		this.name = name;
		this.capacity = capacity;
		this.pilots = new ArrayList<Pilots>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Pilots> getPilots() {
		return pilots;
	}

	public void setPilots(ArrayList<Pilots> pilots) {
		this.pilots = pilots;
	}

	public PassengerAirplane() {
		this("", "");
	}

	@Override
	public String getAirplaneDetails() {
		// TODO Auto-generated method stub
		return name + " " + capacity + " " + pilots;
	}

	@Override
	public Airplane Clone() {

		PassengerAirplane returnValue = new PassengerAirplane();
		returnValue.setCapacity(this.capacity);

		return returnValue;
	}
}
