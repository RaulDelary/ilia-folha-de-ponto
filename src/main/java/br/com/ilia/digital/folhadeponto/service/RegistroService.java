package br.com.ilia.digital.folhadeponto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.ilia.digital.folhadeponto.dao.RegistroDao;
import br.com.ilia.digital.folhadeponto.model.Registro;

@Service
public class RegistroService {
    private final RegistroDao registroDao;

    @Autowired
    public RegistroService (RegistroDao registroDao) {
        this.registroDao = registroDao;
    }
    
    public Registro saveRegistro (Registro theRegistro) {
        return registroDao.insertRegistro(theRegistro);
    }

    public Registro getRegistroByMonth (String theMonth) {
        return registroDao.getRegistroByMonth(theMonth);
    }

    public List <Registro> getAllRegistros () {
        return registroDao.getAllRegistros();
    }
}
