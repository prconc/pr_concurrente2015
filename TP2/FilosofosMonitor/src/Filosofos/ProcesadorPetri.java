package Filosofos;

public class ProcesadorPetri 
{

	private int [][] incidencia = {{-1,0,1,0,0,0,0,0,0,0},
		{0,-1,0,1,0,0,0,0,0,0},
		{-1,-1,1,1,0,0,0,0,0,0},
		{-1,0,1,0,0,0,0,0,-1,1},
		{1,0,-1,0,0,0,0,0,0,0},
		{0,-1,0,1,-1,1,0,0,0,0},
		{0,1,0,-1,0,0,0,0,0,0},
		{0,0,0,0,-1,1,0,0,0,0},
		{0,0,0,0,1,-1,0,0,0,0},
		{0,0,0,0,0,0,1,-1,0,0},
		{0,0,0,0,0,0,-1,1,0,0},
		{0,0,0,0,-1,1,1,-1,0,0},
		{0,0,0,0,0,0,1,-1,-1,1},
		{0,0,0,0,0,0,0,0,1,-1},
		{0,0,0,0,0,0,0,0,-1,1}
		};
	Matrix inci = new Matrix(incidencia);
	
	private int [][] marcado = {{1,1,1,1,0,1,0,1,0,1,0,1,1,0,1}};
	Matrix marc = new Matrix(marcado);
	
	synchronized public boolean ejecutar(Matrix trans)
	{
		Matrix mult = inci.mult(trans);
		Matrix marcadoNuevo = marc.plus(mult.transpose());
		
		if(marcadoNuevo.isPos())
		{
			marc = marcadoNuevo;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	synchronized public void getMarcado()
	{
		marcado.toString();
		
	}
}
