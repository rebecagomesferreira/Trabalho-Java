package view;

import view.FornecedorView;
import view.MaterialView;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE RECICLAGEM ===");
            System.out.println("1. Gerenciar Fornecedores");
            System.out.println("2. Gerenciar Materiais");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> new FornecedorView().exibirMenu();
                case 2 -> new MaterialView().exibirMenu();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
