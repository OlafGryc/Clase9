package condicion.carrera;

public class IncrementadorSync extends Thread { //lo convierto en una hebra
	
	Contador c;
	Object cerrojo = new Object();
	
	public IncrementadorSync(Contador c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		for (int i = 0; i<100000; i++) {
			//Contador.incrementar(); no funciona porque incrementar no es static
			c.incrementarSync(cerrojo); //pasa el cerrojo como llave al synchronised
		}
	}

}
