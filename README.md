# Sistema de Gerenciamento de Tarefas (ToDoList) - Java

Este projeto em Java implementa um **sistema de gerenciamento de tarefas (ToDoList)** utilizando **POO** e **CRUD** com armazenamento em memória através de uma `ArrayList`.  

O sistema segue a arquitetura **MVC (Model, Service, View)**:

---

## 📂 Estrutura do Projeto (MVC)

### 1. Model
- **Tarefa.java** → Representa a entidade **Tarefa** com os atributos:
  - `id` → Identificador único  
  - `titulo` → Título da tarefa  
  - `descricao` → Descrição da tarefa  
  - `completa` → Status de conclusão  
  - `dataAgora` → Data e hora de criação  

### 2. Service
- **TarefaServico.java** → Responsável por implementar as operações **CRUD**:
  - Criar tarefa  
  - Listar tarefas  
  - Atualizar tarefa  
  - Remover tarefa  
  - Marcar tarefa como concluída  

### 3. View
- **Main.java** → Interface **CLI (Console)** que permite interação com o usuário:
  - Menu de opções para cadastrar, visualizar, editar, excluir e marcar tarefas como concluídas  

---

## 👥 Integrantes do Grupo (em ordem alfabética)

- **Rafaela**  
- **Rebeca**  
- **Thiago**  
- **Vitorya**  
- **Viviane**  

---