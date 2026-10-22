package concurrencia;

public class Concurrente {

	public static void main(String[] args) throws InterruptedException{
		Thread a = new TareaA();
		Thread b = new TareaB();
		
		Runnable tareaA = new TareaARunnable();
		Runnable tareaB = new TareaBRunnable();

//		a.run();
//		b.run();
//		no voy a llamar al run, porque así pierdo el paralelismo, porque directamente llama al método sin crear la hebra
//		voy a llamar a START
		
		a.start();
		b.start(); //no se garantiza el orden de ejecutar
		
		// Como hago para parar la hebra?
		//a.interrupt(); // solo flag para pararlo, luego lo tenemos que ejecutar dentro de TareaA
		System.out.println("Trabajo terminado."); // lo ejecuta al principio, porque el main
		//no espera a las hebras para ejecutar
		
		
		
		// Tengo que incluir un retardo
		Thread.sleep(10000); //estoy durmiendo la hebra que ejecuta main
		System.out.println("Trabajo terminado de verdad.");
		
		// También puedo esperar hasta que el trabajo termine por .join
		// Algo no funciona
//		a.start();
//		b.start();
//		a.join();
//		b.join();
//		System.out.println("Trabajo terminado de forma más eficiente");
	}
}
