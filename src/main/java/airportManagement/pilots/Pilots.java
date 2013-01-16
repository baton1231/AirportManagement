package airportManagement.pilots;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import airportManagement.airplane.Airplane;

@Entity
public class Pilots {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	protected Airplane planes;

	public Pilots(String name, String experience) {
		this.name = name;
		this.experience = experience;

	}

	private String name;
	private String experience;

	public Airplane getPlanes() {
		return planes;
	}

	public void setPlanes(Airplane planes) {
		this.planes = planes;
	}

	public void setPilot(Airplane pilots) {
		this.planes = pilots;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;

	}

}
