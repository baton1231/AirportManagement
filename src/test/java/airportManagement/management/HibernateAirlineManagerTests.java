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



public class HibernateAirlineManagerTests {

	
	private HibernateAirlineManager mgr;
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
		mgr = new HibernateAirlineManager(factory.openSession());
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		Airline result = mgr.get(1);
		Airline result2 = mgr.get(1);
		assertNotNull("brak wyników",result);
		assertEquals("zle ustawienie Id",result.getId(),1);
		
		assertEquals("zle ustawienie kraju",result.getCountry(),"TEST1");
		assertEquals("zle ustawienie imion",result.getName(), "TEST");
				assertNotSame("obiekty nie powinny wskazywac na to samo pole w pamieci",
				result,result2);
			
	}

	@Test
	public void testGetAll() {
		List<Airline> results = mgr.getAll();
		
		assertNotNull("Lista jest nullem", results);
		assertTrue("ilosc elementów w liscie sie nie zgadza",
				results.size()==6);
	}

	@Test
	public void testSave() {
		Airline a = new Airline("TEST10","TEST10");
		mgr.save(a);
		Airline result = mgr.get(7);
		assertNotNull("nie zapisano do bazy",result);
		assertEquals("zle ustawienie kraju",result.getCountry(),"TEST10");
		assertEquals("zle ustawienie imion",result.getName(), "TEST10");
	
		
	}

	@Test
	public void testDelete() {
		Airline a = mgr.get(1);
		boolean deleted = mgr.delete(a);
		
		Airline result = mgr.get(1);
		assertTrue("nie skasowano",deleted);
		assertTrue("ilosc danych w bazie nie zmalala",
				mgr.getAll().size()==5);
		
	}

}
