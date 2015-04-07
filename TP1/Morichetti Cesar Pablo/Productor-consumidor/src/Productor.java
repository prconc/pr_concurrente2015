public class Productor implements Runnable{
	Buffer buffer;
	int elem;
	Productor (Buffer b){
		buffer=b;
	}
public void run(){
try{	
	buffer.insertar(elem);
	}catch(Exception e){}
System.out.println("he puesto un elemento");
return;
}
}