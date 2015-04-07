public class Escritor implements Runnable {
int miID;
Recurso recurso;
int variable;
public Escritor(Recurso rec, int Id,int var){
	miID=Id;
	recurso=rec;
	variable=var;
}
public void run (){
    //int i=0;
	//while(i<5){
		System.out.println("Escritor "+miID+" quiere escribir");
		System.out.println("La variable que se va a escribir: "+variable);
		recurso.escribir(variable);
		System.out.println("Escritor "+miID+" ha terminado de escribir");
		//i++;
		//}
}}