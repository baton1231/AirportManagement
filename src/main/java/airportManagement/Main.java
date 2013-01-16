package airportManagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import airportManagement.airline.Airline;
import airportManagement.airplane.Airplane;
import airportManagement.airplane.PassengerAirplane;
import airportManagement.management.HibernateAirlineManager;
import airportManagement.management.ManagerInterface;
import airportManagement.pilots.Pilots;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session = factory.openSession();

		ManagerInterface<Airline> hib = new HibernateAirlineManager(session);

		Airline lot = new Airline("Lot", "Poland");
		Airline wizzair = new Airline("Wizzair","Hungary");
		Airplane boeing = new PassengerAirplane("Boeing 747", "250");
		Airplane boeing1 = new PassengerAirplane("Boeing 777", "200");
		Airplane airbus = new PassengerAirplane("Airbus A320", "150");
		Airplane airbus2 = new PassengerAirplane("Airbus A320", "150");
		
		Pilots marian = new Pilots("Marian","100");
		airbus.setPilots(new ArrayList<Pilots>());
	
		marian.setPilot(airbus2);
		marian.setPilot(boeing1);
		boeing.setOwner(lot);
		boeing1.setOwner(lot);
		airbus.setOwner(wizzair);
		airbus2.setOwner(wizzair);
		lot.getAirplanes().add(boeing);
		lot.getAirplanes().add(boeing1);
		wizzair.getAirplanes().add(airbus);
		wizzair.getAirplanes().add(airbus2);
		
		airbus2.getPilots().add(marian);
		boeing1.getPilots().add(marian);
		hib.save(lot);
		hib.save(wizzair);
			
		List<Airline> results = hib.getAll();

		for (Airline p : results) {
			System.out.println(p.getName());
		}

	}

}
