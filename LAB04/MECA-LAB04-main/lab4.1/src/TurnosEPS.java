import java.util.ArrayList;
import java.util.Scanner;

public class TurnosEPS {

    public static void main(String[] args) {
        ArrayList<Paciente> listaTurnos = new ArrayList<Paciente>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Obtener turno");
            System.out.println("2. Atender turno");
            System.out.println("3. Ver cola de turnos");
            System.out.println("4. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese su nombre y apellidos:");
                    String nombre = sc.nextLine();
                    System.out.println(nombre);
                    System.out.println("Ingrese su edad:");
                    int edad = sc.nextInt();
                    System.out.println("Ingrese su afiliación (POS/PC):");
                    String afiliacion = sc.next();
                    System.out.println("¿Tiene alguna condición especial? (S/N):");
                    String respuesta = sc.next();

                    String condicionEspecial = null;
                    if (respuesta.equalsIgnoreCase("S")) {
                        System.out.println("Ingrese su condición especial:");
                        condicionEspecial = sc.next();
                    }

                    Paciente paciente = new Paciente(nombre, edad, afiliacion, condicionEspecial);
                    listaTurnos.add(paciente);

                    System.out.println("\nSu número de turno es: " + listaTurnos.size());
                    break;

                case 2:
                    if (listaTurnos.isEmpty()) {
                        System.out.println("\nNo hay pacientes en la cola.");
                    } else {
                        Paciente pacienteAtendido = listaTurnos.remove(0);
                        System.out.println("\nEl siguiente paciente es: " + pacienteAtendido.getNombre());
                    }
                    break;

                case 3:
                    if (listaTurnos.isEmpty()) {
                        System.out.println("\nNo hay pacientes en la cola.");
                    } else {
                        System.out.println("\nLa cola de turnos es:");
                        for (int i = 0; i < listaTurnos.size(); i++) {
                            Paciente pacienteEnCola = listaTurnos.get(i);
                            System.out.println((i+1) + ". " + pacienteEnCola.getNombre());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nOpción inválida.");
                    break;
            }

            if (!listaTurnos.isEmpty()) {
                System.out.println("\nLlamando al siguiente turno en 5 segundos...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Paciente pacienteLlamado = listaTurnos.get(0);
                System.out.println("\nEl siguiente paciente es: " + pacienteLlamado.getNombre());
            }
        }
    }
}
