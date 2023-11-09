package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void printMenu() {
        System.out.println("== Gerenciamento de Estoque ==");
        System.out.println("\t1. Dimesionar estoque\n");
        System.out.println("== Gerenciamento de Produtos ==");
        System.out.println("\t2. Adicionar Produto");
        System.out.println("\t3. Retirar Produto");
        System.out.println("\t4. Mover Produto");
        System.out.println("\t5. Fazer Inventário de Produtos");

        System.out.println("\t0. Sair\n");
        System.out.print(">> Insira a opção selecionada (ex.: 1): ");
    }

    public static String inputString(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        String input = scanner.next();

        scanner.close();

        return input;
    }

    public static int inputInt(Scanner scanner, String prompt) {
        System.out.print(prompt);

        return scanner.nextInt();
    }
}
