package airportManagement.passenger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Transient;

import airportManagement.flight.Flight;
import airportManagement.management.Context;

@Entity
public abstract class Passenger {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	protected Flight flightNo;

	@Transient
	Context context;

	public Passenger() {
		context = Context.getInstance();
		context.raisenumberOfFlights();

	}


	public void printData() {
		System.out.println("Lot: " + flightNo.getFlightNo());
		System.out.println(getFlightDetails());
	}

	public abstract String getFlightDetails();

	public void setFlight(Flight flightNo) {
		this.flightNo = flightNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
