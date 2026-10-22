package productor.consumidor;

public class SensorConsumidor extends Thread {

	Buffer b;
		
	SensorConsumidor (Buffer b){
		this.b = b;
	}
		
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int valor = b.sacar(); // Tengo que llamar a un objeto, no clase
			
			while (valor == -1) {
				valor = b.sacar();
			}
					}
	}
	
}
