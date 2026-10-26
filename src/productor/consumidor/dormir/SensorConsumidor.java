package productor.consumidor.dormir;

public class SensorConsumidor extends Thread {

	Buffer b;
		
	SensorConsumidor (Buffer b){
		this.b = b;
	}
		
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			b.sacar(); 
		}
	}
	
}
