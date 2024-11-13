import java.util.Scanner;
import java.util.Locale;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] vect = new int[n];

        System.out.println("Digite os números do vetor.");
        for(int i = 0; i <= n; i++){
            vect[i] = sc.nextInt();
        }

        String resultado = sequencia("", vect);
        System.out.printf("%s%n", resultado);

        sc.close();
    }

    public static String sequencia(String palavra, int[] vetor){
        for(int i = 0; i < vetor.length; i++){
            palavra += Integer.toString(vetor[i]);
            if(i < vetor.length - 1){
                palavra += "-";
            }
        }

        return palavra;
    }
}