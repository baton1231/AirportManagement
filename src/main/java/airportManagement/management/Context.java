package airportManagement.management;



public final class Context {

	private int quantityOfAirplanes;
	private int quantityOfAirline;
	private int quantityOfFlights;
	private int quantityOfPassenger;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void reduceAirplanes()
	{
		this.quantityOfAirplanes--;
	}
	
	public void reduceAirlines()
	{
		this.quantityOfAirline--;
	}
	public void raiseNumberOfAirplanes()
	{
		this.quantityOfAirplanes++;
	}

	public void reduceFlights()
	{
		this.quantityOfFlights--;
	}
	public void raisenumberOfAirlines()
	{
		this.quantityOfAirline++;
	}
	public void raisenumberOfFlights()
	{
		this.quantityOfFlights++;
	}
	public int getQuantityOfAirlines()
	{
		return this.quantityOfAirline;
	}
	public int getQuantity()
	{
		return this.quantityOfAirplanes;
	}
	public int getQuantityOfFlights()
	{
		return this.quantityOfFlights;
	}
	public void raiseNumberOfPassenger()
	{
		this.quantityOfPassenger++;
	}
}
