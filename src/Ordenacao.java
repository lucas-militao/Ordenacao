public class Ordenacao {

    private Vetor vetor;

    public Ordenacao(Vetor vetor) {
        this.vetor = vetor;
    }

    //Inicio de BubbleSort------------------------------------------------------------------------
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
    //Fim de BubbleSort------------------------------------------------------------------------

    //Inicio de InsertionSort------------------------------------------------------------------------
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
    //Fim de InsertionSort------------------------------------------------------------------------

    //Inicio de SelectionSort------------------------------------------------------------------------
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
    //Fim de SelectionSort------------------------------------------------------------------------

    //Inicio de MergeSort------------------------------------------------------------------------
    public void MergeSort() {
        MergeSort(vetor.getVetor(), 0, vetor.getVetor().length - 1);
    }

    private void MergeSort(int[] vetor, int inicio, int fim){
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            MergeSort(vetor, inicio, meio);
            MergeSort(vetor, meio + 1, fim);
            Intercalar(vetor, inicio, meio, fim);
        }
    }

    private void Intercalar(int[] vetor, int inicio, int meio, int fim) {

        int posLivre, Vet1, Vet2;
        int[] aux = new int[vetor.length];
        Vet1 = inicio;
        Vet2 = meio + 1;
        posLivre = inicio;

        while(Vet1 <= meio && Vet2 <= fim){

            if (vetor[Vet1] >= vetor[Vet2]) {
                aux[posLivre] = vetor[Vet2];
                Vet2++;
            } else {
                aux[posLivre] = vetor[Vet1];
                Vet1++;
            }

            posLivre++;
        }

        for (int i = Vet1; i <= meio; i++) {
            aux[posLivre] = vetor[i];
            posLivre++;
        }

        for (int i = Vet2; i <= fim; i++) {
            aux[posLivre] = vetor[i];
            posLivre++;
        }

        for (int i = inicio; i <= fim; i++) {
            vetor[i] = aux[i];
        }
    }
    //Fim de MergeSort------------------------------------------------------------------------

    //Inicio de QuickSort------------------------------------------------------------------------
    public void QuickSort() {
        QuickSort(vetor.getVetor(), 0, vetor.getVetor().length - 1);
    }

    private void QuickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            QuickSort(arr, low, j);

        if (high > i)
            QuickSort(arr, i, high);
    }
    //Fim de QuickSort------------------------------------------------------------------------

    //Inicio de HeapSort------------------------------------------------------------------------
//
    public void HeapSort() {

        TransformaHeap(vetor.getVetor().length - 1);

        Ordena(vetor.getVetor().length - 1);
    }

    private void TransformaHeap(int qtd) {
        int pai, aux;
        for (int i=qtd/2; i >= 0; i--) {
            HeapFica(i, qtd);
        }
    }

    private void HeapFica(int i, int qtd) {
        int Fdir, Fesq, maior, aux;
        maior = i;

        if (2*i+1 <= qtd) {

            Fdir = 2*i;
            Fesq = 2*i + 1;

            if(vetor.getVetor()[Fesq] >= vetor.getVetor()[Fdir] && vetor.getVetor()[Fesq] > vetor.getVetor()[i]) {
                maior = 2*i + 1;
            } else if(vetor.getVetor()[Fdir] > vetor.getVetor()[Fesq] && vetor.getVetor()[Fdir] > vetor.getVetor()[i]) {
                maior = 2*i;
            }
        } else if (2*i <= qtd) {
            Fdir = 2*i;

            if (vetor.getVetor()[Fdir] > vetor.getVetor()[i]) {
                maior = 2*i;
            }
        }

        if (maior != i) {
            aux = vetor.getVetor()[i];
            vetor.getVetor()[i] = vetor.getVetor()[maior];
            vetor.getVetor()[maior] = aux;
            HeapFica(maior, qtd);
        }
    }

    private void Ordena(int qtd){
        int aux, ultPos;

        for (int i = qtd; i >= 0; i--){
            aux = vetor.getVetor()[0];
            vetor.getVetor()[0] = vetor.getVetor()[i];
            vetor.getVetor()[i] = aux;
            ultPos = i-1;
            HeapFica(0, ultPos);
        }
    }


    //Fim de HeapSort------------------------------------------------------------------------

    //Inicio Busca Sequencial------------------------------------------------------------------------
    public int BuscaSequencial(int valor) {

        for (int j = 0; j < vetor.getVetor().length; j++) {
            if (vetor.getVetor()[j] == valor) {
                return j;
            }
        }

        return -1;
    }
    //Fim------------------------------------------------------------------------

    //Inicio Busca Binária------------------------------------------------------------------------
    public int BuscaBinaria(int valor) {
        return busca(vetor.getVetor(), valor);
    }

    private int busca(int[] array, int chave) {
        return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
    }

    private int buscaBinariaRecursiva(int[] array, int menor, int maior,
                                             int chave) {
        int media = (maior + menor) / 2;
        int valorMeio = array[media];

        if (menor > maior)
            return -1;
        else if(valorMeio == chave)
            return media;
        else if (valorMeio < chave)
            return buscaBinariaRecursiva(array, media+1, maior, chave);
        else
            return buscaBinariaRecursiva(array, menor, media-1, chave);
    }
    //Fim------------------------------------------------------------------------


    //Método para imprimir vetor------------------------------------------------------------------------
    public void imprimir() {

        System.out.print("Ordenado: ");
        for (int i = 0; i < vetor.getVetor().length; i++) {
            System.out.print(vetor.getVetor()[i] + " ");
        }
        System.out.println("");
    }
    //Fim------------------------------------------------------------------------

    //get e set------------------------------------------------------------------------
    public Vetor getVetor() {
        return vetor;
    }

    public void setVetor(Vetor vetor) {
        this.vetor = vetor;
    }
    //Fim------------------------------------------------------------------------
}
