/*Los parametros que se le pasen a los filosofos son importantes porque le indican que tenedores tienen disponibles para 
 * agarrar. Cada filosofo comparte sus tenedores con dos filosofos mas. Se ve reflejado en los indices de sus parametros.
 */

public class Main {

	public static void main(String[] args) 
	{
		Buffer tenedores = new Buffer();
		Filosofo filosofo1=new Filosofo("Pitagoras",0,1,tenedores);			
		Filosofo filosofo2=new Filosofo("Aristoteles",1,2,tenedores);
		Filosofo filosofo3=new Filosofo("Platon",2,3,tenedores);
		Filosofo filosofo4=new Filosofo("Euclides",3,4,tenedores);
		Filosofo filosofo5=new Filosofo("Robertito",4,0,tenedores);
	}

}
