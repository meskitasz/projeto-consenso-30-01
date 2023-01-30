package com.projetoconsenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoconsenso.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario, Long> {

}
