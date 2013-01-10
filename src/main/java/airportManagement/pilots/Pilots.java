package airportManagement.pilots;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import airportManagement.airplane.Airplane;

public class Pilots {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	protected Airplane pilots;
	
	
	private String name;
	private int experience;

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
		this.name=name;

	}

	public int getExperience() {
		// TODO Auto-generated method stub
		return experience;
	}

	public void setExperience(int experience) {
		this.experience=experience;

	}

}
