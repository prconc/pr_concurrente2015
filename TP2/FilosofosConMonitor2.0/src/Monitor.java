import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Monitor {
	
	private int[][] I;//Matriz de incidencia 
	private int[] M;//Marcado
	private int[] auxM, auxM2;//Marcados auxiliares
	private boolean permitido;//para verificar si tiene numeros negativos en el marcado
	private boolean condicion;//condicion para dejar el while
	private int G, J, aux1, aux2;
	
	
	//private semaforo mutex;
	//private VCSemaforo espera;
	
	private Lock lock = new ReentrantLock();
	private Condition espera = lock.newCondition();
	
	public Monitor(int[] m,int[][] i)
	{
		//mutex = new semaforo(1);
		//espera = new VCSemaforo(mutex);
		I=i;
		aux1=0;
		aux2=0;
		M=m;
		G=0;
		J=0;
		auxM = new int[m.length];
		auxM2= new int[m.length];
		condicion = true;
		permitido  = true;
	}
	
	public void comer(int t, int yo)
	{
		lock.lock();
		//mutex.Wait();
		
		while(condicion)//sale cuando puede tomar los palillos
		{
			for(int i=0; i < I.length ; i++)//genera el nuevo marcado en el marcado auxiliar
			{
				G=M[i];
				J=I[i][t];
				auxM[i] = G+J;
				if(auxM[i] < 0)//verifica si tiene un numero negativo el marcado nuevo
				{
					permitido = false;
				}
			}
			if(!permitido)//si tiene un numero negativo el nuevo marcado, no pude tomar los palillos y espera
			{
				System.out.println(yo + " no tiene palillos para comer \n");
				permitido = true;
				
				try {
					espera.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//espera.Delay();
			}
			else//puede tomar los palillos, cambia el marcado anterior por el nuevo
			{
				for(int j=0; j<I.length;j++)
				{
					M[j]=auxM[j];
				}
				condicion = false;//para poder salir del while
			}
		}
		
		condicion = true;//para que el siguiente en entrar en esta parte entre al while
		lock.unlock();
		//mutex.Signal();
	}
	
	public void dejarDeComer(int t, int yo)
	{
		//mutex.Wait();
		lock.lock();
		
		for(int i=0; i<M.length ; i++)//genera el nuevo marcado en una variable auxiliar
		{
			aux1=M[i];
			aux2=I[i][t];
			auxM2[i] = aux1+aux2;
		}
		
		for(int j=0; j<M.length; j++)//cambia el marcado anterior por el nuevo, este paso nunca genera numeros negativos
		{                            //por esto siempre se realiza, esto es por el orden de los eventos que realiza el filosofo
			M[j] = auxM2[j];
		}
		
		//espera.Resume();
		espera.signal();
		
		lock.unlock();
		//mutex.Signal();
	}
	public int[] marcado()//Me devuelve el marcado 
	{
		return M;
	}

}
