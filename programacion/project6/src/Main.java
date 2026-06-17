import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;



        do{
            System.out.println("=== MENU ===");
            System.out.println("1. Crear Socio.");
            System.out.println("2. Registrar reserva.");
            System.out.println("3. Mostrar ranking.");
            System.out.println("4. Buscar socio.");
            System.out.println("5. Mostrar historial.");
            System.out.println("6. Salir.");
            System.out.print("Opcion a elegir:");
            option = sc.nextInt();


            switch(option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta. Elija del [1...6]");
            }

        }while(option != 6);
    }
}
