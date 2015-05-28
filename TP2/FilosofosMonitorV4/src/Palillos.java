
public class Palillos {
	private int[] pal ;
	public Palillos(){
		pal=new int[5];
		pal[0]=1;
		pal[1]=1;
		pal[2]=1;
		pal[3]=1;
		pal[4]=1;
				
	}
	
	public int get_capacidad(){
		return 5;
	}
	
	public int get_pal(int i){
	    return pal[i];
	}
	public void pull_pal(int i){
		pal[i] = 0;
	}
	public void up_pal(int i){
		pal[i]=1;
	}
	
}
