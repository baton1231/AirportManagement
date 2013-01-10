package airportManagement.airplane;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import airportManagement.airline.Airline;
import airportManagement.management.Context;
import airportManagement.pilots.Pilots;


@Entity
public abstract class Airplane {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	protected Airline owner;
	
	//@OneToMany(mappedBy = "pilot", cascade = CascadeType.PERSIST)
	//private List<Pilots> pilots;

	@Transient//
	Context context;

	public Airplane() {
		context = Context.getInstance();
		context.raiseNumberOfAirplanes();
		//this.pilots = new ArrayList<Pilots>();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}


