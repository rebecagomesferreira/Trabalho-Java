package view;

import control.FornecedorController;
import model.Fornecedor;
import java.util.Scanner;

public class FornecedorView {
    private FornecedorController control = new FornecedorController();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU FORNECEDOR ---");
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
        System.out.print("CPF/CNPJ: ");
        String cpf = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Tipo (Empresa/Pessoa Física): ");
        String tipo = sc.nextLine();
        control.cadastrar(new Fornecedor(cpf, nome, tel, tipo));
    }

    private void listar() {
        control.listar().forEach(System.out::println);
    }

    private void atualizar() {
        System.out.print("Informe o ID do fornecedor: ");
        int id = sc.nextInt(); sc.nextLine();

        Fornecedor atual = control.buscarPorId(id);
        if (atual == null) {
            System.out.println("Fornecedor não encontrado!");
            return;
        }

        System.out.println("\n--- Dados atuais ---");
        System.out.println(atual);

        System.out.println("\n--- Digite novos valores (ou pressione ENTER para manter) ---");
        System.out.print("Novo CPF/CNPJ (" + atual.getCpfCnpj() + "): ");
        String cpf = sc.nextLine();
        System.out.print("Novo Nome (" + atual.getNome() + "): ");
        String nome = sc.nextLine();
        System.out.print("Novo Telefone (" + atual.getTelefone() + "): ");
        String tel = sc.nextLine();
        System.out.print("Novo Tipo (" + atual.getTipo() + "): ");
        String tipo = sc.nextLine();

        Fornecedor novo = new Fornecedor();
        novo.setId(id);
        novo.setCpfCnpj(cpf.isEmpty() ? null : cpf);
        novo.setNome(nome.isEmpty() ? null : nome);
        novo.setTelefone(tel.isEmpty() ? null : tel);
        novo.setTipo(tipo.isEmpty() ? null : tipo);

        control.atualizar(novo);
    }

    private void deletar() {
        System.out.print("Informe o ID do fornecedor para excluir: ");
        int id = sc.nextInt();
        control.deletar(id);
    }
}
