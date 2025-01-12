package Rectangle_Exercise_Ely.application;
import Rectangle_Exercise_Ely.entities.Rectangle;
import java.util.Scanner;
import java.util.Locale;



public class Retangulo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle;

        double lado1 = sc.nextDouble();
        double lado2 = sc.nextDouble();

        rectangle = new Rectangle(lado1, lado2); // INICIO MEU CONSTRUTOR RECTANGLE JÁ COM OS ATRIBUTOS LADOS INICIADOS

        System.out.println("Lados:");
        System.out.println(rectangle.getlado1());
        System.out.println(rectangle.getLado2());
        System.out.printf("ÁREA: %.2f%n", rectangle.area());
        System.out.printf("PERÍMETRO: %.2f%n", rectangle.perimetro());

        sc.close();
    }

}
