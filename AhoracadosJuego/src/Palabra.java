import java.util.Random;

public enum Palabra {
    LLAMAR, GRITAR, JUGAR, PERRO, RATON, ZAPATO, ROBAR, CARROS, CUBRIR,
    GUISAR, MANJAR, SORBER, COCINA, BUSCAR, CUADRO, PERDIZ, CUEVAS, LAPIZ;

    private static Random random = new Random();

    public static String palabraAleatoria() {
        Palabra[] palabras = Palabra.values();
        return palabras[random.nextInt(palabras.length)].name();
    }
}
