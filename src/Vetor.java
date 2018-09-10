import java.util.Random;

public class Vetor {

    private int[] vetor;

    public Vetor(int n) {
        vetor = new int[n];
    }

    //Método para povoar vetor com valores aleatórios------------------------------------------------------------------------
    public void povoarVetorAleatorio() {

        Random gerador = new Random();

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = gerador.nextInt(1000);
        }

        //vetor = new int[] {10,3,5,1,2,8,9,7,4,6};
    }
    //Fim------------------------------------------------------------------------

    //Povoar Vetor com valores parcialmente em ordem crescente------------------------------------------------------------------------
    public void povoarVetorCresc() {

        Random gerador = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i + 1;
        }

        for (int j = 0; j < vetor.length; j++) {

            if (j < vetor.length) {
                vetor[j] = gerador.nextInt(300);
                j+=2;
            }
        }
    }
    //Fim------------------------------------------------------------------------

    //Povoar Vetor com valores parcialmente em ordem decrescente------------------------------------------------------------------------
    public void povoarVetorDecre() {

        Random gerador = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = vetor.length - i;
        }

        for (int j = 0; j < vetor.length; j++) {

            if (j < vetor.length) {
                vetor[j] = gerador.nextInt(300);
                j+=2;
            }
        }
    }
    //Fim------------------------------------------------------------------------

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
