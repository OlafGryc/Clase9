package productor.consumidor;

public class Buffer {
	private int dato;
	private boolean lleno = false; // Cuando arronce el buffer, esta vacio.
	
	public synchronized boolean guardar (int dato) {
		if (!lleno) {
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor = " + dato);
		return true;
		}
		return false;
	}
	
	public synchronized int sacar() {
		if (lleno) {
			this.lleno = false;
			System.out.println("Sacado valor = " + dato);
			return dato;
		}
		return -1;
		
	}

}
