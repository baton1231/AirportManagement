package airportManagement.airline;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



import airportManagement.airplane.Airplane;
import airportManagement.management.Context;

@Entity
@Table(name = "Airline")
@NamedQueries({
		@NamedQuery(name = "Airline.all", query = "from Airline a"),
		@NamedQuery(name = "Airline.id", query = "from Airline a where id= :id"),
		@NamedQuery(name = "Airline.delete", query = "Delete from Airline a where id=:id") })


public class Airline {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "Nazwa")
	private String name;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	private List<Airplane> airplanes;

	private String country;

	@Transient
	Context context;

	public Airline(String name, String country) {
		context = Context.getInstance();
		context.raisenumberOfAirlines();
		this.country = country;
		this.name = name;
		this.airplanes = new ArrayList<Airplane>();
	}

	public Airline(String name) {

		this(name, "");
	}

	public Airline() {

		this("", "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
