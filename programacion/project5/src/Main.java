import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cine cine = new Cine(10, 3);

        int option = 0;

        do{
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear película");
            System.out.println("2. Registrar valoración del público");
            System.out.println("3. Mostrar ranking");
            System.out.println("4. Buscar película");
            System.out.println("5. Mostrar medias de valoraciones");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try{
                option = sc.nextInt();
            }catch(Exception e){
                System.out.println("Debes de introducir un numero [1..6]");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            switch (option) {

                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Director: ");
                    String director = sc.nextLine();

                    System.out.print("Duración (minutos): ");
                    int duracion = leerEntero(sc);

                    System.out.print("Valoración inicial (0-100): ");
                    int valoracion = leerEntero(sc);

                    System.out.println("Género (ACCION, COMEDIA, DRAMA, TERROR, CIENCIA_FICCION, ANIMACION): ");
                    String gen = sc.nextLine().toUpperCase();

                    try {
                        Genero genero = Genero.valueOf(gen);
                        Pelicula p = new Pelicula(titulo, director, duracion, valoracion, Genero.COMEDIA);
                        cine.addPelicula(p);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Género no válido.");
                    }

                    break;

                case 2:
                    System.out.print("Índice de película: ");
                    int iPeli = leerEntero(sc);

                    System.out.print("Índice de sesión: ");
                    int iSesion = leerEntero(sc);

                    System.out.print("Valoración (0-100): ");
                    int val = leerEntero(sc);

                    cine.registarValoracion(iPeli, iSesion, val);
                    break;
                case 3:
                    cine.calcularRanking();
                    break;

                case 4:
                    System.out.print("Título a buscar: ");
                    String buscar = sc.nextLine();

                    break;
                case 5:
                    cine.mostrarMediaValoraciones();
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }while(option!=6);
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                int n = sc.nextInt();
                sc.nextLine();
                return n;
            } catch (Exception e) {
                System.out.println("Error: introduce un número válido.");
                sc.nextLine();
            }
        }
    }
}
