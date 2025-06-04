/**
 * Implementación del observador que muestra una alerta en consola
 * cuando el coche tiene menos de 10 litros de gasolina.
 */

public class AlertaConsola implements AlertaObserver {
    @Override
    public void actualizar(String mensaje) {
        View.mostrarMensaje(mensaje);
    }
}
