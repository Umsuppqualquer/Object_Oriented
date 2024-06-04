package T1;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void pressEnter() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera o usuário pressionar Enter
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void fim(){
        pressEnter();
        clearConsole();
    }
    
}
