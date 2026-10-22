package condicion.carrera;

public class EjemploCarrera {
	
	public static void main(String[] args) throws InterruptedException {
		Contador c = new Contador();
		Thread i1 = new Incrementador(c);
		Thread i2 = new Incrementador(c);
		
		i1.start();
		i2.start();
		
		// Tengo que esperar hasta que terminen aumentando, si no se ejecuta el syso antes.
		i1.join();
		i2.join();
		System.out.println("Incrementador normal: " + c.getValor()); // No da un valor esperado, porque valor++ no es atomico, es decir
		// se puede dividir en pasos mas simples. Al ejecutarse i1 e i2 a la vez, tenemos
		// CONDICION DE CARRERA.
		
		Contador d = new Contador();

		Thread i3 = new IncrementadorSync(d);
		Thread i4 = new IncrementadorSync(d);
		
		System.out.println(i3 == i4);
		
		i3.start();
		i4.start();
		
		i3.join();
		i4.join();
		System.out.println("Incrementador synchronized: " + d.getValor());
		
		
	}
}
