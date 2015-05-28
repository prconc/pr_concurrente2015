package clases;

public class Matriz 
{
	int [][]dato;

	public Matriz(int fil,int col)
        {
		dato=new int[fil][col];
	}
	
	public Matriz(int[][]dato)
        {
		this.dato=dato;
	}

	public Matriz(int size)
        {
		// TODO Auto-generated constructor stub
		dato=new int[size][size];
		
	}

	public int[][] getDato() 
        {
		return dato;
	}
	public int getVal(int fil,int col)
        {

		return dato[fil][col];

	}

	public void setMatrix(int[][] dato) 
        {
		this.dato = dato;
	}

	public void setDato(int fil,int col,int dato) 
        {

		this.dato[fil][col]=dato;
	}

	public int getFil() 
        {
		return dato.length;

	}

	public int getCol() 
        {
		return dato[0].length;
	}
	public Matriz getCol(int col) 
        {

		Matriz columna=new Matriz(this.getFil(),1);

		for(int i=0;i<this.getFil();i++)
		{
			columna.setDato(i,0, this.dato[i][col]);


		}
		return columna;
	}

	public void Clear(){

		for (int i=0;i<this.getFil();i++){
			for (int j=0;j<this.getCol();j++){
				this.setDato(i, j, 0);
			}
		}

	}
	public boolean isPos(){

		for (int i=0;i<this.getFil();i++){
			for (int j=0;j<this.getCol();j++){
				if(this.dato[i][j]<0)return false;
			}
		}

		return true;
	}
	// create and return the transpose of the invoking matrix
	public Matriz transpose() {
		Matriz A = new Matriz(this.getCol(), this.getFil());
		for (int i = 0; i < this.getFil(); i++)
			for (int j = 0; j < this.getCol(); j++)
				A.setDato(j, i,this.getDato()[i][j]);
		return A;
	}
	public String toString(){
		String texto="\n";
		for(int i=0; i<this.getFil(); i++){
			for(int j=0; j<this.getCol(); j++){
				texto+="\t "+this.dato[i][j];
			}
			texto+="\n";
		}
		texto+="\n";
		return texto;
	}
	// return C = A + B
	public Matriz plus(Matriz B) {
		Matriz A = this;
		if (B.getFil() != A.getFil() || B.getCol() != A.getCol()) throw new RuntimeException("Illegal matrix dimensions.");
		Matriz C = new Matriz(getFil(), getCol());
		for (int i = 0; i < getFil(); i++)
			for (int j = 0; j < getCol(); j++)
				C.setDato(i,j,A.getDato()[i][j] + B.getDato()[i][j]);
		return C;
	}

	// return C = A - B
	public Matriz minus(Matriz B) {
		Matriz A = this;
		if (B.getFil() != A.getFil() || B.getCol() != A.getCol()) throw new RuntimeException("Illegal matrix dimensions.");
		Matriz C = new Matriz(getFil(), getCol());
		for (int i = 0; i < getFil(); i++)
			for (int j = 0; j < getCol(); j++)
				C.setDato(i,j,A.getDato()[i][j] - B.getDato()[i][j]);
		return C;
	}
	// return C = A * B
	public Matriz mult(Matriz B) {
		Matriz A = this;
		if (A.getCol() != B.getFil()) throw new RuntimeException("Illegal matrix dimensions.");
		Matriz C = new Matriz(A.getFil(), B.getCol());
		for (int i = 0; i < C.getFil(); i++)
			for (int j = 0; j < C.getCol(); j++)
				for (int k = 0; k < A.getCol(); k++)
					C.setDato(i,j,C.getDato()[i][j]+(A.getDato()[i][k] * B.getDato()[k][j]));
		return C;
	}

	public void setIdentity() {
		for (int i = 0; i < dato.length; i++) {
			dato[i][i]=1;
		}
	}
}
