package entidades;

public class Deposito {
	
	private int items = 0;
	private final int capacidade = 100;
	
	public int getNumItens(){
		return items;
	}
	
	public synchronized boolean retirar() {

		//implementacao abordagem optimista
		/*while(getNumItens() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return false;
			}
		}
		*/
		
		//implementacao abordagem intermediaria
        /*long inicio = System.currentTimeMillis();
        while (items == 0) {
            try {
                wait(200);
                if (System.currentTimeMillis() - inicio >= 200) {
                     System.out.println(Thread.currentThread().getName() + " desistiu de esperar (depósito vazio).");
                    return false;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }*/
        
		items=getNumItens() - 1;
		//System.out.println(Thread.currentThread().getName() + " retirou 1 caixa. Total = " + items);
		//notifyAll();
		return true;
	}
	
	public synchronized boolean colocar() {
		
		/*while(getNumItens() == capacidade) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return false;
			}
		}
		*/
        
		items=getNumItens() +1;
		//System.out.println(Thread.currentThread().getName() + " adicionou 1 caixa. Total = " + items);
		//notifyAll();
		return true;
	}
	
	public static void main(String[] args) {
		
	Deposito dep = new Deposito();
	Produtor p = new Produtor(dep, 50);
	Consumidor c1 = new Consumidor(dep, 150);
	Consumidor c2 = new Consumidor(dep, 100);
	Consumidor c3 = new Consumidor(dep, 150);
	Consumidor c4 = new Consumidor(dep, 100);
	Consumidor c5 = new Consumidor(dep, 150);
	
	//Startar o produtor
	p.start();
	
	//Startar os consumidores.
	c1.start(); 
	c2.start(); 
	c3.start();
	c4.start(); 
	c5.start();
	
	System.out.println("Execucao do main da classe Deposito terminada");
	}
	
}
