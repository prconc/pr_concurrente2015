
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filosofo[] f= new Filosofo[5];
		Palillo[] p= new Palillo[5];
		
		for(int i=0; i<5;i++)//Inicializo palillos
		{
			p[i] = new Palillo(i);
		}
		
		for(int i=0; i<5; i++)//Inicializo filosofos
		{
			int nexti= ((i+1)%5);
			f[i] = new Filosofo(i,p[i],p[nexti]);
		}
		
		for(int i=0; i<5;i++)//Creo threads
		{
			Thread t= new Thread(f[i]);
			//La solucion propuesta es sentarlos en diferentes momentos
			//Siento primero a 0 y 2, a que coman juntos, y despues siento al resto
			//Los filosofos solamente agarraran los palillos si ven los palillos libres a ambos lados
			//Como puede verse en ejecucion, independientemente de la instancia siempre comen primero 0 y 2
			//Luego 3 y por ultimo 1 y 4
			if(i ==0 || i==2)
				t.start();
			else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.start();
			}
		}
	}

}
