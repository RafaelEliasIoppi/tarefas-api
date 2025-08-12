package com.tarefas.tarefas_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefas.tarefas_api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUsuarioId(Long usuarioId);
}