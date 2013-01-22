package airportManagement;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import airportManagement.airline.Airline;
import airportManagement.airplane.Airplane;
import airportManagement.airplane.PassengerAirplane;
import airportManagement.flight.Flight;
import airportManagement.management.HibernateAirlineManager;
import airportManagement.management.HibernateFlightManager;
import airportManagement.management.ManagerInterface;
import airportManagement.passenger.BussinessPassenger;
import airportManagement.passenger.Passenger;
import airportManagement.pilots.Pilots;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session = factory.openSession();

		ManagerInterface<Airline> hib = new HibernateAirlineManager(session);
		ManagerInterface<Flight> hib1 = new HibernateFlightManager(session);
		
		
		
		// AIRLINES
		Airline lot = new Airline("Lot", "Poland");
		Airline wizzair = new Airline("Wizzair", "Hungary");
		Airline lufthansa = new Airline("Lufthansa", "Germany");
		Airline eurolot = new Airline("Eurolot", "Poland");
		Airline ae = new Airline("American Airlines", "USA");
		Airline ba = new Airline("British Airways", "United Kingdom");
		Airline aa = new Airline("Air Astana", "Kazakhstan");
		Airline af = new Airline("Air France", "France");
		// AIRPLANES
		Airplane boeing = new PassengerAirplane("Boeing 747", "250");
		Airplane boeing1 = new PassengerAirplane("Boeing 777", "200");
		Airplane airbus = new PassengerAirplane("Airbus A320", "150");
		Airplane airbus2 = new PassengerAirplane("Airbus A320", "150");
		// PILOTS
		Pilots marian = new Pilots("Marian", "100");
		airbus.setPilots(new ArrayList<Pilots>());
		// FLIGHTS
		Flight lo277 = new Flight("lo277", "New York", "12:00", "20:00", "1000");
		Passenger marian2 = new BussinessPassenger("Marian", "Marianowski");

		airbus.setFlight(lo277);

		// SET FLIGHT
		marian2.setFlight(lo277);
		// SET PILOT
		boeing.setFlight(lo277);
		marian.setPilot(airbus2);

		// SET OWNER
		boeing.setOwner(lot);
		boeing1.setOwner(lot);
		airbus.setOwner(wizzair);
		airbus2.setOwner(wizzair);
		// GET AIRPLANES

		lo277.getAirplane().add(boeing);
		lo277.getAirplane().add(airbus);
		lot.getAirplanes().add(boeing);
		lot.getAirplanes().add(boeing1);
		wizzair.getAirplanes().add(airbus);
		wizzair.getAirplanes().add(airbus2);
		// GET PASSENGERS
		lo277.getPassengers().add(marian2);

		// GET PILOTS
		airbus2.getPilots().add(marian);
		boeing1.getPilots().add(marian);

		// SAVE
		hib.save(lot);
		hib.save(wizzair);
		hib.save(lufthansa);
		hib.save(eurolot);
		hib.save(ae);
		hib.save(af);
		hib.save(ba);
		hib.save(aa);
		hib1.save(lo277);

		List<Airline> results = hib.getAll();

	for (Airline a : results) {
			System.out.println(a.getName());
		}

	}

}
