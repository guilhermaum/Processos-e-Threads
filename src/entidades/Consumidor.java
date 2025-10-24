package entidades;

public class Consumidor extends Thread {

	Deposito dep = new Deposito();
	int tempo;
	
	public Consumidor(Deposito dep, int n) {
		this.dep = dep;
		this.tempo = n;
	}
	
	public void run() {
		
		for(int i = 0; i < 20; i++) {
			dep.retirar();
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Consumo interrompido");
			}	
		}
		
		System.out.println("Consumo encerrado");
	}
	
}
