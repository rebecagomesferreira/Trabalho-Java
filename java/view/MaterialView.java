package view;

import control.MaterialController;
import model.Material;
import java.util.Scanner;

public class MaterialView {
    private MaterialController control = new MaterialController();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU MATERIAL ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Deletar");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> deletar();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrar() {
        System.out.print("Tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Preço por Kg: ");
        double preco = sc.nextDouble();
        control.cadastrar(new Material(tipo, desc, preco));
    }

    private void listar() {
        control.listar().forEach(System.out::println);
    }

    private void atualizar() {
        System.out.print("Informe o ID do material: ");
        int id = sc.nextInt(); sc.nextLine();

        Material atual = control.buscarPorId(id);
        if (atual == null) {
            System.out.println("Material não encontrado!");
            return;
        }

        System.out.println("\n--- Dados atuais ---");
        System.out.println(atual);

        System.out.println("\n--- Digite novos valores (ou pressione ENTER para manter) ---");
        System.out.print("Novo tipo (" + atual.getTipo() + "): ");
        String tipo = sc.nextLine();
        System.out.print("Nova descrição (" + atual.getDescricao() + "): ");
        String desc = sc.nextLine();

        System.out.print("Novo preço/kg (" + atual.getPrecoKg() + "): ");
        String precoStr = sc.nextLine();
        double preco = -1; // valor padrão = não atualizar
        if (!precoStr.isEmpty()) {
            try {
                preco = Double.parseDouble(precoStr);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, preço não será alterado.");
            }
        }

        Material novo = new Material();
        novo.setId(id);
        novo.setTipo(tipo.isEmpty() ? null : tipo);
        novo.setDescricao(desc.isEmpty() ? null : desc);
        novo.setPrecoKg(preco);

        control.atualizar(novo);
    }

    private void deletar() {
        System.out.print("Informe o ID do material a excluir: ");
        int id = sc.nextInt();
        control.deletar(id);
    }
}
