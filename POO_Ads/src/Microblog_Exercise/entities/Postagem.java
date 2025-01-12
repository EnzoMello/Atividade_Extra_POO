package Microblog_Exercise.entities;

public class Postagem {
    private int id;
    private String texto;
    private int quantidadeCurtidas;

    public Postagem(int id, int quantidadeCurtidas, String texto) {
        this.id = id;
        this.quantidadeCurtidas = quantidadeCurtidas;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeCurtidas() {
        return quantidadeCurtidas;
    }

    public void setQuantidadeCurtidas(int quantidadeCurtidas) {
        this.quantidadeCurtidas = quantidadeCurtidas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void curtir(int qtd){
        quantidadeCurtidas += qtd;
    }

    public String toString(){
        return "Postagem: " + id + ", Curtidas:  " + quantidadeCurtidas + "\n";
    }
}
