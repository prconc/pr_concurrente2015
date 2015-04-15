
public class variable {
	
	private int var;
	private int max;
	private int min;
	
	public variable(int a, int b, int c){
		var=c;
		max=a;
		min=b;
		}
	public void incre() throws InterruptedException {
	
		var = var + 1;
	}
	public  void decre() throws InterruptedException {

		var = var -1;

		
	}
	
	public int getval() {
		return var;
		
	}

	public int getmax() {
		return max;
		
	}
	public int getmin() {
		return min;
		
	}


}
