import java.util.Scanner;
import java.util.ArrayList;

public class View {
    static Scanner sc = new Scanner(System.in);

    // Muestra la velocidad de un coche
    public static void muestraVelocidad(String matricula, Integer v) {
        System.out.println(matricula + ": " + v + " km/h");
    }

    // Muestra todos los coches
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

    // Pide un dato al usuario
    public static String pedirDato(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    // Menú principal de la aplicación
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

                case "0":
                    return;
                default:
                    mostrarMensaje("Opción no válida.");
            }
        }
    }
}
