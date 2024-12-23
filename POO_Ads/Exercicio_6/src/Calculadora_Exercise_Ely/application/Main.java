package Calculadora_Exercise_Ely.application;


import Calculadora_Exercise_Ely.entities.Entities;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double operando1 = sc.nextDouble();
        double operando2 = sc.nextDouble();
        Entities entities = new Entities(operando1, operando2);
        System.out.printf("Diferença = %.2f%n",entities.diferenca());
        System.out.printf("Soma = %.2f%n",entities.soma());

        sc.close();
        // não é possível acessar os atributos privados diretamente, apenas usando construtores
    }
}