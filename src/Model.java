import java.util.ArrayList;

public class Model {
    public static ArrayList<Coche> parking = new ArrayList<>();

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

    public static int cambiarVelocidad(String matricula, int vel) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = vel;
            return c.velocidad;
        }
        return -1; // Retorna -1 si no se encuentra el coche
    }

    public static ArrayList<Coche> obtenerCoches() {
        return parking;
    }
}

