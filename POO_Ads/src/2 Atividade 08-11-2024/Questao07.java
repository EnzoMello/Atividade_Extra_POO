import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){
        // Array de números
        List<Integer> numbers = Arrays.list(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Filtra os números pares
        List<Integer> myNumbers = numbers.stream()
                                          .filter(n -> n % 2 == 0)  // Condição: número par
                                          .collect(Collectors.toList());  // Coleta o resultado em uma nova lista

        System.out.println(myNumbers);
    }
}

/*Uma stream representa uma sequência de elementos que podem ser consumidos um de cada vez.
As streams oferecem uma série de operações para transformar, filtrar, agrupar, ou combinar os dados de maneira funcional e declarativa.
No Java, o método filter é utilizado em streams para filtrar elementos de uma coleção com base em uma condição. */