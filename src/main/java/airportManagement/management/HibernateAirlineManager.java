package airportManagement.management;

import java.util.List;

import org.hibernate.Session;

import airportManagement.airline.*;

public class HibernateAirlineManager implements ManagerInterface<Airline> {

	Session session;

	public HibernateAirlineManager(Session session) {
		this.session = session;
	}

	
	public Airline get(int id) {

		List<Airline> result = session.getNamedQuery("Airline.id")
				.setInteger("id", id).list();
		if (result.size() == 0)
			return null;

		Airline returnValue = new Airline(result.get(0).getName(), result.get(0).getCountry());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	
	public List<Airline> getAll() {
		List<Airline> result = session.getNamedQuery("Airline.all").list();
		return result;
	}

	public boolean save(Airline obj) {
		try {
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
		}

		return false;
	}

	public boolean delete(Airline obj) {
		try {
			session.beginTransaction();
			session.getNamedQuery("Airline.delete")
					.setInteger("id", obj.getId()).executeUpdate();

			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
		}

		return false;
	}

}
