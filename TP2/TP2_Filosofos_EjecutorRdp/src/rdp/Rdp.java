package rdp;

/* Modelo de una Red de Petri.
 * 	Posee una matriz de marcado, y una matriz de incidencia [clase Matrix]
 */

public class Rdp {
	
	private Matrix marcado;
	private Matrix incidencia;
	
	/*El constructor recibe una matriz de incidencia y una de marcado inicial */
	
	public Rdp(Matrix incidencia , Matrix marcado_inicial){
		marcado=marcado_inicial;
		this.incidencia=incidencia;
	}
	
	/*Este no recibe nada y se le puede ingresar mas tarde por medio de metodos*/
	
	public Rdp(){}
	
/*Recibe una matriz y la asigna al marcado de la RdP*/

public void ingresar_marcado(Matrix marcado){
	this.marcado=marcado;
}

/*Recibe una matriz y la asigna a la incidencia de la RdP*/

public void ingresar_incidencia(Matrix incidencia){
	this.incidencia=incidencia;
}

/*Metodo que prueba si un vector de disparo es posible de ejecutar en esta RdP.
 * Recibe como parametros un objeto Matrix conteniendo el vector de disparo a analizar.
 * Devuelve un bool.
 */

public boolean probar_disparo(Matrix vector_disparo){
	
	Matrix nuevo_marcado=new Matrix(marcado.getFil(),marcado.getCol());        //Creo una nueva matriz con el mismo tama�o que el marcado.
	nuevo_marcado=marcado.plus(incidencia.mult(vector_disparo));				//Asigna a ese nuevo marcado el potencial marcado con el vector ya disparado.
	
	for(int i=0;i<nuevo_marcado.getFil();i++) 									//Veo si algun elemento de la matriz es negativo.
		if(nuevo_marcado.getVal(i, 0)<0) 
			return false;														//Si encuentra alguno devuelvo false.
	
	return true;																//Sino true.
		}

/*Metodo que efectua el disparo. Modifica el marcado de la RdP.
 * Recibe el vector de disparo.
 * No retorna nada.
 */

public void disparar(Matrix vector_disparo){
	if(probar_disparo(vector_disparo)){											//Prueba si el vector es disparable.
		marcado=marcado.plus(incidencia.mult(vector_disparo)); 					//Si lo es modifica el marcado segun el vector de disparo y la matriz de incidencia.
		}
	else{
		System.out.println("No se puede disparar. Dispare otro vector."); 
		}
		
	}

/*Metodo que imprime la matriz de incidencia*/

public void imprimir_incidencia(){
	
	System.out.println("Matriz de incidencia: ");
	
	
	for(int i=0;i<incidencia.getFil();i++){
		
		System.out.println("");
		
		for(int j=0;j<incidencia.getCol();j++){
		
		System.out.print(incidencia.getVal(i,j)+" ");
		}
		
	}
	System.out.println("");
	System.out.println("");
}

/*Metodo que imprime el marcado*/

public void imprimir_marcado(){
	
	System.out.println("Matriz de marcado: ");
	
	
	for(int i=0;i<marcado.getFil();i++){
		
		System.out.println("");
		
		for(int j=0;j<marcado.getCol();j++){
		
		System.out.print(marcado.getVal(i,j)+" ");
		}
		
	}
	System.out.println("");
	System.out.println("");
}
}


