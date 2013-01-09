package flight;

import java.util.Date;

public class Flight {

	private String destination;
	private Date departureTime;
	private Date arrivalTime;
	private int ticketPrice;

	public String getDestination() {
		
		return destination;
	}

	public void setDestination(String destination) {
		this.destination=destination;

	}

	public Date getDepartureTime() {
		
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime=departureTime;

	}

	public Date getarrivalTime() {
		
		return arrivalTime;
	}

	public void setarrivalTime(Date arrivalTime) {
		this.arrivalTime=arrivalTime;

	}

	public int getTicketPrice() {
		
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice=ticketPrice;

	}

}
