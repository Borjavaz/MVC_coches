/**
 * @author Borja
 * Crea un nuevo coche con el modelo y la matrícula que introduzca el usuario.
 */
public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;


    /**
     * @param modelo el modelo del coche
     * @param matricula la matrícula del coche
     * La velocidad inicial del coche será 0.
     */

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }

    /**
     * @param tiempo el tiempo que tarda el coche
     */
    public int avanzarCoche(int tiempo) {
        return velocidad * tiempo; // distancia = velocidad * tiempo
    }

    /**
     * @param litros litros de gasolina que le echas al coche
     * @param gasolina declaramos esta nueva variable
     */

    double gasolina;

    public void echarGasolina(double litros) {
        this.gasolina += litros;
    }

}
