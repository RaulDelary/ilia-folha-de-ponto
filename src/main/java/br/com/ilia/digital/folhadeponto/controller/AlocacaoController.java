package br.com.ilia.digital.folhadeponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <Alocacao> addAlocacao (@RequestBody Alocacao theAlocacao) {
        return new ResponseEntity <Alocacao> (alocacaoService.saveAlocacao (theAlocacao), HttpStatus.CREATED);
    }

    @GetMapping (path = "/alocacoes/{date}")
    public ResponseEntity <List <Alocacao>> getAlocacoesOfDate (@PathVariable String date) {
        return new ResponseEntity <List <Alocacao>> (alocacaoService.getAlocacoesOfDate (date), HttpStatus.OK);
    }
}
