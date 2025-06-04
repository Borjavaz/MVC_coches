/**
 * Interfaz del patrón Observer.
 * Las clases que implementen esta interfaz podrán recibir notificaciones
 * cuando ocurra un evento relevante (gasolina baja).
 */

public interface AlertaObserver {
    void actualizar(String mensaje);
}
