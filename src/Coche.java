import java.util.ArrayList;

public class Coche {
    private String matricula;
    private String modelo;
    private Integer velocidad;
    private double gasolina;

    /**
     * Constructor que inicializa un coche con el modelo, la matrícula y la velocidad inicial a 0.
     * La gasolina inicial es 0.
     *
     * @param modelo el modelo del coche
     * @param matricula la matrícula del coche
     */
    private ArrayList<AlertaObserver> observadores = new ArrayList<>();

    /**
     * Añade un observador que será notificado si la gasolina baja de 10 litros.
     *
     * @param obs el observador a registrar
     */

    public void añadirObservador(AlertaObserver obs) {
        observadores.add(obs);
    }

    /**
     * Notifica a todos los observadores si la gasolina baja de 10 litros.
     */

    private void notificarAlerta() {
        if (gasolina < 10) {
            for (AlertaObserver obs : observadores) {
                obs.actualizar("Alerta: Repostar");
            }
        }
    }


    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.gasolina = 0;
    }

    /**
     * Calcula la distancia que puede avanzar el coche con la gasolina disponible.
     * Si el coche no tiene suficiente gasolina, no avanzará.
     *
     * @param tiempo el tiempo en horas que el coche avanza
     * @return la distancia recorrida en km, o -1 si no hay suficiente gasolina
     */
    public int avanzarCoche(int tiempo) {
        int distancia = velocidad * tiempo; // distancia = velocidad * tiempo
        double consumo = distancia / 10.0; // Ejemplo: 10 km por litro de gasolina

        // Comprobar si hay suficiente gasolina para avanzar
        if (gasolina >= consumo) {
            gasolina -= consumo;// Reducir la gasolina proporcionalmente
            notificarAlerta(); //Llamada al observer
            return distancia; // Retornar la distancia recorrida
        } else {
            return -1; // No hay gasolina suficiente
        }
    }

    /**
     * Añade gasolina al coche.
     *
     * @param litros la cantidad de litros a añadir al coche
     */
    public void echarGasolina(double litros) {
        this.gasolina += litros;
        notificarAlerta();
    }

    /**
     * Obtiene la cantidad de gasolina que queda en el coche.
     *
     * @return la cantidad de gasolina restante
     */
    public double obtenerGasolina() {
        return gasolina;
    }

    // Getter y Setter para matricula
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Getter y Setter para modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter y Setter para velocidad
    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    // Getter y Setter para gasolina
    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }
}
