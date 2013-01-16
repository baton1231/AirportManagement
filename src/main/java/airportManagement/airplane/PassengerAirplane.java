package airportManagement.airplane;

import java.util.ArrayList;

import javax.persistence.Entity;

import airportManagement.pilots.Pilots;


@Entity
public class PassengerAirplane extends Airplane {

	private String name;
	private String capacity;
	

	public PassengerAirplane(String name, String capacity) {
		this.name = name;
		this.capacity = capacity;
		
	}


	@Override
	public String getAirplaneDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Airplane Clone() {
		// TODO Auto-generated method stub
		return null;
	}


	

	
}
