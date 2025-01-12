package Questao_01.entities;

public class Carro extends Veiculo{
    private String modelo;

    public Carro(String placa, int ano, String modelo) {
        super(placa, ano); // super chama o construtor da classe base
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}
