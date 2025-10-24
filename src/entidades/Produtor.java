package entidades;

public class Produtor extends Thread {

	Deposito dep = new Deposito();
	int tempo;
	
	public Produtor(Deposito dep, int n) {
		this.dep = dep;
		this.tempo = n;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			dep.colocar();
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Produção interrompida");
			}
		}
		
		System.out.println("Produção encerrada");
	}
	
}
