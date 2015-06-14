public class ProcesadorPetri {
	private Matrix M;
	private Matrix I;
	
	public ProcesadorPetri(int [][] incidence, int [][] marking){
		this.I = new Matrix(incidence);
		this.M = new Matrix(marking);
	}
	
	synchronized public boolean disparar(Matrix disparo){
		Matrix sigMarcado = M.plus(I.mult(disparo).transpose());
		
		if(sigMarcado.isPos()){
			M = sigMarcado;
			return true;
		}else{
			return false;
		}
	}
	
	synchronized public void imprimirM(){
		M.toString();
	}
}
