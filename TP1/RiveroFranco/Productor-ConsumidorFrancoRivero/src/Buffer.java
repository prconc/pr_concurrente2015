public class Buffer{
private int first;
private int max;
private int b[]; 

public Buffer(int i)
{
max = i;
b = new int [max];
first = 0;
}
synchronized public void add(int n)
{
	while(first == max-1)
		try{
			wait();
		} catch(InterruptedException e) {;}
		b[first] = n;
		first++;
		notifyAll();
 }
synchronized public int extract()
{
	while(first==0)
	{
		try{
			wait();
		} catch(InterruptedException e) {;}
		notifyAll();
	}
	first--;
	return b[first];
	
}
}