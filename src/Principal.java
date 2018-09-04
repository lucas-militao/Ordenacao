import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(10);
        vetor.povoarVetor();

        vetor.imprimir();

        Ordenacao ordenar = new Ordenacao(vetor);

        ordenar.MergeSort();

        ordenar.imprimir();
    }
}



