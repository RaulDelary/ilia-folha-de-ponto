package br.com.ilia.digital.folhadeponto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Registro addRegistro (@RequestBody Registro theRegistro) {
        return registroService.saveRegistro (theRegistro);
    }

    @GetMapping (path = "/batidas")
    public List<Registro> getRegistros () {
        return registroService.getAllRegistros ();
    }

    @GetMapping (path = "/batida/{data}")
    public Registro getRegistroBydDate (@PathVariable String date) {
       return registroService.getRegistroByDate (date);
    }
}
