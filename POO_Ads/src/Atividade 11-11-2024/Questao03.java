public class Hotel{
    private int quantReservas;

    // CRIANDO O CONSTRUTOR HOTEL COM OS ATRIBUTOS DE RESERVA
    public hotel(int quantReservas){
        this.quantReservas = quantReservas;
    }

    public int getQuantReservas(){
        return quantReservas; // Método get para retornar o quantReservas
    }

    public static void main(String[] args){
        Hotel hotel = new hotel(2); // Inicia o construtor com um quantReservas = 2
        System.out.println(getQuantReservas);
    }
}