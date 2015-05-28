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
                int[][] iMarcadoInicial = {{1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}};
                int[][] iIncidencia =   {
                                        {-1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                                        {0, -1, 0, 0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, -1, 0, 0, 0, 0, 1, 0, 0},
                                        {0, 0, 0, -1, 0, 0, 0, 0, 1, 0},
                                        {0, 0, 0, 0, -1, 0, 0, 0, 0, 1},
                                        {0, 0, 1, 0, 0, 0, 0, -1, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0, 0, -1, 0},
                                        {0, 0, 0, 0, 1, 0, 0, 0, 0, -1},
                                        {1, 0, 0, 0, 0, -1, 0, 0, 0, 0},
                                        {0, 1, 0, 0, 0, 0, -1, 0, 0, 0},
                                        {-1, 0, 0, 0, -1, 1, 0, 0, 0, 0},
                                        {-1, -1, 0, 0, 0, 1, 1, 0, 0, 0},
                                        {0, -1, -1, 0, 0, 0, 1, 1, 0, 0},
                                        {0, 0, -1, -1, 0, 0, 0, 1, 1, 0},
                                        {0, 0, 0, -1, -1, 0, 0, 0, 1, 1}
                                        };
		Redes oRed = new Redes(iMarcadoInicial,iIncidencia);               
                int[][] iDisparo1a = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                int[][] iDisparo1b = {{0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};
                int[][] iDisparo2a = {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}};
                int[][] iDisparo2b = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};
                int[][] iDisparo3a = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}};
                int[][] iDisparo3b = {{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}};
                int[][] iDisparo4a = {{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}};
                int[][] iDisparo4b = {{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
                int[][] iDisparo5a = {{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
                int[][] iDisparo5b = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
                
		Monitores oMonitor = new Monitores(oRed);
		for (int i = 0; i < iFilisofos; i++) 
		{
                    oFilosofos[i] = new Filosofos(oMonitor);
                    oFilosofos[i].setsNombre("Filosofo"+i);
                    switch (i)
                    {
                        case 0:
                            oFilosofos[0].setDisparo(iDisparo1a,iDisparo1b);
                            break;
                        case 1:
                            oFilosofos[1].setDisparo(iDisparo2a,iDisparo2b);
                            break;
                        case 2:
                            oFilosofos[2].setDisparo(iDisparo3a,iDisparo3b);
                            break;
                        case 3:
                            oFilosofos[3].setDisparo(iDisparo4a,iDisparo4b);
                            break;
                        case 4:
                            oFilosofos[4].setDisparo(iDisparo5a,iDisparo5b);
                            break;
                            
                    }
                    oFilosofos[i].start();
                    //System.out.println("El " + oFilosofos[i].getsNombre() +" se creo!");
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
