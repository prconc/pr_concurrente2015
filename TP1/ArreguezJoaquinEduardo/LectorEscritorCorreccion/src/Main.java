public class Main {
	public static void main(String[] args) {
		
		listaConcurrente lista =new listaConcurrente();
		
		Escritor hegel=new Escritor("Hegel", lista);
		Escritor marx=new Escritor("Marx", lista);
		
		Thread hegelEscribe=new Thread(hegel);hegelEscribe.start();
		Thread marxEscribe=new Thread(marx);marxEscribe.start();
		
		for (int i=0;i<=10;i++){
			(	new Thread(	new Lector("lectorRandom", lista, lista.indices()-1)		)).start();
			}
	}
}
