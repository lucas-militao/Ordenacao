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
        sort(vetor.getVetor(), 0, vetor.getVetor().length - 1);
    }

    private void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
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

    //Inicio Ordenacao Binária------------------------------------------------------------------------
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
