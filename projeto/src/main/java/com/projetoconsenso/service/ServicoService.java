package com.projetoconsenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoconsenso.model.Servico;

public interface ServicoService extends JpaRepository<Servico, Long> {

}
