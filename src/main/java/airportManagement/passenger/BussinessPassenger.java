package airportManagement.passenger;

import javax.persistence.Entity;

@Entity
public class BussinessPassenger extends Passenger {

	private String name;
	private String surname;

	public BussinessPassenger(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}


	@Override
	public String getFlightDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
