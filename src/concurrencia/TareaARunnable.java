package concurrencia;

/*
 * Otra forma de crear hebras.
 * 
 */
public class TareaARunnable implements Runnable {
	
	@Override
	public void run() { //throws InterruptedException no puedo hacerlo, porque herido el metodo y tiene que tener la misma firma
		for (int i = 0; i<10; i++) {
			System.out.println("A: " + i);
			
			while (!Thread.currentThread().isInterrupted()) //de Concurrente le llega la informacion de interrupcion
				//tenemos que efectuarla aqui
				// si llega la interrupcion, esperamos 1000 (abajo)
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
