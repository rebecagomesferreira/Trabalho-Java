package ucb.aplicativo.cli;

import ucb.aplicativo.control.TarefaService;
import java.util.Scanner;
import ucb.aplicativo.model.Tarefas;

public class AppToDoList {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TarefaService tarefaService = new TarefaService();

        char opcao;

        do {
            // Menu
            System.out.println("\n===== MENU =====");
            System.out.print("Digite a opcao desejada: ");
            System.out.println("\n1 - Criar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Editar Tarefa");
            System.out.println("4 - Excluir Tarefa");

            System.out.println("0 - Sair");

            opcao = scan.next().charAt(0);

            scan.nextLine(); // limpar o buffer

            switch (opcao) {
                case '1':
                    System.out.print("Titulo: ");  // caso o usuário escolha a opção 1 ele deve digitar o título
                    String titulo = scan.nextLine();
                    System.out.print("Descricao: "); // descrição
                    String descricao = scan.nextLine();

                    // Criar a tarefa e capturar o objeto retornado
                    Tarefas tarefaCriada = tarefaService.criarTarefa(titulo, descricao);

                    // Imprimir o ID da tarefa antes de confirmar a criação
                    System.out.println("Tarefa criada com sucesso! ID da tarefa: " + tarefaCriada.getId());
                    break;

                case '2':
                    System.out.println("Lista de tarefas: "); // lista as tarefas
                    for (Tarefas t : tarefaService.listarTarefas()) {
                        System.out.println(t); // imprime a tarefa
                    }
                    break;

                case '3':
                    System.out.print("Digite o ID da tarefa: "); // edição da tarefa pelo id
                    Long idAtualizar = scan.nextLong();
                    scan.nextLine();
                    System.out.print("Novo titulo (ou deixe vazio): ");
                    String novoTitulo = scan.nextLine();
                    System.out.print("Nova descricao (ou deixe vazio): ");
                    String novaDescricao = scan.nextLine();
                    System.out.print("Esta concluída? (true/false ou deixe vazio): ");
                    String concluidaStr = scan.nextLine();
                    Boolean concluida = concluidaStr.isBlank() ? null : Boolean.parseBoolean(concluidaStr);
                    tarefaService.atualizarTarefa(idAtualizar, novoTitulo, novaDescricao, concluida);
                    System.out.println("Tarefa atualizada!");
                    break;

                case '4':
                    System.out.print("Digite o ID da tarefa para excluir: "); // exclui a tarefa pelo id
                    Long idExcluir = scan.nextLong();
                    scan.nextLine();
                    if (tarefaService.deletarTarefa(idExcluir)) {
                        System.out.println("Tarefa removida!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case '0':
                    System.out.println("Até a próxima!");
                    break;

                default:
                    System.out.println("Opção inválida!"); // caso nenhuma das opções sejam válidas
            }

        } while (opcao != '0'); // opção que encerra o loop
    }
}
