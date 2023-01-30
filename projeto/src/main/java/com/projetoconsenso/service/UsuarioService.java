package com.projetoconsenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoconsenso.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Long> {

}
