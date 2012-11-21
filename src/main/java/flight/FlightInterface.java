package flight;

import java.util.Date;

public interface FlightInterface {
	

	
	public String getDestination();
	public void setDestination(String destination);
	public Date getDepartureTime();
	public void setDepartureTime(Date departureTime);
	public Date getarrivalTime();
	public void setarrivalTime(Date arrivalTime);
	public int getTicketPrice();
	public void setTicketPrice(int ticketPrice);
	

}
