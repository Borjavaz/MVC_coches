import java.util.ArrayList;

public class Controller {

    public static Coche crearCoche(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    public static int cambiarVelocidad(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }

    public static ArrayList<Coche> obtenerCoches() {
        return Model.obtenerCoches();
    }
}
