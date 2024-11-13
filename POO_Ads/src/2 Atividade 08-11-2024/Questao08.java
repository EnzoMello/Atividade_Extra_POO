import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        // Array de números
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usando map para dobrar os elementos e reduce para somá-los
        int myNumbers = numbers.stream()          // Cria uma stream
                                .map(n -> n * 2)   // Dobra cada número (map)
                                .reduce(0, Integer::sum);  // Soma os números (reduce)

        System.out.println("Soma dos números dobrados: " + myNumbers);
    }
}

/*Uma stream representa uma sequência de elementos que podem ser consumidos um de cada vez.
As streams oferecem uma série de operações para transformar, filtrar, agrupar, ou combinar os dados de maneira funcional e declarativa.
No Java, o método filter é utilizado em streams para filtrar elementos de uma coleção com base em uma condição. */