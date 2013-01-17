package airportManagement.passenger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import airportManagement.flight.Flight;
import airportManagement.management.Context;

@Entity
// @Table(name = "Passenger")
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

//	public Flight getPassenger() {
//		return passengers;
//	}
//
//	public void setPassenger(Flight passengers) {
//		this.passengers = passengers;
//	}

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
