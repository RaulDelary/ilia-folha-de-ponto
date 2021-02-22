package br.com.ilia.digital.folhadeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.service.AlocacaoService;

@RestController
@RequestMapping ("/v1")
public class AlocacaoController {
    private final AlocacaoService alocacaoService;

    @Autowired
    public AlocacaoController (AlocacaoService alocacaoService) {
        this.alocacaoService = alocacaoService;
    }

    @PostMapping (path = "/alocacao")
    public Alocacao addAlocacao (@RequestBody Alocacao theAlocacao) {
        return alocacaoService.saveAlocacao(theAlocacao);
    }

    @GetMapping (path = "/alocacoes/{date}")
    public List <Alocacao> getAlocacoesOfDate (@PathVariable String date) {
        return alocacaoService.getAlocacoesOfDate (date);
    }
}
