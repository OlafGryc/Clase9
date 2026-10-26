package executors;

public class Calculadora {

	public static void main(String[] args) throws InterruptedException {
		//Thread a = new HebraCalculo();
		HebraCalculo b = new HebraCalculo(4,5); // He crado 2 hebras, cada una con su tarea
		HebraCalculo c = new HebraCalculo(5,7);

		//a.start();
		b.start();
		c.start();
		
		b.join();
		c.join();
		
		//System.out.println(a.getRes()); // da error, pq ponemos Thread a = ..., luego a solo tendra metodos de clase Thread
		System.out.println(b.getRes() + c.getRes());
	}
}
