package ucb.aplicativo.service;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

  private List<Tarefas> tarefas = new ArrayList <> ();
  private Long contadorId = 1;
  

  public Tarefas criarTarefa(String titulo, String descricao) {
    Tarefas tarefa = new Tarefas (contadorId++, titulo, descricao, false);
    Tarefas.add(tarefa);
    return tarefa;
}
