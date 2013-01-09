package airline;

import java.util.List;

import airplane.Airplane;


public class Airline {

	private String name;
	private String country;
	private List<Airplane> airplaneList;

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {
		this.country = country;

	}

	public List<Airplane> getAll() {
		// TODO Auto-generated method stub

		return airplaneList;
	}

}
