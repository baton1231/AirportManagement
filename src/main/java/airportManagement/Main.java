package airportManagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import airportManagement.airline.Airline;
import airportManagement.airplane.Airplane;
import airportManagement.airplane.PassengerAirplane;
import airportManagement.management.HibernateAirlineManager;
import airportManagement.management.ManagerInterface;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session = factory.openSession();

		ManagerInterface<Airline> hib = new HibernateAirlineManager(session);

		Airline lot = new Airline("Lot", "Poland");
		Airplane boeing = new PassengerAirplane("Boeing 747", "250");
		Airplane boeing1 = new PassengerAirplane("Boeing 777", "200");
		boeing.setOwner(lot);
		boeing1.setOwner(lot);
		lot.getAirplanes().add(boeing);
		lot.getAirplanes().add(boeing1);

		hib.save(lot);

		List<Airline> results = hib.getAll();

		for (Airline p : results) {
			System.out.println(p.getName());
		}

	}

}
