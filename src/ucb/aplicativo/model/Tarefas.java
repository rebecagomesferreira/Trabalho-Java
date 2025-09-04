package ucb.aplicativo.model;

import java.time.LocalDateTime;

public class Tarefas {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataAgora;

    // Construtor padrão
    public Tarefas() {
        this.dataAgora = LocalDateTime.now();
        this.completa = false;
    }

    // Construtor com título
    public Tarefas(String titulo) {
        this();
        this.titulo = titulo;
    }

    // Construtor completo
    public Tarefas(Long id, String titulo, String descricao) {
        this();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getDataAgora() {
        return dataAgora;
    }

    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }

    @Override
    public String toString() {
        return "Tarefas {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", completa=" + completa +
                ", dataAgora=" + dataAgora +
                '}';
    }
}
