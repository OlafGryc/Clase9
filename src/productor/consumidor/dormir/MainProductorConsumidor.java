package productor.consumidor.dormir;

public class MainProductorConsumidor {
	
	public static void main(String[] args) {
		Buffer b = new Buffer();
		
		Thread p = new SensorProductor(b);
		Thread c = new SensorConsumidor(b);
		
		p.start();
		c.start();
	}

}
