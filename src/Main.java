import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorViviendas gestor = new GestorViviendas();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar vivienda");
            System.out.println("2. Buscar por matrícula (lineal)");
            System.out.println("3. Buscar por apellido del propietario");
            System.out.println("4. Listar matrículas");
            System.out.println("5. Ordenar por burbuja");
            System.out.println("6. Ordenar por inserción");
            System.out.println("7. Buscar por matrícula (binaria)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Nombre propietario: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido propietario: ");
                    String apellido = sc.nextLine();
                    System.out.print("Barrio: ");
                    String barrio = sc.nextLine();
                    Vivienda vivienda = new Vivienda(matricula, direccion, nombre, apellido, barrio);
                    gestor.registrarVivienda(vivienda);
                    break;

                case 2:
                    System.out.print("Ingrese matrícula a buscar: ");
                    int m1 = sc.nextInt();
                    gestor.buscarPorMatriculaLineal(m1);
                    break;

                case 3:
                    System.out.print("Ingrese apellido a buscar: ");
                    String a1 = sc.nextLine();
                    gestor.buscarPorApellido(a1);
                    break;

                case 4:
                    gestor.listarMatriculas();
                    break;

                case 5:
                    gestor.ordenarPorBurbuja();
                    break;

                case 6:
                    gestor.ordenarPorInsercion();
                    break;

                case 7:
                    System.out.print("Ingrese matrícula a buscar (binaria): ");
                    int m2 = sc.nextInt();
                    gestor.buscarBinaria(m2);
                    break;

                case 0:
                    System.out.println("👋 Saliendo del programa...");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }
}
