package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void printMenu() {
        System.out.println("\n== Gerenciamento de Estoque ==");
        System.out.println("\t1. Dimesionar estoque");
        System.out.println("\t2. Status do estoque\n");
        System.out.println("== Gerenciamento de Produtos ==");
        System.out.println("\t3. Adicionar Produto");
        System.out.println("\t4. Retirar Produto");
        System.out.println("\t5. Mover Produto");
        System.out.println("\t6. Fazer Inventário de Produtos");

        System.out.println("\t0. Sair");
    }

    public static String inputString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public static int inputInt(Scanner scanner, String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException erro) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
        return input;
    }
}


