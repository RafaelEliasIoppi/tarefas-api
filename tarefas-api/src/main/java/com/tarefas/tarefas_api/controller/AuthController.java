package com.tarefas.tarefas_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.tarefas_api.dto.LoginDTO;
import com.tarefas.tarefas_api.dto.UsuarioDTO;
import com.tarefas.tarefas_api.model.Usuario;
import com.tarefas.tarefas_api.security.JwtUtil;
import com.tarefas.tarefas_api.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String registrar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuarioService.salvar(usuario);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        Usuario usuario = usuarioService.buscarPorEmail(dto.getEmail());
        if (usuario != null && jwtUtil.validarSenha(dto.getSenha(), usuario.getSenha())) {
            return jwtUtil.gerarToken(usuario);
        }
        return "Credenciais inválidas";
    }
    @GetMapping("/ping")
        public String ping() {
            return "pong";
}
}