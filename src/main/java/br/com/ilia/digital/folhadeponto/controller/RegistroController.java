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

import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.service.RegistroService;

@RestController
@RequestMapping ("/v1")
public class RegistroController {
    private final RegistroService registroService;

    @Autowired
    public RegistroController (RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping (path = "/batida")
    public ResponseEntity <Registro> addRegistro (@RequestBody Registro theRegistro) {
        
        return new ResponseEntity <Registro> (registroService.saveRegistro (theRegistro), HttpStatus.CREATED);
    }

    @GetMapping (path = "/batidas")
    public ResponseEntity <List <Registro>> getRegistros () {
        return new ResponseEntity <List <Registro>> (registroService.getAllRegistros (), HttpStatus.OK);
    }

    @GetMapping (path = "/batida/{date}")
    public ResponseEntity <Registro> getRegistroBydDate (@PathVariable String date) {
       return new ResponseEntity <Registro> (registroService.getRegistroByDate (date), HttpStatus.OK);
    }

}
