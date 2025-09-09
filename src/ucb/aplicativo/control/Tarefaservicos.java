package ucb.aplicativo.service;

import ucb.aplicativo.model.Tarefas;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

  private List<Tarefas> tarefas = new ArrayList <> ();
  private Long contadorId = 1L;
  
  //criar tarefa
  public Tarefas criarTarefa(String titulo, String descricao) {

    //construtor da classe tarefa
    Tarefas tarefa = new Tarefas (contadorId++, titulo, descricao, false);
    tarefas.add(tarefa);
    return tarefa;
}

  //listar tarefas
  public List<Tarefas> listarTarefas() {
  
    return tarefas;
}
}
