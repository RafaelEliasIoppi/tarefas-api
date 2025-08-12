package com.tarefas.tarefas_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefas.tarefas_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}