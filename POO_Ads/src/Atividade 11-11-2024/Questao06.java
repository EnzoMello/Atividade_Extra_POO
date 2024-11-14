public class Saudacao{
    // Declarando minhas variáveis
    private String texto;
    private String destinatario; 

    // Criando meu construtor
    public Saudacao(String texto, String destinatario){
        this.texto = texto;
        this.destinatario = destinatario;
    }

    // Criando meu método obterSaudacao
    public String obterSaudacao(){
        return texto + ", " + destinatario;
    }

    public static void main(String[] args){

        Saudacao saudacao = new Saudacao("Bom dia","joão");
        System.out.println(saudacao.obterSaudacao());
    }
}