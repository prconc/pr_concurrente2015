public class Recurso {
int NumLectores=0;
boolean hayEscritor=false;
int variable;
public Recurso(int a){
	variable=a;
}
public int leer(){
	synchronized(this){
		while(hayEscritor)
			try{wait();}
		catch(Exception e){}
		NumLectores++;
		}
	synchronized(this){
		NumLectores--;
		if(NumLectores==0)notifyAll();
	}
	return variable;
}
synchronized public void escribir(int var){
	synchronized(this){
		while(hayEscritor||(NumLectores>0))
			try{
				wait();
			}catch(Exception e){}
		hayEscritor=true;
	}
	synchronized(this){
		hayEscritor=false;
		notifyAll();
	}
	variable=var;
}
}