public class Consumidor implements Runnable {
int elem;
Buffer buffer;
Consumidor (Buffer b){
	buffer=b;
}
public void run(){
	try{
		elem=buffer.extraer();
	}catch(Exception e){}
	System.out.println("he consumido un elemento");
	return;
}
}
