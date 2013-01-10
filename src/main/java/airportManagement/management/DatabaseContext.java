package airportManagement.management;


import java.util.ArrayList;
import java.util.List;

import airportManagement.airline.Airline;
import airportManagement.airplane.Airplane;




	

	public class DatabaseContext {

		private static List<Airline> airlines=new ArrayList<Airline>();
		private static List<Airplane> airplanes=new ArrayList<Airplane>();
		
		public static List<Airline> getAirline() {
			return airlines;
		}
		public static List<Airplane> getCars() {
			return airplanes;
		}
		
		
	}
	
