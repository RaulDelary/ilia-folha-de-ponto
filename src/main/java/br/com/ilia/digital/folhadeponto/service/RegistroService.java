package br.com.ilia.digital.folhadeponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilia.digital.folhadeponto.dao.RegistroDao;
import br.com.ilia.digital.folhadeponto.exception.AllTimesRegisteredException;
import br.com.ilia.digital.folhadeponto.exception.NotFoundException;
import br.com.ilia.digital.folhadeponto.exception.TimeAlreadyRegisteredException;
import br.com.ilia.digital.folhadeponto.model.Registro;

@Service
public class RegistroService {
    private final RegistroDao registroDao;

    @Autowired
    public RegistroService (RegistroDao registroDao) {
        this.registroDao = registroDao;
    }
    
    public Registro saveRegistro (Registro theRegistro) {
        Optional <Registro> registro = registroDao.getRegistroByDate (theRegistro.getDia ());

        if (registro.isPresent ()) {
            if (registro.get ().getHorarios ().size () < 4 ) {
                if (!registro.get ().getHorarios ().contains (theRegistro.getHorarios ().get (0))) {
                    
                    registro.get ().addHorario(theRegistro.getHorarios ().get (0));
                    return registro.get ();

                } else {
                    throw new TimeAlreadyRegisteredException ("Este horário já está cadastrado para esta data.");
                }
            } else {
                throw new AllTimesRegisteredException ("Todos os horários para esta data já foram cadastrados");
            }
        }

        return registroDao.insertRegistro (theRegistro);
    }

    public Registro getRegistroByDate (String theDate) {
        Optional <Registro> registro = registroDao.getRegistroByDate (theDate);

        if (registro.isEmpty ()) {
            throw new NotFoundException ("Registro não encontrado");
        }

        return registro.get ();
    }

    public List <Registro> getAllRegistros () {
        List <Registro> registros = registroDao.getAllRegistros ();
        
        if (registros.isEmpty ()) {
            throw new NotFoundException ("Não há registros cadastrados");
        }

        return registros;
    }

    public Registro updateRegistro (Registro theRegistro) {
        return null;
    }
}
