import java.util.Random;

public class Vetor {

    private int[] vetor;

    public Vetor(int n) {
        vetor = new int[n];
    }

    public void povoarVetor() {

        /*Random gerador = new Random();

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = gerador.nextInt(26);
        }*/

        vetor = new int[] {10,3,5,1,2,8,9,7,4,6};
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void imprimir() {

        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println("");
    }
}
