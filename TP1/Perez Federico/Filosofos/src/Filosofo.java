import java.util.*;


public class Filosofo implements Runnable {
	
	Thread hiloFilosofo;
	int tenedorIzquierda,tenedorDerecha;
	Buffer tenedores;
	int tenerIzq, tenerDer;
	
	
	public Filosofo(String nombre, int tenedorIzquierda, int tenedorDerecha,Buffer t){
		
		tenedorIzquierda=this.tenedorIzquierda;
		tenedorDerecha=this.tenedorDerecha;
		tenedores=t;
		hiloFilosofo = new Thread(this,nombre);
		System.out.println("Un filosofo salvaje aparece ");
		System.out.println(hiloFilosofo.getName());
		hiloFilosofo.start();
	}
	
public void run()
{
	Random esperaAleatoria=new Random();
	while(true){
		
		if(tenedores.verTenedor(tenedorDerecha)==1)			
			{
				tenedores.sacar(tenedorDerecha);
				//System.out.println(hiloFilosofo.getName() + " agarro tenedor derecha.");
				if(tenedores.verTenedor(tenedorIzquierda)==1)
				{
					tenedores.sacar(tenedorIzquierda);
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
				if(tenedores.verTenedor(tenedorIzquierda)==0){
					//System.out.println(hiloFilosofo.getName() + " espero tenedor izquierda.");
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
		
		if(tenedores.verTenedor(tenedorDerecha)==0)			
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

