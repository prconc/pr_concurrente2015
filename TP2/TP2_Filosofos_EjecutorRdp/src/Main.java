import rdp.*;
import filosofo.Filosofo;
import monitor.Monitor;

public class Main {

	public static void main(String[] args) 
	{
		/*Matriz de incidencia de la red de petri*/
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
		
		/* Marcado inicial de la red*/
		int [][]marcado_inicial={{1},{0},{1},{1},{1},{0},{1},{1},{0},{1},{1},{0},{1},{1},{0}};
		
		/*Creo Matrix del marcado inicial y la matriz de incidencia*/
		Matrix matriz_incidencia=new Matrix(incidencia);
		Matrix matriz_marcado_inicial=new Matrix(marcado_inicial);
		
		/*Creo vectores de disparo para cada filosofo
		 * y los asigno a una matrix
		 * (creo matrix con los mismos)*/
		int [][]disparo1_Descartes={{1},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
		int [][]disparo2_Descartes={{0},{1},{0},{0},{0},{0},{0},{0},{0},{0}};
		Matrix vector1_Descartes=new Matrix(disparo1_Descartes);
		Matrix vector2_Descartes=new Matrix(disparo2_Descartes);
		
		int [][]disparo1_Hegel={{0},{0},{0},{1},{0},{0},{0},{0},{0},{0}};
		int [][]disparo2_Hegel={{0},{0},{1},{0},{0},{0},{0},{0},{0},{0}};
		Matrix vector1_Hegel=new Matrix(disparo1_Hegel);
		Matrix vector2_Hegel=new Matrix(disparo2_Hegel);
		
		int [][]disparo1_Kant={{0},{0},{0},{0},{0},{1},{0},{0},{0},{0}};
		int [][]disparo2_Kant={{0},{0},{0},{0},{1},{0},{0},{0},{0},{0}};
		Matrix vector1_Kant=new Matrix(disparo1_Kant);
		Matrix vector2_Kant=new Matrix(disparo2_Kant);
		
		int [][]disparo1_Leibniz={{0},{0},{0},{0},{0},{0},{0},{0},{0},{1}};
		int [][]disparo2_Leibniz={{0},{0},{0},{0},{0},{0},{0},{0},{1},{0}};
		Matrix vector1_Leibniz=new Matrix(disparo1_Leibniz);
		Matrix vector2_Leibniz=new Matrix(disparo2_Leibniz);
		
		int [][]disparo1_Marx={{0},{0},{0},{0},{0},{0},{0},{1},{0},{0}};
		int [][]disparo2_Marx={{0},{0},{0},{0},{0},{0},{1},{0},{0},{0}};
		Matrix vector1_Marx=new Matrix(disparo1_Marx);
		Matrix vector2_Marx=new Matrix(disparo2_Marx);
		
		
		/*Creo la RdP con las Matrix de incidencia y marcado inicial, y un monitor para esa Rdp*/
		Rdp red=new Rdp(matriz_incidencia,matriz_marcado_inicial);
		
		Monitor monitor=new Monitor(red);
		
		//Creo los filosofos.
		Filosofo Descartes=new Filosofo("Descartes",vector1_Descartes,vector2_Descartes,monitor);
		Filosofo Hegel=new Filosofo("Hegel",vector1_Hegel,vector2_Hegel,monitor);
		Filosofo Kant=new Filosofo("Kant",vector1_Kant,vector2_Kant,monitor);
		Filosofo Leibniz=new Filosofo("Leibniz",vector1_Leibniz,vector2_Leibniz,monitor);
		Filosofo Marx=new Filosofo("Marx",vector1_Marx,vector2_Marx,monitor);
		
		}
	}


