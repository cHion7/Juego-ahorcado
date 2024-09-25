import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Bienvenidoa Retroplayer!!");
        int option;

        do {
            System.out.print("\n¿Que desea hacer?\n1. Jugar al Ahorcado\n2. Salir\nElige: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    Ahorcado ah = new Ahorcado();
                    ah.jugar();
                    ah.mostraPartidasJugadas();
                    break;
                case 2:
                    System.out.println("Vuelve pronto!");
            }
        } while (option != 2);
    }
}
