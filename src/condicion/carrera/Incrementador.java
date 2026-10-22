package condicion.carrera;

public class Incrementador extends Thread { //lo convierto en una hebra
	
	Contador c;
	
	public Incrementador(Contador c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		for (int i = 0; i<100000; i++) {
			//Contador.incrementar(); no funciona porque incrementar no es static
			c.incrementar();
		}
	}

}
