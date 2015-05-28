package principal;

import clases.Filosofos;
import clases.Monitores;
import clases.Redes;

public class Main 
{

	public static void main(String[] args) 
	{
                int iFilisofos = 5;
		Filosofos[] oFilosofos = new Filosofos[iFilisofos];
                
                int[][]iMarcado = {{1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,}};
                
                int[][] iIncidencia = {{-1,0,0,0,0,1,0,0,0,0},
                                       {0,-1,0,0,0,0,1,0,0,0},
                                       {0,0,-1,0,0,0,0,1,0,0},
                                       {0,0,0,-1,0,0,0,0,1,0},
                                       {0,0,0,0,-1,0,0,0,0,1},
                                       {0,0,1,0,0,0,0,-1,0,0},
                                       {0,0,0,1,0,0,0,0,-1,0},
                                       {0,0,0,0,1,0,0,0,0,-1},
                                       {1,0,0,0,0,-1,0,0,0,0},
                                       {0,1,0,0,0,0,-1,0,0,0},
                                       {-1,0,0,0,-1,1,0,0,0,0},
                                       {-1,-1,0,0,0,1,1,0,0,0},
                                       {0,-1,-1,0,0,0,1,1,0,0},
                                       {0,0,-1,-1,0,0,0,1,1,0},
                                       {0,0,0,-1,-1,0,0,0,1,1}
                };
                int[][] iDisparo = {{1,0,1,0,0,0,0,0,0,0}};
                
		Redes oRed = new Redes(iMarcado,iIncidencia);
                
		Monitores oMonitor = new Monitores(oRed);
		for (int i = 0; i < iFilisofos; i++) 
		{
                    oFilosofos[i] = new Filosofos(oMonitor);
                    oFilosofos[i].setsNombre("Filosofo"+i);
                    oFilosofos[i].start();
                    System.out.println("El " + oFilosofos[i].getsNombre() +" se creo!");
		}
		for (int i = 0; i < iFilisofos; i++) 
		{
                    try 
                    {
                            oFilosofos[i].join();
                    } catch (InterruptedException e) 
                    {
                            System.out.println(e.getMessage());
                    }
                    System.out.print("\nTermino\n");
                    System.exit(0);
		}
	}

}
