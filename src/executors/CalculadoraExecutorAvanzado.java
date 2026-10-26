package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculadoraExecutorAvanzado {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int start =0;
		int end = 103;
		int tareaSize = 20;
		
		List<TareaExecutor> tareas = new ArrayList<>();
		
		for (int i = start; i <= end; i+=tareaSize) {
			
			if (i+tareaSize <= end) {
				TareaExecutor t = new TareaExecutor(i, i+tareaSize);
				tareas.add(t);
			} else {
				TareaExecutor t = new TareaExecutor(i,end);
				tareas.add(t);
			}
		}
		
		
		TareaExecutor t1 = new TareaExecutor(4,5);
		TareaExecutor t2 = new TareaExecutor(5,7);

		ExecutorService executor = Executors.newFixedThreadPool(3); // crea hasta 3 hebras, segun tenga necesidad
		// No tendremos que iniciar las hebras, etc. Es un servicio.
		// Ponemos 3, que es el numero normal. Cada hebra se inicia en un nuevo nucleo.
		// Mac M1 tiene 8 nucleos en el CPU.
		
		List<Future<Integer>> futuros = new ArrayList<>();
		
		// Les mando todos a trabajar
		for (TareaExecutor t : tareas) {
			futuros.add(executor.submit(t));
		}
		
		int res = 0;
		
		for (Future<Integer> f : futuros) {
			res+= f.get();
		}
		System.out.println(res);
		
		executor.shutdown(); //Tengo que decirle al executor que no va a haber mas tareas

	}
	

}
