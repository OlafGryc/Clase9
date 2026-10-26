package productor.consumidor.dormir;

/*
 * Es hebra que va consumiendo.
 */

public class SensorProductor extends Thread {
	
	Buffer b;
	
	SensorProductor (Buffer b){
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			b.guardar(i); // Tengo que llamar a un objeto, no clase
			
		}
	}

}
