import java.util.Scanner;
import java.util.Locale;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String nome = sc.next();
        String pronome = sc.next();

        System.out.printf("%s.%s%n", pessoa(nome), pessoa2(pronome));
        sc.close();
    }

    public static String pessoa(String name){
        return name;
    }
    
    public static String pessoa2(String proname){
        return proname;
    }

}