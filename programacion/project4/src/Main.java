import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Torneo torneo = new Torneo();

        int opcion = 0;

        do{
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Crear jugador");
            System.out.println("2. Registrar partida");
            System.out.println("3. Mostrar ranking");
            System.out.println("4. Buscar jugador");
            System.out.println("5. Mostrar historial");
            System.out.println("6.salir");
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Error: debes de introducir un numero");
                sc.nextLine();
                continue;
            }

            switch (opcion){
                case 1:
                    System.out.println("Nombre del jugador: ");
                    String nombre = sc.nextLine();

                    System.out.println("Nickname del jugador: ");
                    String nickname = sc.nextLine();

                    System.out.println("Edad del jugador: ");
                    int edad = sc.nextInt();

                    System.out.println("Puntuacion del jugador: ");
                    int puntos = sc.nextInt();
                    sc.nextLine();

                    Jugador nuevo = new Jugador(nickname, nombre, edad, puntos, Categoria.BRONCE);
                    torneo.addJugador(nuevo);
                    break;
                case 2:
                    System.out.println("Nickname del jugador: ");
                    String nickPartida = sc.nextLine();

                    Jugador jugadorPartida = torneo.buscarPorNickname(torneo.generarRankingArray(), nickPartida);
                    if(jugadorPartida == null){
                        System.out.println("Jugador no encontrado");
                    }
                break;
                case 3:
                    torneo.calcularRanking();
                    break;
                    case 4:
                        System.out.println("Nickname a buscar: ");
                        String nickBuscar = sc.nextLine();

                        Jugador encontrado = torneo.buscarPorNickname(torneo.generarRankingArray(),nickBuscar);
                        if(encontrado != null) {
                            System.out.println("Jugador encontrado: " + encontrado.getNickname() + " Puntos: " + encontrado.getPuntuacion());
                        }else{
                            System.out.println("Jugador no encontrado");
                        }
                        break;
                case 5:
                    torneo.mostrarHistorial();
                    break;
                case 6:
                    System.out.println("Saliendoooooo");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion!=6);
        sc.close();
    }
}
