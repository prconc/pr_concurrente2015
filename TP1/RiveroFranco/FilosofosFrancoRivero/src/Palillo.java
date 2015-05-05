public class Palillo
{
private boolean libre;
private int n;
public Palillo(int n)
{
	libre = true;
this.n = n;	
}
synchronized public void agarrar ()
{
while(!libre)
{
	try
	{
		wait();
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	libre = false;
}
}
synchronized public void soltar() 
{
libre = true;
notifyAll();
}
public int getNum()
{
	return n;
}
public boolean Libre()
{
	return libre;
}
}