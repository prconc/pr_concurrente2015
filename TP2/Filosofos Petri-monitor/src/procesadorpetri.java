public class procesadorpetri {

	// Matriz de incidencia.
	private int [][] Incidencia = {
			{ 1,0,0,0,0,-1,0,0,0,0 },
			{ 0,1,0,0,0,0,-1,0,0,0 },
			{ 0,0,1,0,0,0,0,-1,0,0 },
			{ 0,0,0,1,0,0,0,0,-1,0 },
			{ 0,0,0,0,1,0,0,0,0,-1 },
			{ -1,0,0,0,0,1,0,0,0,0 },
			{ 0,-1,0,0,0,0,1,0,0,0 },
			{ 0,0,-1,0,0,0,0,1,0,0 },
			{ 0,0,0,-1,0,0,0,0,1,0 },
			{ 0,0,0,0,-1,0,0,0,0,1 },
			{ -1,-1,0,0,0,1,1,0,0,0 },
			{ 0,-1,-1,0,0,0,1,1,0,0 },
			{ 0,0,-1,-1,0,0,0,1,1,0 },
			{ 0,0,0,-1,-1,0,0,0,1,1 },
			{ -1,0,0,0,-1,1,0,0,0,1 },
	};
	Matrix I=new Matrix(Incidencia);
	private int [][] m = {{ 0,0,0,0,0,1,1,1,1,1,1,1,1,1,1}};
	Matrix marcado=new Matrix(m);

	synchronized public boolean disparar (Matrix disparo)
	{
		Matrix multiplicacion= I.mult(disparo);
		Matrix NuevoMarcado=marcado.plus(multiplicacion.transpose());	

		if(NuevoMarcado.isPos())
		{	
			marcado=NuevoMarcado;
			//System.out.println("marcado:"+marcado.toString());
			return true;}
		else	    	{
			return false;
		}
	}
	synchronized public void imprimir_marcado(){
		marcado.toString();	
	}
}
