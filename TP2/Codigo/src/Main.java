import petri.*;
import filosofo.Filosofo;
import monitor.Monitor;

public class Main {

	public static void main(String[] args) 
	{
		
		/*Creo una matriz la cual contiene el modelado de la red de petri en forma de matriz de incidencia.*/
		
		int [][]incidencia={{-1,1,0,0,0,0,0,0,0,0},
							{1,-1,0,0,0,0,0,0,0,0},
							{-1,1,0,0,0,0,1,-1,0,0},
							{-1,1,1,-1,0,0,0,0,0,0},
							{0,0,1,-1,0,0,0,0,0,0},
							{0,0,-1,1,0,0,0,0,0,0},
							{0,0,1,-1,1,-1,0,0,0,0},
							{0,0,0,0,1,-1,0,0,0,0},
							{0,0,0,0,-1,1,0,0,0,0},
							{0,0,0,0,1,-1,0,0,1,-1},
							{0,0,0,0,0,0,1,-1,0,0},
							{0,0,0,0,0,0,-1,1,0,0},
							{0,0,0,0,0,0,1,-1,1,-1},
							{0,0,0,0,0,0,0,0,1,-1},
							{0,0,0,0,0,0,0,0,-1,1}};
		
		
		
		int [][]marcado_inicial={{1},{0},{1},{1},{1},{0},{1},{1},{0},{1},{1},{0},{1},{1},{0}};			//Vector de marcado de la red
		
		int [][]disparo1_Aristoteles={{1},{0},{0},{0},{0},{0},{0},{0},{0},{0}};							//Diferentes vectores de disparo para cada filosofo.
		int [][]disparo2_Aristoteles={{0},{1},{0},{0},{0},{0},{0},{0},{0},{0}};	
		
		int [][]disparo1_Platon={{0},{0},{0},{1},{0},{0},{0},{0},{0},{0}};
		int [][]disparo2_Platon={{0},{0},{1},{0},{0},{0},{0},{0},{0},{0}};
		
		int [][]disparo1_Socrates={{0},{0},{0},{0},{0},{1},{0},{0},{0},{0}};
		int [][]disparo2_Socrates={{0},{0},{0},{0},{1},{0},{0},{0},{0},{0}};
		
		int [][]disparo1_Pitagoras={{0},{0},{0},{0},{0},{0},{0},{0},{0},{1}};
		int [][]disparo2_Pitagoras={{0},{0},{0},{0},{0},{0},{0},{0},{1},{0}};
		
		int [][]disparo1_Euclides={{0},{0},{0},{0},{0},{0},{0},{1},{0},{0}};
		int [][]disparo2_Euclides={{0},{0},{0},{0},{0},{0},{1},{0},{0},{0}};
		
		Matrix vector1_Aristoteles=new Matrix(disparo1_Aristoteles);					//Hago objetos Matrix contenientes de esos vectores de disparo.
		Matrix vector2_Aristoteles=new Matrix(disparo2_Aristoteles);
		
		Matrix vector1_Platon=new Matrix(disparo1_Platon);
		Matrix vector2_Platon=new Matrix(disparo2_Platon);
		
		Matrix vector1_Socrates=new Matrix(disparo1_Socrates);
		Matrix vector2_Socrates=new Matrix(disparo2_Socrates);
		
		Matrix vector1_Pitagoras=new Matrix(disparo1_Pitagoras);
		Matrix vector2_Pitagoras=new Matrix(disparo2_Pitagoras);
		
		Matrix vector1_Euclides=new Matrix(disparo1_Euclides);
		Matrix vector2_Euclides=new Matrix(disparo2_Euclides);
		
		Matrix matriz_incidencia=new Matrix(incidencia);
		Matrix matriz_marcado_inicial=new Matrix(marcado_inicial);
		
		Rdp red=new Rdp(matriz_incidencia,matriz_marcado_inicial);				//Creo la RdP con la incidencia y el marcado.
		
		Monitor monitor=new Monitor(red);			//Creo el monitor con la red como condicion.
		
		
		red.imprimir_marcado();
		red.imprimir_incidencia(); 
		
		
		Filosofo Aristoteles=new Filosofo("Aristoteles",vector1_Aristoteles,vector2_Aristoteles,monitor);		//Creo los filosofos.
		Filosofo Platon=new Filosofo("Platon",vector1_Platon,vector2_Platon,monitor);
		Filosofo Socrates=new Filosofo("Socrates",vector1_Socrates,vector2_Socrates,monitor);
		Filosofo Pitagoras=new Filosofo("Pitagoras",vector1_Pitagoras,vector2_Pitagoras,monitor);
		Filosofo Euclides=new Filosofo("Euclides",vector1_Euclides,vector2_Euclides,monitor);
		
		/*FIN*/
		
		}
	}


