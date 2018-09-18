import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {

        Vetor vetor = new Vetor(5);
        vetor.povoarVetorAleatorio();

        vetor.imprimir();

        Ordenacao ordenar = new Ordenacao(vetor);

        long tempoInicial = System.currentTimeMillis();

        ordenar.ShellSort();

        long tempoFinal = System.currentTimeMillis();

        ordenar.imprimir();

        System.out.println(tempoFinal - tempoInicial); //tempo de execução em milissegundos
    }
}



