package airportManagement.management;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import airportManagement.airline.Airline;
import airportManagement.flight.Flight;



public class HibernateFlightManagerTests {

	
	private HibernateFlightManager mgr;
	private SessionFactory factory;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		factory = 
				new Configuration().configure().buildSessionFactory();
		mgr = new HibernateFlightManager(factory.openSession());
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		Flight result = mgr.get(1);
		Flight result2 = mgr.get(1);
		assertNotNull("brak wyników",result);
		assertEquals("zle ustawienie Id",result.getId(),1);
		
		assertEquals("zla godzina odlotu",result.getArrivalTime(), "TEST");
		assertEquals("zla godzina przylotu",result.getDepartureTime(),"TEST1");
		
				assertNotSame("obiekty nie powinny wskazywac na to samo pole w pamieci",
				result,result2);
			
	}

	@Test
	public void testGetAll() {
		List<Flight> results = mgr.getAll();
		
		assertNotNull("Lista jest nullem", results);
		assertTrue("ilosc elementów w liscie sie nie zgadza",
				results.size()==6);
	}

	@Test
	public void testSave() {
		Flight f = new Flight("TEST10","TEST", "TEST", "TEST", "TEST");
		mgr.save(f);
		Flight result = mgr.get(7);
		assertNotNull("nie zapisano do bazy",result);
		
		assertEquals("zla godzina odlotu",result.getArrivalTime(), "TEST10");
		assertEquals("zla godzina przylotu",result.getDepartureTime(),"TEST");
		
	
		
	}

	@Test
	public void testDelete() {
		Flight f = mgr.get(1);
		boolean deleted = mgr.delete(f);
		
		Flight result = mgr.get(1);
		assertTrue("nie skasowano",deleted);
		assertTrue("ilosc danych w bazie nie zmalala",
				mgr.getAll().size()==5);
		
	}

}
