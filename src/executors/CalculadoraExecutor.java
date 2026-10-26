package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculadoraExecutor {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TareaExecutor t1 = new TareaExecutor(4,5);
		TareaExecutor t2 = new TareaExecutor(5,7);

		ExecutorService executor = Executors.newFixedThreadPool(3); // crea hasta 3 hebras, segun tenga necesidad
		// No tendremos que iniciar las hebras, etc. Es un servicio.
		// Ponemos 3, que es el numero normal. Cada hebra se inicia en un nuevo nucleo.
		// Mac M1 tiene 8 nucleos en el CPU.
		
		//Creo un valor futuro, que solo toma valor cuando termine la tarea
		Future<Integer> futuro1 = executor.submit(t1); // nos devuelve un future<Integer>
		Future<Integer> futuro2 = executor.submit(t2);
		
		Integer res1 = futuro1.get(); // Espera hasta que acabe la tarea, devuelve un intiger
		Integer res2 = futuro2.get();
		
		System.out.println(res1 + res2);
		
		executor.shutdown(); //tengo que decirle al executor que no va a haber mas tareas

	}
	

}
