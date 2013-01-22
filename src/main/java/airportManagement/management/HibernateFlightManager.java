package airportManagement.management;

import java.util.List;

import org.hibernate.Session;


import airportManagement.flight.Flight;

public class HibernateFlightManager implements ManagerInterface<Flight> {
	Session session;
	
	public HibernateFlightManager(Session session) {
		this.session = session;
	}
	
	
	@Override
	public Flight get(int id) {
		List<Flight> result = session.getNamedQuery("Flight.id")
				.setInteger("id", id).list();
		if (result.size() == 0)
			return null;

		Flight returnValue = new Flight(result.get(0).getArrivalTime(), result.get(0).getDepartureTime(), result.get(0).getDestination(), result.get(0).getFlightNo(), result
				.get(0).getTicketPrice());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Flight> getAll() {
		List<Flight> result = session.getNamedQuery("Flight.all").list();
		return result;
	}

	
	public boolean save(Flight obj) {
		try {
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
		}

		return false;
	}

	
	public boolean delete(Flight obj) {
		try {
			session.beginTransaction();
			session.getNamedQuery("Flight.delete")
					.setInteger("id", obj.getId()).executeUpdate();

			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
		}

		return false;
	}


}
