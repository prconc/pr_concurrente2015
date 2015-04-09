public class Main {
public static void main(String[] args){
Filosofo[] filosofos = new Filosofo[10];
Palillo[] palillos = new Palillo[10];

for(int i=0; i<10;i++)
{
	palillos[i] = new Palillo(i);
}
for(int i=0; i<10;i++)
{
	filosofos[i] = new Filosofo(i,palillos[i],palillos[(i+1)%10]);
}
for(int i=0; i<10;i++)
{
	Thread T = new Thread(filosofos[i]);
	T.start();
}
}
}
