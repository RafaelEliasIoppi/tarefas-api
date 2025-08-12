package com.tarefas.tarefas_api.dto;

public class TarefaDTO {
    private String titulo;
    private String descricao;
    private boolean concluida;

    // Getters e setters
    public String getTitulo() {
        return titulo;
    }       

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}