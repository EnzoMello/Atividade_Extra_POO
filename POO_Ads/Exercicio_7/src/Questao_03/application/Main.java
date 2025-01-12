package Questao_03.application;

import Questao_03.entities.CalculadoraCientifica;

public class Main {
    public static void main(String [] args){
        CalculadoraCientifica calculadora = new CalculadoraCientifica(10, 20);
        System.out.println("Exponenciação = " + calculadora.exponenciar());
    }

    /*Uso de Getter para pegar o atributo de calculadora. Não foi necessário mudar o tipo
     de atributo*/
}
