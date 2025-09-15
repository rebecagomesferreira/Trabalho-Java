package ucb.aplicativo.cli;

import ucb.aplicativo.control.TarefaService;
import java.util.Scanner;

public class ToDoListMain{

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
       
        TarefaService tarefaService = new  TarefaService();

       
        char opcao;

        do {
            // menu
            System.out.println("\n===== MENU =====");
            System.out.print("Digite a opcao desejada: ");
            System.out.println("1 - Criar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Editar Tarefa");
            System.out.println("4 - Excluir Tarefa");

            System.out.println("0 - Sair");
           
            opcao = scan.next().charAt(0);
           
            scan.nextLine(); // limpar o buffer

            switch (opcao) {
               
                }

        } while (opcao != '0');//opcao que encerra o loop
       }
}
