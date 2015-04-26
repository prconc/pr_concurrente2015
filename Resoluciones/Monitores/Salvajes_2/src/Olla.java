
public class Olla {
	private int capacidad;	//Capacidad de Olla
	private int misioneros;	// Numero de misioneros dentro de la olla
	int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getMisioneros() {
		return misioneros;
	}

	public void setMisioneros(int misioneros) {
		this.misioneros = misioneros;
	}

	public Olla(int misioneros,int capacidad) {
		super();
		this.capacidad = capacidad;
		this.misioneros = misioneros;
	}
	
	
}


