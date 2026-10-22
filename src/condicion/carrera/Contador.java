package condicion.carrera;

/*
 * Tenemos un valor en Contador y queremos acceder a ello con Thread1 y Threa2 para cambiarlo.
 * 
 */

public class Contador {
	
	private int valor = 0; //definimos como private para protegerlo
	
	public void incrementar() {
		valor++; // Region critica -> debo aplicar exclusion exclusion mutua
		
		// valor ++ no es una fucion simple, lo que hace es:
		// int tmp = valor; -> Leyendo el valor
		// tmp = tmp + 1; -> Calculando el nuevo valor
		// valor = tmp; -> Actualizando el valor
		// Operacion no atomica -> Condicion de carrera
	}
	
//	public synchronized void incrementarSync() { tb se puede usar
//		valor++;
//	}
	
	public synchronized void incrementarSync(Object cerrojo) {
		synchronized(cerrojo) { // this se refiere a la instancia actual de this,
			// no deberia funcionar porque el cerrojo es distinto para i3 e i4, ya que se crea sobre contadores distintos
		valor++;
		}
	}
	
	public int getValor() {
		return this.valor;
	}

}
