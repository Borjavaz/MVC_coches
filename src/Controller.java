import java.util.Scanner;

public class Controller {

    static Scanner sc = new Scanner(System.in);
    static View view = new View();

    public static void inicio() {
        view.menu();  // Llama al menú de la vista
    }

    public static void crearCoche() {
        System.out.print("Introduce el modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();

        Model.crearCoche(modelo, matricula);
        System.out.println("Coche creado correctamente.");
    }

    public static void cambiarVelocidad() {
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = sc.nextLine();

        Coche coche = Model.getCoche(matricula);
        if (coche == null) {
            System.out.println("Coche no encontrado.");
            return;
        }

        System.out.print("Introduce la nueva velocidad: ");
        int velocidad = sc.nextInt();
        sc.nextLine();

        int nuevaVel = Model.cambiarVelocidad(matricula, velocidad);
        view.muestraVelocidad(matricula, nuevaVel);
    }

    public static void mostrarCoches() {
        Model.mostrarCoches();
    }

}
