package programa;

import java.util.Scanner;

import sistemasDistribuidos.RacerThread;
import sistemasDistribuidos.RacerRunnable;

public class Race {
	
	public static void main(String args[]) throws InterruptedException {
		
		int questao;
		int implement;
		Thread[] racers = new Thread[10];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Threads ou Runnable?");
		System.out.println("1 - Threads\n2 - Runnable");
		implement = sc.nextInt();
		System.out.println("Escolha o número da alternativa que deseja ver a resposta");
		System.out.println("1 - b\n2 - c\n3 - d\n4 - e\n5 - f");
		questao = sc.nextInt();
		
		if(implement == 1) {
			if(questao == 1) {
				(new RacerThread(0, questao)).start();
			}
			
			if(questao == 2 || questao == 3) {
				for(int i = 1; i <= 10; i++) {
					racers[i - 1] = new RacerThread(i, questao);
					racers[i - 1].start();
				}
			}
			
			if(questao == 4) {
				for(int i = 1; i <= 10; i++) {
					racers[i - 1] = new RacerThread(i, questao);
					if(i % 2 == 0) {
						racers[i - 1].setPriority(10);
					} else {
						racers[i - 1].setPriority(1);
					}
					racers[i - 1].start();
				}
			}
			
			if (questao == 5) {
				for(int i = 1; i <= 10; i++) {
					if(i % 2 != 0) {
						racers[i - 1] = new RacerThread(i, questao);
						racers[i - 1].start();
					}		
				}
				
				for(int i = 1; i <= 10; i++) {
					if(i % 2 != 0) {
						racers[i - 1].join();
					}
				}
				
				for(int i = 1; i <= 10; i++) {
					if(i % 2 == 0) {
						new RacerThread(i, questao).start();
					}
				}
			}
		}
		
		else if (implement == 2) {
            if (questao == 1) {
                new Thread(new RacerRunnable(0, questao)).start();
            }

            if (questao == 2 || questao == 3) {
                for (int i = 1; i <= 10; i++) {
                    racers[i - 1] = new Thread(new RacerRunnable(i, questao));
                    racers[i - 1].start();
                }
            }

            if (questao == 4) {
                for (int i = 1; i <= 10; i++) {
                    racers[i - 1] = new Thread(new RacerRunnable(i, questao));
                    if (i % 2 == 0) {
                        racers[i - 1].setPriority(10);
                    } else {
                        racers[i - 1].setPriority(1);
                    }
                    racers[i - 1].start();
                }
            }

            if (questao == 5) {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0) {
                        racers[i - 1] = new Thread(new RacerRunnable(i, questao));
                        racers[i - 1].start();
                    }
                }

                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0 && racers[i - 1] != null) {
                        racers[i - 1].join();
                    }
                }

                for (int i = 1; i <= 10; i++) {
                    if (i % 2 == 0) {
                        new Thread(new RacerRunnable(i, questao)).start();
                    }
                }
            }
        }
		
		sc.close();
	}
	
}
