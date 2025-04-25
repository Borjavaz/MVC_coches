import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return coche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    public static void aumentarVelocidad(int velocidad, String matricula) {

        //Declaramos variable coche q inicialmente no apunta a ningun valor
        Coche coche = null;

        // Buscar el coche en el parking
        for (Coche c : parking) {
            if (c.matricula.equals(matricula)) {
                coche = c;
                break;
            }
        }

        // Si se encontró el coche, aumentar su velocidad
        if (coche != null) {
            coche.velocidad += velocidad;
        }
    }

    public static void disminuirVelocidad(int velocidad, String matricula) {

        //Declaramos variable coche q inicialmente no apunta a ningun valor
        Coche coche = null;

        // Buscar el coche en el parking
        for (Coche c : parking) {
            if (c.matricula.equals(matricula)) {
                coche = c;
                break;
            }
        }

        // Si se encuentra el coche, disminuir su velocidad
        if (coche != null) {
            coche.velocidad -= velocidad;

            // Evitar que la velocidad sea negativa
            if (coche.velocidad < 0) {
                coche.velocidad = 0;
            }
        }
    }



}
