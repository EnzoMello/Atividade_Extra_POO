package Financial_Exercise_Ely.application;
import Financial_Exercise_Ely.entities.FinancialSituation;

import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        FinancialSituation situation;

        double valorCreditos = sc.nextDouble();
        double valorDebitos = sc.nextDouble();

        situation = new FinancialSituation(valorCreditos, valorDebitos);

        System.out.printf("SALDO: %.2f R$%n", situation.calcularSaldo());
    }
}
