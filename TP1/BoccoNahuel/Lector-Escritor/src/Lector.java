public class Lector implements Runnable {
int miID;
Recurso recurso;
int variable;
public Lector (Recurso rec,int ID){
miID=ID;
recurso=rec;
}
public void run(){
//int i=0;
//while(i<5){
System.out.println("Lector "+miID+" quiere leer");
System.out.println("La variable leida "+recurso.leer());
System.out.println("Lector "+miID+" ha terminado de leer");
//i++;
//}
}}