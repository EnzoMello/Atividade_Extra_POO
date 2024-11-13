import java.util.Scanner;
import java.util.Locale;

public static void main(String[] args){
    locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int exemplo = sc.nextInt();

    System.out.println(verifica(exemplo));
    sc.close();
}

public static String verifica(int numero){
    if (numero % 2 == 0){
        return "Par";
    }
    else{
        return "impar";    
    }
}