package Questao_01.entities;

public class CarroEletrico extends Carro{
    private int autonomiaBateria;

    public CarroEletrico(String placa, int ano, String modelo, int autonomiaBateria) {
        super(placa, ano, modelo); // super chama o construtor da classe base(CarroEletrico herda Carro)
        this.autonomiaBateria = autonomiaBateria;
    }

    public int getAutonomiaBateria() {
        return autonomiaBateria;
    }
}
