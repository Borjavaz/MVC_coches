import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }
    public static void menu(){

        do{
            System.out.println("1- Crear coche");
            System.out.println("2- Cambiar velocidad");
            System.out.println("3- Mostrar todos los coches");
            System.out.println("0 - Salir");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    Controller.crearCoche();
                break;

                case 2:
                    Controller.cambiarVelocidad();
                break;

                case 3:
                    Controller.mostrarCoches();
                break;

                case 0:
                    System.exit(0);
                break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (true);
    }
}

