public abstract class Juego {
    private int partidasJugadas;

    public void dibujarEstado(int fallos) {
        System.out.println("Número de fallos: " + fallos);
    }

    public void mostraPartidasJugadas() {
        System.out.println("Partidas jugadas: " + partidasJugadas);
    }

}