package Circle_Exercise_Ely.application;
import Circle_Exercise_Ely.entities.Entities;

import java.util.Scanner;
import java.util.Locale;

public class Circulo {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Entities entities;

        double raio = sc.nextDouble();

        // INICIO MEU CONSTRUTOR JÁ ATRIBUINDO UM VALOR AO RAIO
        entities = new Entities(raio);

        // CHAMANDO MEUS MÉTODOS DE ÁREA E PERÍMETRO
        System.out.printf("ÁREA: %.2f%n", entities.area());
        System.out.printf("PERÍMETRO: %.2f%n", entities.perimetro());

        sc.close();
    }
}
