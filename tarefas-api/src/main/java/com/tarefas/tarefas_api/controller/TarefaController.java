package com.tarefas.tarefas_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.tarefas_api.dto.TarefaDTO;
import com.tarefas.tarefas_api.model.Tarefa;
import com.tarefas.tarefas_api.model.Usuario;
import com.tarefas.tarefas_api.service.TarefaService;
import com.tarefas.tarefas_api.service.UsuarioService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public List<Tarefa> listar(@PathVariable Long usuarioId) {
        return tarefaService.listarPorUsuario(usuarioId);
    }

    @PostMapping("/{usuarioId}")
    public Tarefa criar(@PathVariable Long usuarioId, @RequestBody TarefaDTO dto) {
        Usuario usuario = usuarioService.buscarPorEmail("email@email.com"); // ajustar lógica real
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(dto.isConcluida());
        tarefa.setUsuario(usuario);
        return tarefaService.salvar(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }
}