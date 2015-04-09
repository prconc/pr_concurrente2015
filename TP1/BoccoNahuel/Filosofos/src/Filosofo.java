/* Federico Perez
 * Nahuel Bocco
 * 
 * Funcionamiento general: Todos los filosofos toman un tenedor de la derecha y comprueban si tienen disponible uno a la izquierda.
 * Al no tener ninguno esperan un tiempo aleatorio y luego comprueban denuevo. Si no tienen dejan el tenedor de la derecha y esperan.
 * Al ser estos tiempos aleatorios en algun momento todos van a tener tenedores disponibles y van a comer.
 * Esta forma de resolverlo es mas caotica pero no tan facil como la de dar turnos a los filosofos para que cada uno coma.
 */

import java.util.*;

public class Filosofo implements Runnable {
	
	Thread hiloFilosofo;
	int tenedorIzquierda,tenedorDerecha;			//indica si tienen tenedores en sus manos.
	Buffer tenedores;
	
	/*Al constructor del filosofo se le pasa el nombre, que tenedor tiene a su izquierda, a su derecha
	 * y el conjunto de los tenedores que se llama buffer.
	 */
	
	public Filosofo(String nombre, int tenedorIzquierda, int tenedorDerecha,Buffer t){
		
		tenedorIzquierda=this.tenedorIzquierda;
		tenedorDerecha=this.tenedorDerecha;
		tenedores=t;
		hiloFilosofo = new Thread(this,nombre);
		System.out.println("Un filosofo salvaje aparece ");
		System.out.println(hiloFilosofo.getName());
		hiloFilosofo.start();
	}
	
	
/*Para mas comodidad al leer los resultados se puede comentar los System.out() que se refieren al agarre de tenedores
 * y dejar solo los que indican que el filosofo esta comiendo.
 */
	
	
public void run()
{
	Random esperaAleatoria=new Random();
	while(true){
		
		if(tenedores.verTenedor(tenedorDerecha)==1)												//Si tiene tenedor en la mano derecha.
			{
				tenedores.sacar(tenedorDerecha);
				//System.out.println(hiloFilosofo.getName() + " agarro tenedor derecha.");
				if(tenedores.verTenedor(tenedorIzquierda)==1)									//Si tiene tenedor en la mano derecha y tambien
				{
					tenedores.sacar(tenedorIzquierda);											//en la mano izquierda.
					//System.out.println(hiloFilosofo.getName() + " agarro tenedor izquierda.");
					System.out.println(hiloFilosofo.getName() + " Come.");
					try{Thread.sleep(1000);}
					catch(InterruptedException ex){}
					tenedores.devolver(tenedorDerecha);
					//System.out.println(hiloFilosofo.getName() + " devuelve tenedor derecha.");
					tenedores.devolver(tenedorIzquierda);
					//System.out.println(hiloFilosofo.getName() + " devuelve tenedor izquierda.");
					try{Thread.sleep(500);}
					catch(InterruptedException ex){}
				}
				if(tenedores.verTenedor(tenedorIzquierda)==0){									//Si tiene tenedor en la mano derecha pero no en 	
					//System.out.println(hiloFilosofo.getName() + " espero tenedor izquierda.");	//izquierda.
					try{Thread.sleep(Math.abs(esperaAleatoria.nextInt())%100);}
					catch(InterruptedException ex){}
					if(tenedores.verTenedor(tenedorIzquierda)==1){
						System.out.println(hiloFilosofo.getName() + " Come.");
						try{Thread.sleep(1000);}
						catch(InterruptedException ex){}
						tenedores.devolver(tenedorDerecha);
						//System.out.println(hiloFilosofo.getName() + " devuelve tenedor derecha.");
						tenedores.devolver(tenedorIzquierda);
						//System.out.println(hiloFilosofo.getName() + " devuelve tenedor izquierda.");
						try{Thread.sleep(500);}
						catch(InterruptedException ex){}
					}
					else{tenedores.devolver(tenedorDerecha);
					//System.out.println(hiloFilosofo.getName() + " devuelve tenedor derecha al no encontrar otro.");
					}	
					}
				}
		
		if(tenedores.verTenedor(tenedorDerecha)==0)									//Estos son los casos contrarios.
		{
			if(tenedores.verTenedor(tenedorIzquierda)==1){
				tenedores.sacar(tenedorIzquierda);
				//System.out.println(hiloFilosofo.getName() + " agarro tenedor izquierda.");
				//System.out.println(hiloFilosofo.getName() + " espero tenedor derecha.");
				
				try{Thread.sleep(Math.abs(esperaAleatoria.nextInt())%100);}
				catch(InterruptedException ex){}
				if(tenedores.verTenedor(tenedorDerecha)==1){
					tenedores.sacar(tenedorDerecha);
					//System.out.println(hiloFilosofo.getName() + " agarro tenedor derecha.");
					System.out.println(hiloFilosofo.getName() + " Come.");
					try{Thread.sleep(1000);}
					catch(InterruptedException ex){}
					tenedores.devolver(tenedorDerecha);
					//System.out.println(hiloFilosofo.getName() + " devuelve tenedor derecha.");
					tenedores.devolver(tenedorIzquierda);
					//System.out.println(hiloFilosofo.getName() + " devuelve tenedor izquierda.");
					try{Thread.sleep(500);}
					catch(InterruptedException ex){}
				}
				else{tenedores.devolver(tenedorIzquierda);
				//System.out.println(hiloFilosofo.getName() + " devuelve tenedor izquierda al no encontrar otro.");
				}
				}
			}
		}
	}
}

