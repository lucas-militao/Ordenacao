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
        MergeSort(vetor.getVetor(), 0, vetor.getVetor().length);
    }

    private void MergeSort(int[] vet, int i, int f) {
        if (i < f) {
            int m = (i + f) / 2;
            MergeSort(vet, i, m);
            MergeSort(vet, m + 1, f);
            Intercala(vet, i, m, f);
        }
    }

    private void Intercala(int[] vet, int i, int m, int f) {
        int vet2[] = new int[vet.length];
        for (int j = i; j <= m; j++) {
            vet2[j] = vet[j];
        }
        for (int g = m + 1; g < f; g++) {
            vet2[f + m - g] = vet[g];
        }
        int x = i;
        int z = f - 1;
        for (int k = i; k < f; k++) {
            if (vet2[x] <= vet2[z]) {
                vet[k] = vet2[x];
                x = x + 1;
            } else {
                vet[k] = vet2[z];
                z = z - 1;
            }
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
    public void HeapSort() {
        HeapSort(vetor.getVetor());
    }

    private void buildheap(int []arr) {

        /*
         * As last non leaf node will be at (arr.length-1)/2
         * so we will start from this location for heapifying the elements
         * */
        for(int i=(arr.length-1)/2; i>=0; i--){
            heapify(arr,i,arr.length-1);
        }
    }

    private void heapify(int[] arr, int i,int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max;
        if(left <= size && arr[left] > arr[i]){
            max=left;
        } else {
            max=i;
        }

        if(right <= size && arr[right] > arr[max]) {
            max=right;
        }
        // If max is not current node, exchange it with max of left and right child
        if(max!=i) {
            exchange(arr,i, max);
            heapify(arr, max,size);
        }
    }

    private void exchange(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int[] HeapSort(int[] arr) {

        buildheap(arr);
        int sizeOfHeap=arr.length-1;
        for(int i=sizeOfHeap; i>0; i--) {
            exchange(arr,0, i);
            sizeOfHeap=sizeOfHeap-1;
            heapify(arr, 0,sizeOfHeap);
        }
        return arr;
    }
    //Fim de HeapSort------------------------------------------------------------------------

    //Inicio Ordenação Sequencial------------------------------------------------------------------------

    //Fim Ordenação Sequencial------------------------------------------------------------------------

    //Inicio Ordenacao Binária------------------------------------------------------------------------

    //Fim Ordenacao Binária------------------------------------------------------------------------

    public void imprimir() {

        for (int i = 0; i < vetor.getVetor().length; i++) {
            System.out.print(vetor.getVetor()[i] + " ");
        }
        System.out.println("");
    }
}
