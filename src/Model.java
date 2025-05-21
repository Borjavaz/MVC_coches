import java.util.ArrayList;


/**
 * La clase Model gestiona la lógica de datos relacionada con los coches.
 */

public class Model {

    /**
     * Lista que almacena todos los coches creados.
     */

    public static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche con el modelo y matrícula especificados y lo añade al parking.
     *
     * @param modelo el modelo del coche
     * @param matricula la matrícula del coche
     * @return el objeto Coche creado
     */

    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }


    public static Coche getCoche(String matricula){
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche dado su matrícula.
     *
     * @param matricula la matrícula del coche
     * @param vel la nueva velocidad a asignar
     * @return la velocidad actualizada, o -1 si el coche no se encuentra
     */

    public static int cambiarVelocidad(String matricula, int vel) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = vel;
            return c.velocidad;
        }
        return -1; // Retorna -1 si no se encuentra el coche
    }

    /**
     * Devuelve la lista de todos los coches en el parking.
     *
     * @return una lista con todos los objetos Coche
     */

    public static ArrayList<Coche> obtenerCoches() {
        return parking;
    }
}

