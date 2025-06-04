import java.util.ArrayList;

/**
 * La clase Model gestiona la lógica de datos relacionada con los coches.
 * Almacena una lista estática de coches y proporciona métodos para crear coches,
 * cambiar su velocidad y obtener información sobre los coches registrados.
 */

public class Model {
    private static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche con el modelo y matrícula especificados y lo añade al parking.
     *
     * @param modelo el modelo del coche
     * @param matricula la matrícula del coche
     * @return el objeto Coche creado y añadido al parking
     */

    public static Coche crearCoche(String modelo, String matricula) {
        Coche car = new Coche(modelo, matricula);
        car.añadirObservador(new AlertaConsola());
        parking.add(car);
        return car;

    }

    public static Coche getCoche(String matricula) {
        for (Coche e : parking) {
            if (e.getMatricula().equalsIgnoreCase(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche dado su matrícula.
     *
     * @param matricula la matrícula del coche al que se desea cambiar la velocidad
     * @param vel la nueva velocidad a asignar
     * @return la velocidad actualizada del coche
     */

    public static int cambiarVelocidad(String matricula, int vel) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.setVelocidad(vel);
            return c.getVelocidad();
        }
        return -1;
    }

    public static ArrayList<Coche> obtenerCoches() {
        return parking;
    }
}
