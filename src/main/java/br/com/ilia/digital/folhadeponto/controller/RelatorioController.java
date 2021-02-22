package br.com.ilia.digital.folhadeponto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ilia.digital.folhadeponto.model.FolhaDePonto;
import br.com.ilia.digital.folhadeponto.service.FolhaDePontoService;

@RestController
@RequestMapping ("/v1")
public class RelatorioController {
    private final FolhaDePontoService folhaDePontoService;

    @Autowired
    public RelatorioController (FolhaDePontoService folhaDePontoService) {
        this.folhaDePontoService = folhaDePontoService;
    }

    @GetMapping (path = "/folha-de-ponto/{mes}")
    public ResponseEntity <FolhaDePonto> getReltorioByMonth (@PathVariable ("mes") String month) {
        return new ResponseEntity <FolhaDePonto> (folhaDePontoService.getRelatorioByMonth (month), HttpStatus.OK);
    }
}
