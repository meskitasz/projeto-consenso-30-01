package com.projetoconsenso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoconsenso.model.Usuario;
import com.projetoconsenso.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public Usuario criarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> obterTodosUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario obterUsuarioPeloId(@PathVariable("id") Long id) {
        return usuarioService.findById(id).get();
    }

    @DeleteMapping("/usuario/{id}")
    public String deletarUsuarioPeloId(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);

        return "Contato deletado com sucesso";
    }

    @PutMapping("/usuario")
    public Usuario atualizarContatos(@RequestBody Usuario usuario) {
        Usuario usuarioBD = usuarioService.findById(usuario.getIdusuario()).get();
        usuarioBD.setNome(usuario.getNome());
        usuarioBD.setSobrenome(usuario.getSobrenome());
        usuarioBD.setEmail(usuario.getEmail());
        usuarioBD.setSenha(usuario.getSenha());
        usuarioBD = usuarioService.save(usuarioBD);
        return usuarioBD;
    }

}
