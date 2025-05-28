import java.util.Scanner;
import java.util.ArrayList;

/**
 * La clase View gestiona la interacción con el usuario.
 * Muestra información por pantalla, solicita datos y presenta un menú principal.
 */

public class View {
    static Scanner sc = new Scanner(System.in);

    /**
     * Muestra por consola la matrícula y la velocidad de un coche.
     *
     * @param matricula la matrícula del coche
     * @param v la velocidad actual del coche
     */

    public static void muestraVelocidad(String matricula, Integer v) {
        System.out.println(matricula + ": " + v + " km/h");
    }

    /**
     * Muestra todos los coches del sistema.
     *
     * @param coches lista de coches a mostrar
     */
    public static void mostrarCoches(ArrayList<Coche> coches) {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el parking.");
        } else {
            System.out.println("Coches en el parking:");
            for (Coche coche : coches) {
                System.out.println("Matrícula: " + coche.matricula +
                        " | Modelo: " + coche.modelo +
                        " | Velocidad: " + coche.velocidad + " km/h");
            }
        }
    }


    // Muestra un mensaje al usuario
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita un dato al usuario y lo devuelve como cadena.
     *
     * @param mensaje el mensaje que se muestra para pedir el dato
     * @return el dato introducido por el usuario
     */
    public static String pedirDato(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    /**
     * Muestra el menú principal de la aplicación y gestiona las opciones del usuario.
     * Permite crear coches, cambiar la velocidad de un coche, mostrar todos los coches o salir.
     */
    public static void menu() {
        while (true) {
            System.out.println("-----MENU-----");
            System.out.println("1- Crear coche");
            System.out.println("2- Cambiar velocidad");
            System.out.println("3- Mostrar todos los coches");
            System.out.println("0 - Salir");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    // Solicita datos y llama al Controller para crear un coche
                    String modelo = pedirDato("Introduce el modelo: ");
                    String matricula = pedirDato("Introduce la matrícula: ");
                    Controller.crearCoche(modelo, matricula);
                    mostrarMensaje("Coche creado correctamente.");
                    break;
                case "2":
                    // Solicita datos y llama al Controller para cambiar la velocidad
                    matricula = pedirDato("Introduce la matrícula del coche: ");
                    String velocidadInput = pedirDato("Introduce la nueva velocidad: ");
                    try {
                        int velocidad = Integer.parseInt(velocidadInput);

                        // Comprobar que la velocidad no sea negativa
                        if (velocidad < 0) {
                            mostrarMensaje("La velocidad no puede ser negativa.");
                        } else {
                            int nuevaVelocidad = Controller.cambiarVelocidad(matricula, velocidad);
                            if (nuevaVelocidad != -1) {
                                muestraVelocidad(matricula, nuevaVelocidad);
                            } else {
                                mostrarMensaje("Coche no encontrado.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        mostrarMensaje("Velocidad no valida.");
                    }
                    break;
                    case "3":
                    // Llama al Controller para mostrar todos los coches
                    mostrarCoches(Controller.obtenerCoches());
                    break;

                case "4":
                    matricula = pedirDato("Introduce la matrícula del coche: ");
                    String tiempoInput = pedirDato("Introduce el tiempo en horas: ");
                    try {
                        int tiempo = Integer.parseInt(tiempoInput);
                        if (tiempo < 0) {
                            mostrarMensaje("El tiempo no puede ser negativo.");
                        } else {
                            int distancia = Controller.avanzarCoche(matricula, tiempo);
                            if (distancia != -1) {
                                mostrarMensaje("El coche ha avanzado " + distancia + " km.");
                            } else {
                                mostrarMensaje("Coche no encontrado.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        mostrarMensaje("Tiempo no válido.");
                    }
                    break;

                case "0":
                    return;
                default:
                    mostrarMensaje("Opción no válida.");
            }
        }
    }
}
