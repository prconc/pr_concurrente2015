
public class ProcesadorPetri {

	
	// Matriz de incidencia y marcado
	Matrix I, marcado;
	
	public ProcesadorPetri(Matrix incidencia, Matrix marcaInicial)
	{
		I = incidencia;
		marcado = marcaInicial;
	}
	
	synchronized public boolean disparar (Matrix disparo){
		
		Matrix multiplicacion = I.mult(disparo);		//resultado de I*d
		
		Matrix nuevoMarcado = marcado.plus(multiplicacion.transpose());		//resultado de m + I*d
		
		
		//se chequea si el marcado resultante es positivo.
		//en caso de ser positivo se actualiza el marcado y devuelve true
		//en caso de tener algun elemento negativo devuelve false y no actualiza
		//el marcado.
		if(nuevoMarcado.isPos()){
			marcado = nuevoMarcado;
			System.out.println("disparo exitoso");
			return true;
		}
		else{
			System.out.println("disparo no posible");
			return false;
		}
	}
	
	synchronized public void imprimirMarcado(){
		System.out.println("Marcado: "+ marcado.toString() );	
	}
	
}
