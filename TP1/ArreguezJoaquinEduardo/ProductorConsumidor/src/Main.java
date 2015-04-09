
public class Main {
	
	static buffer b=new buffer();

	public static void main(String[] args) {
		
		for (int i=0;i<4;i++){
			productor p= new productor(b);
			consumidor c= new consumidor(b);
			
			Thread prodTrd= new Thread(p);
			Thread consTrd=new Thread(c);
			
			prodTrd.start();
			consTrd.start();
			}
		}
	}
