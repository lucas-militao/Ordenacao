public class Ordenacao {

    private Vetor vetor;

    public Ordenacao(Vetor vetor) {
        this.vetor = vetor;
    }

    public void BubbleSort() {

        for (int i = 0; i < vetor.getVetor().length - 1; i++) {

            int ref = vetor.getVetor()[0];

            for (int j = 0; j < vetor.getVetor().length - 1; j++) {

                if(ref > vetor.getVetor()[j + 1]) {
                    vetor.getVetor()[j] = vetor.getVetor()[j + 1];
                    vetor.getVetor()[j + 1] = ref;
                } else {
                    ref = vetor.getVetor()[j + 1];
                }
            }
        }
    }

    public void InsertionSort() {
        if (vetor.getVetor().length > 1) {
            for (int i = 0; i < vetor.getVetor().length - 1; i++) {

                int ref = vetor.getVetor()[i];

                if (ref > vetor.getVetor()[i + 1]) {
                    vetor.getVetor()[i] = vetor.getVetor()[i + 1];
                    vetor.getVetor()[i + 1] = ref;
                    ref = vetor.getVetor()[i];

                    for (int j = i; j > 0; j--) {
                        if (ref < vetor.getVetor()[j - 1]) {
                            vetor.getVetor()[j] = vetor.getVetor()[j-1];
                            vetor.getVetor()[j - 1] = ref;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void SelectionSort() {

        int ref = 0;

        for (int i = 0; i < vetor.getVetor().length; i++) {

            int menor = vetor.getVetor()[i];

            for (int j = i; j < vetor.getVetor().length; j++) {
                if (menor > vetor.getVetor()[j]) {
                    ref = menor;
                    menor = vetor.getVetor()[j];
                    vetor.getVetor()[j] = ref;
                }
            }

            vetor.getVetor()[i] = menor;
        }
    }

    public void imprimir() {

        for (int i = 0; i < vetor.getVetor().length; i++) {
            System.out.print(vetor.getVetor()[i] + " ");
        }
        System.out.println("");
    }
}
