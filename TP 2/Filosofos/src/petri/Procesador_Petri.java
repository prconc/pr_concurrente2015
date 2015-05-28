package petri;


public class Procesador_Petri {
	
	Matrix mx, marcado;
	
	public Procesador_Petri(int [][] I, int [][] marca){
		
		mx = new Matrix (I);
		marcado = new Matrix(marca);
	
	}
	
	synchronized public boolean disparar (Matrix  disparo)
	{
		Matrix marcadoAux = marcado;
		marcadoAux  = marcado.plus(mx.mult(disparo.transpose()).transpose());
		
		
		if(marcadoAux.isPos()){
			marcado = marcadoAux;
			return true;
		}
		else{
			return false;
		}
	}
	
	public Matrix getMarcado() 
	{
		return marcado;
	}
}