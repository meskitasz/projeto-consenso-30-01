package com.projetoconsenso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoconsenso.model.Servico;
import com.projetoconsenso.service.ServicoService;

@RestController
@CrossOrigin(origins = "*")
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @PostMapping("/servico")
    public Servico criarNovoServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @GetMapping("/servico")
    public List<Servico> obterTodosServico() {
        return servicoService.findAll();
    }

    @GetMapping("/servico/{id}")
    public Servico obterServicoPeloId(@PathVariable("id") Long id) {
        return servicoService.findById(id).get();
    }

    @DeleteMapping("/servico/{id}")
    public String deletarServicoPeloId(@PathVariable("id") Long id) {
        servicoService.deleteById(id);

        return "Serviço deletado com sucesso";
    }

    @PutMapping("/servico")
    public Servico atualizarServico(@RequestBody Servico servico) {
        Servico servicoDB = servicoService.findById(servico.getIdservico()).get();
        servicoDB.setDescricao(servico.getDescricao());
        servicoDB.setNome(servico.getNome());
        servicoDB = servicoService.save(servicoDB);
        return servicoDB;
    }

}
