package airline;

import java.util.List;

import airplane.Airplane;


public interface AirlineInterface {
	
	public String getName();
	public void setName(String name);
	public String getCountry();
	public void setCountry(String country);
	public List<Airplane> getAll();

}
