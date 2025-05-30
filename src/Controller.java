import java.util.ArrayList;

public class Controller {
    public static Coche crearCoche(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    /**
     * Cambia la velocidad de un coche según su matrícula.
     *
     * @param matricula la matrícula del coche al que se desea cambiar la velocidad
     * @param velocidad la nueva velocidad a asignar
     * @return la velocidad actualizada del coche
     */

    public static int cambiarVelocidad(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }

    /**
     * Hace avanzar un coche según su matrícula y el tiempo especificado.
     * Disminuye la gasolina del coche mientras avanza.
     *
     * @param matricula la matrícula del coche que avanza
     * @param tiempo el tiempo durante el cual el coche avanza (en horas)
     * @return la distancia recorrida por el coche en kilómetros, o -1 si el coche no se encuentra o no tiene suficiente gasolina
     */

    public static int avanzarCoche(String matricula, int tiempo) {
        Coche c = Model.getCoche(matricula);
        return (c != null) ? c.avanzarCoche(tiempo) : -1;
    }

    /**
     * Echa gasolina a un coche según su matrícula.
     *
     * @param matricula la matrícula del coche que quiere repostar
     * @param litros la cantidad de gasolina a añadir al coche
     * @return true si el coche fue encontrado y la gasolina fue añadida correctamente, false si no se encontró el coche
     */

    public static boolean echarGasolina(String matricula, double litros) {
        Coche c = Model.getCoche(matricula);
        if (c != null) {
            c.echarGasolina(litros);
            return true;
        }
        return false;
    }

    public static ArrayList<Coche> obtenerCoches() {
        return Model.obtenerCoches();
    }
}
