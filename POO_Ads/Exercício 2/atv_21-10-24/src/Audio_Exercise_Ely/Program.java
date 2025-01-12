package Audio_Exercise_Ely;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ControleDeAudio audio;

        int volume = 2;
        audio = new ControleDeAudio(volume);

        System.out.printf("Aumentando em um o volume: %d%n", audio.aumentaVolume());
        System.out.printf("Diminuindo em um o volume: %d%n", audio.diminuiVolume());
        System.out.printf("Lendo volume: %d%n", audio.lerVolume());

        sc.close();
    }
}
