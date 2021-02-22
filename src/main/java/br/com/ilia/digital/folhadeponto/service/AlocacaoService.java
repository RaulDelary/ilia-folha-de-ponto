package br.com.ilia.digital.folhadeponto.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilia.digital.folhadeponto.dao.AlocacaoDao;
import br.com.ilia.digital.folhadeponto.exception.TimeRangeException;
import br.com.ilia.digital.folhadeponto.exception.TimesNotRegisteredException;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.model.Registro;

@Service
public class AlocacaoService {
    private final RegistroService registroService;
    private final AlocacaoDao alocacaoDao;

    @Autowired
    public AlocacaoService (RegistroService registroService, AlocacaoDao alocacaoDao) {
        this.registroService = registroService;
        this.alocacaoDao = alocacaoDao;
    }

    public Alocacao saveAlocacao (Alocacao theAlocacao) {
        // Haverá exception se não encontrar o registro com a data informada
        Registro registro = registroService.getRegistroByDate (theAlocacao.getDate ());
        long firstPeriod = 0L;
        long secondPeriod = 0L;

        if (registro.getHorarios ().size () == 4) {

            firstPeriod = LocalTime.parse (registro.getHorarios ().get (1)).getLong (ChronoField.SECOND_OF_DAY) - 
                          LocalTime.parse (registro.getHorarios ().get (0)).getLong (ChronoField.SECOND_OF_DAY);

            secondPeriod = LocalTime.parse (registro.getHorarios ().get (3)).getLong (ChronoField.SECOND_OF_DAY) - 
                           LocalTime.parse (registro.getHorarios ().get (2)).getLong (ChronoField.SECOND_OF_DAY);

        } else if (registro.getHorarios ().size () >= 2) {
            
            firstPeriod = LocalTime.parse (registro.getHorarios ().get (1)).getLong (ChronoField.SECOND_OF_DAY) - 
                          LocalTime.parse (registro.getHorarios ().get (0)).getLong (ChronoField.SECOND_OF_DAY);
            
        } else {

            throw new TimesNotRegisteredException("Os horários desta data ainda não foram todos cadastrados cadastrados.");
        }

        Duration totalWorkedTime = Duration.ofSeconds(firstPeriod + secondPeriod);

        if (alocacaoDao.getAlocacoesOfDate (theAlocacao.getDate ()).isEmpty ()) {
            if (totalWorkedTime.compareTo (theAlocacao.getTempo ()) >= 0) {
                alocacaoDao.insertAlocacao (theAlocacao);
            } else {
                throw new TimeRangeException ("Não é possível alocar tempo maior que o total trabalhado no dia.");
            }
        } else {
            Duration totalAllocatedTime = theAlocacao.getTempo ();

            for (Alocacao alocacao : alocacaoDao.getAlocacoesOfDate (theAlocacao.getDate ())) {
                totalAllocatedTime = totalAllocatedTime.plus (alocacao.getTempo ());
            }

            if (totalWorkedTime.compareTo (totalAllocatedTime) >= 0) {
                alocacaoDao.insertAlocacao(theAlocacao);
            } else {
                throw new TimeRangeException ("Não há mais tempo disponível para efetuar esta alocação.");
            }
        }

        return theAlocacao;
    }


    public List <Alocacao> getAlocacoesOfDate (String date) {
        return alocacaoDao.getAlocacoesOfDate (date);
    }
}
