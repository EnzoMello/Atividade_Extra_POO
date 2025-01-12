package Questao_01.application;

import Questao_01.entities.Carro;
import Questao_01.entities.CarroEletrico;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("ENZO-1234", 2005, "Esportivo");
        System.out.println("Placa: " + carro.getPlaca());
        System.out.println("Ano: " + carro.getAno());
        System.out.println("Modelo: " + carro.getModelo());

        // Criando um objeto de CarroEletrico
        CarroEletrico carroEletrico = new CarroEletrico("XYZ-5678", 2025, "SUV", 400);
        System.out.println("\nPlaca: " + carroEletrico.getPlaca());
        System.out.println("Ano: " + carroEletrico.getAno());
        System.out.println("Modelo: " + carroEletrico.getModelo());
        System.out.println("Autonomia da Bateria: " + carroEletrico.getAutonomiaBateria() + " km");

    }
}
