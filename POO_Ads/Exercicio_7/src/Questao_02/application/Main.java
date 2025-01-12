package Questao_02.application;

import Questao_02.entities.Calculadora;

public class Main {
    public static void main(String[] args){
        Calculadora calculadora = new Calculadora(10, 20);
        System.out.println("Soma = " + calculadora.soma());
    }
}
