import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {

        Vetor vetor = new Vetor(100000);
        vetor.povoarVetorAleatorio();

        //vetor.imprimir();

        Ordenacao ordenar = new Ordenacao(vetor);

        long tempoInicial = System.currentTimeMillis();

        ordenar.MergeSort();

        long tempoFinal = System.currentTimeMillis();

        System.out.println(tempoFinal - tempoFinal);
        
        //ordenar.imprimir();
    }
}



