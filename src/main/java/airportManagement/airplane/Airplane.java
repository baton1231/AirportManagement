package airportManagement.airplane;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import airportManagement.airline.Airline;
import airportManagement.flight.Flight;
import airportManagement.management.Context;
import airportManagement.pilots.Pilots;


@Entity
public abstract class Airplane {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	protected Airline owner;
	
	@OneToMany(mappedBy = "planes", cascade = CascadeType.PERSIST)
	protected List<Pilots> pilots = new ArrayList<Pilots>();
	
	@ManyToOne
	protected Flight flight;
	
	@Transient
	Context context;

	public Airplane() {
		context = Context.getInstance();
		context.raiseNumberOfAirplanes();
		
	}
	

	public List<Pilots> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilots> pilots) {
		this.pilots = pilots;
	}

	public void printData() {
		System.out.println("Owner: " + owner.getName());
		System.out.println(getAirplaneDetails());
	}

	public abstract String getAirplaneDetails();

	public abstract Airplane Clone();

	public void setOwner(Airline owner) {
		this.owner = owner;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}


