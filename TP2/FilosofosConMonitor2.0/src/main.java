
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] M = {1,0,1,0,1,0,1,0,1,0,1,1,1,1,1};//marcado inicial
		
		//matriz de incidencia
		int[][]I = {{-1 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } ,//0
					{1 , -1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } ,//1
					{0 , 0 , -1 , 1 , 0 , 0 , 0 , 0 , 0 , 0 } ,//2
					{0 , 0 , 1 , -1 , 0 , 0 , 0 , 0 , 0 , 0 } ,//3
					{0 , 0 , 0 , 0 , 1 , -1 , 0 , 0 , 0 , 0 } ,//4
					{0 , 0 , 0 , 0 , -1 , 1 , 0 , 0 , 0 , 0 } ,//5
					{0 , 0 , 0 , 0 , 0 , 0 , 1 , -1 , 0 , 0 } ,//6
					{0 , 0 , 0 , 0 , 0 , 0 , -1 , 1 , 0 , 0 } ,//7
					{0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , -1 } ,//8
					{0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , -1 , 1 } ,//9
					{0 , 0 , 0 , 0 , 0 , 0 , 1 , -1 , 1 , -1 } ,//10
					{0 , 0 , 0 , 0 , 1 , -1 , 0 , 0 , 1 , -1 } ,//11
					{-1 , 1 , 0 , 0 , 1 , -1 , 0 , 0 , 0 , 0 } ,//12
					{-1 , 1 , -1 , 1 , 0 , 0 , 0 , 0 , 0 , 0 } ,//13
					{0 , 0 , -1 , 1 , 0 , 0 , 1 , -1 , 0 , 0 } ,//14
				   };
		Monitor Monitor = new Monitor( M, I);
		
		for(int i=0; i<I.length;i++)//muestra la matriz de incidencia 
		{
			for(int j=0;j<I[i].length;j++)
			{
				System.out.print(I[i][j]+", ");
			}
			System.out.println("\n");
		}
		Filosofos F1 = new Filosofos(9,8,Monitor,1);
		Filosofos F2 = new Filosofos(5,4,Monitor,2);
		Filosofos F3 = new Filosofos(0,1,Monitor,3);
		Filosofos F4 = new Filosofos(2,3,Monitor,4);
		Filosofos F5 = new Filosofos(7,6,Monitor,5);
		
		F1.start();
		F2.start();
		F3.start();
		F4.start();
		F5.start();
	}

}

