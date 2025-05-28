import java.util.ArrayList;

/**
 * Clase Controller que actúa como intermediario entre la view y el model.
 * Ofrece métodos estáticos para crear coches, cambiar su velocidad y obtener la lista de coches.
 */

public class Controller {

    /**
     * Crea un nuevo coche con el modelo y matrícula especificados.
     * @param modelo
     * @param matricula
     * @return el objeto Coche
     */
    public static Coche crearCoche(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    /**
     * Cambia la velocidad de un coche según su matrícula.
     * @param matricula la matrícula del coche al que se desea cambiar la velocidad
     * @param velocidad la nueva velocidad que se quiere establecer
     * @return la velocidad actualizada del coche
     */

    public static int cambiarVelocidad(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }
    /**
     * Cambia la velocidad de un coche según su matrícula.
     * @param matricula la matrícula del coche que avanza
     * @param tiempo el tiempo que tarda ese coche en avanzar
     */
    public static int avanzarCoche(String matricula, int tiempo) {
        Coche c = Model.getCoche(matricula);
        if (c != null) {
            return c.avanzarCoche(tiempo);
        }
        return -1;
    }

    /**
     * Echar gasolina a un coche según su matrícula.
     * @param matricula la matrícula del coche que quiere repostar
     * @param litros litros de gasolina que se le echan al coche
     */

    public static boolean echarGasolina(String matricula, int litros) {
        Coche c = Model.getCoche(matricula);
        if (c != null) {
            c.echarGasolina(litros);
            return true;
        }
        return false;
    }

    /**
     * Obtiene la lista de todos los coches registrados.
     * @return un ArrayList con todos los coches
     */

    public static ArrayList<Coche> obtenerCoches() {
        return Model.obtenerCoches();
    }
}
