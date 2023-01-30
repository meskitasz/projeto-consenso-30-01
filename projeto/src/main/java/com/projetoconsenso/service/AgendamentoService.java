package com.projetoconsenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoconsenso.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Long> {

}
