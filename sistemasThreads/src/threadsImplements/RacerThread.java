package threadsImplements;

import java.lang.Thread;

public class RacerThread extends Thread {
	
	public int i;
	public int questao;
	
	public RacerThread(int i, int questao) {
		this.i = i;
		this.questao = questao;
	}

	public void run() {
		int contador = 100;
		
		if(questao == 1 || questao == 2) {
			while(true) {
				System.out.println("Racer " + i + " está imprimindo");
			}
		}
		
		if(questao == 3 || questao == 4) {
			while(true) {
				try {
					System.out.println("Racer " + i + " está imprimindo");
					RacerThread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		while(contador != 0) {
			try {
				System.out.println("Racer " + i + " está imprimindo");
				contador--;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
