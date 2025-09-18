package ucb.aplicativo.control;

import ucb.aplicativo.model.Tarefas;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefas> tarefas = new ArrayList<>();
    private Long contadorId = 1L;

    // criar tarefa
    public Tarefas criarTarefa(String titulo, String descricao) {

        // construtor da classe tarefa
        Tarefas tarefa = new Tarefas(contadorId++, titulo, descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }

    // listar tarefas
    public List<Tarefas> listarTarefas() {
        return tarefas;
    }

    // atualizar tarefa
    public Tarefas atualizarTarefa(Long id, String novoTitulo, String novaDescricao, Boolean concluido) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                if (novoTitulo != null && !novoTitulo.isBlank()) {
                    tarefa.setTitulo(novoTitulo);
                }
                if (novaDescricao != null && !novaDescricao.isBlank()) {
                    tarefa.setDescricao(novaDescricao);
                }
                if (concluido != null) {
                    tarefa.setCompleta(concluido);
                }
                return tarefa;
            }
        }
        return null;
    }

    // deletar tarefa
    public boolean deletarTarefa(Long id) {
        return tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
    }

}
