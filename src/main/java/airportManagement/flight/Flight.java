package airportManagement.flight;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import airportManagement.airline.Airline;
import airportManagement.airplane.Airplane;
import airportManagement.management.Context;
import airportManagement.passenger.Passenger;
import airportManagement.pilots.Pilots;


@Entity
@Table(name = "Flight")
@NamedQueries({
		@NamedQuery(name = "Flight.all", query = "from Flight f"),
		@NamedQuery(name = "Flight.id", query = "from Flight f where id= :id"),
		@NamedQuery(name = "Flight.delete", query = "Delete from Flight f where id=:id") })
public class Flight {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "FlightNo")
	private String flightNo;

	@OneToMany(mappedBy = "flightNo", cascade = CascadeType.PERSIST)
	private List<Passenger> passengers;

	@OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST)
	protected List<Airplane> airplane = new ArrayList<Airplane>();
	
	
	public List<Airplane> getAirplane() {
		return airplane;
	}

	public void setAirplane(List<Airplane> airplane) {
		this.airplane = airplane;
	}

	private String destination;
	private String departureTime;
	private String arrivalTime;
	private String ticketPrice;

	@Transient
	Context context;

	public Flight(String flightNo, String destination, String departureTime,
			String arrivalTime, String ticketPrice) {

		context = Context.getInstance();
		context.raisenumberOfFlights();
		this.flightNo = flightNo;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.ticketPrice = ticketPrice;
		this.passengers = new ArrayList<Passenger>();
		this.airplane = new ArrayList<Airplane>();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
