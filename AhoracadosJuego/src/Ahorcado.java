import java.util.*;

public class Ahorcado extends Juego implements Tablero {

    private Jugador jugador;
    private String palabraElegida;
    private int fallos;
    private int aciertos;
    private String[] letrasAdivinadas;
    private boolean victoria;

    public void jugar(){
        palabraElegida = Palabra.palabraAleatoria();
        letrasAdivinadas = new String[palabraElegida.length()];
        String[] palabraAdivinar = palabraElegida.split("");

        for(int i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = " _ ";
        }

        Scanner in = new Scanner(System.in);
        System.out.print("\nIntroduce tu alias de jugador: ");
        String alias = in.nextLine();
        Jugador j = new Jugador(alias);
        jugador = j;

        fallos = 0;
        victoria = false;
        aciertos = 0;

        System.out.println();
        for (String aux : letrasAdivinadas) {
            System.out.print(aux);
        }
        System.out.println();

        do {
            System.out.print("\nDi una letra: ");
            char letra = in.next().toUpperCase().charAt(0);
            mostrarTablero(letra);
            dibujarEstado(fallos);
        } while (fallos != 6 && victoria == false);

        if (fallos == 6) {
            char letra = '0';
            mostrarTablero(letra);
            System.out.print("\nGAME OVER\nLa palabra era: " + palabraElegida + "\nPulsa 'enter' para continuar:");
            in.next();
        } else {
            System.out.println("YOU WIN!!!");
        }
    }

    public void mostrarTablero(char letra) {
        String letraS = String.valueOf(letra);

        if (!palabraElegida.contains(letraS)) {
            fallos++;
        } else {
            int pos = 0;
            do {
                pos = palabraElegida.indexOf(letraS, pos);
                if (pos != -1) {
                    letrasAdivinadas[pos] = letraS;
                    pos += 1;
                    aciertos++;
                }
            } while(pos != -1);
        }

        if (aciertos == palabraElegida.length()) {
            victoria = true;
        }

        System.out.println();
        for (String aux : letrasAdivinadas) {
            System.out.print(aux);
        }
        System.out.println();
    }

    public void dibujarEstado(int fallos) {
        char cabeza = (fallos >= 1)? '0':' ';
        char torso = (fallos >= 2)? '|':' ';
        char bIzq = (fallos >= 3)? '/':' ';
        char bDer = (fallos >= 4)? '\\':' ';
        char pIzq = (fallos >= 5)? '/':' ';
        char pDer = (fallos >= 6)? '\\':' ';

        System.out.println();
        System.out.println("-----\n|   |\n|   " + cabeza + "\n|  " + bIzq + torso + bDer + "\n|  " + pIzq + pDer);

        if (fallos < 6 || victoria) {
            System.out.println("\nNúmero de fallos del jugador " + jugador.mostrarAlias() + ": " + fallos);
        }
    }
}