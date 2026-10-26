package productor.consumidor;

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
			boolean guardado = b.guardar(i); // Tengo que llamar a un objeto, no clase
			
			// Espera activa: espera y le seguimos pidiendo cosas
			while (!guardado) {
				guardado = b.guardar(i); // Si no se ha guardado, lo reintenta
			}
		}
	}

}
