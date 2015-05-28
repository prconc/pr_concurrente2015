public class Mesa {
	int tenedores[] = {2,2,2,2,2};
	CV2 okParaComer[] = new CV2[5];
	public Mesa() {
		for(int i=0;i<5;i++) {
			okParaComer[i]=new CV2("okParaComer"+i);
		}
	}	
	public synchronized void tomar(int i) {
		if(tenedores [i] != 2) {
			System.out.println("Filosofo "+i+" esperando");
			okParaComer[i].DELAY(this);
		}
		tenedores[(i+1) % 5] = tenedores[(i+1) % 5] - 1;
		tenedores[(i+4) % 5] = tenedores[(i+4) % 5] - 1;
	}	
	public synchronized void poner(int i) {
		System.out.println("Filosofo "+i+" termina");
		tenedores[(i+1) % 5] = tenedores[(i+1) % 5] + 1;
		tenedores[(i+4) % 5] = tenedores[(i+4) % 5] + 1;
		if (tenedores[(i+1) % 5] == 2)
			okParaComer[(i+1) % 5].RESUME(this);
		if (tenedores[(i+4) % 5] == 2)
			okParaComer[(i+4) % 5].RESUME(this);
	}
}

