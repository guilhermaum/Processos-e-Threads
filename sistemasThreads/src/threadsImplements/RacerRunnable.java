package threadsImplements;

public class RacerRunnable implements Runnable {

    private int i;
    private int questao;

    public RacerRunnable(int i, int questao) {
        this.i = i;
        this.questao = questao;
    }

    @Override
    public void run() {
        int contador = 100;

        if (questao == 1 || questao == 2) {
            while (true) {
                System.out.println("Racer " + i + " está imprimindo");
            }
        }

        if (questao == 3 || questao == 4) {
            while (true) {
                try {
                    System.out.println("Racer " + i + " está imprimindo");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        while (contador != 0) {
            try {
                System.out.println("Racer " + i + " está imprimindo");
                contador--;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
