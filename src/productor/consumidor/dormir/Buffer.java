package productor.consumidor.dormir;

public class Buffer {
	private int dato;
	private boolean lleno = false; // Cuando arronce el buffer, esta vacio.
	
	// Hebra Productora -> P
	public synchronized void guardar (int dato) {
		while (lleno) {
			// Dormir / parar
			try {
				//Thread.sleep(500); no nos vale porque se va a dormir con el cerrojo
				wait(); // wait LIBERA EL CERROJO
			} catch (InterruptedException e) {
				return;
			}
			
		}
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor = " + dato);
		notifyAll();

	}
	
	// Si pongo synchronized en la cabecera, por defecto cierra con this: synchronized(this)
	// Hebra Consumidora -> C
	public synchronized int sacar() {
		while (!lleno) {
			// Dormir / parar
						try {
							//Thread.sleep(500); no nos vale porque se va a dormir con el cerrojo
							wait(); // wait LIBERA EL CERROJO
						} catch (InterruptedException e) {
							return -1;
						}
			
		}
		this.lleno = false;
		System.out.println("Sacado valor = " + dato);
		notifyAll();
		return dato;
	}

}
