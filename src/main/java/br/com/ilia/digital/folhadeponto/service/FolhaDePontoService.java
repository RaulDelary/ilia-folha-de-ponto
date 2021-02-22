package br.com.ilia.digital.folhadeponto.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilia.digital.folhadeponto.dao.AlocacaoDao;
import br.com.ilia.digital.folhadeponto.dao.RegistroDao;
import br.com.ilia.digital.folhadeponto.exception.NotFoundException;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.model.FolhaDePonto;
import br.com.ilia.digital.folhadeponto.model.Registro;

@Service
public class FolhaDePontoService {
    private final AlocacaoDao alocacaoDao;
    private final RegistroDao registroDao;

    @Autowired
    public FolhaDePontoService (AlocacaoDao alocacaoDao, RegistroDao registroDao) {
        this.alocacaoDao = alocacaoDao;
        this.registroDao = registroDao;
    }

    public FolhaDePonto getRelatorioByMonth (String month) {
        List <Registro> registros = registroDao.getRegistrosByMonth (month);
        List <Alocacao> alocacoes = alocacaoDao.getAlocacoesOfMonth (month);
        Duration horasTrabalhadas = Duration.ZERO;
        Duration horasDevidas = Duration.ZERO;
        Duration horasExcedentes = Duration.ZERO;

        if (registros.isEmpty ()) {
            throw new NotFoundException ("Não há registros para este mês.");
        } else {
            horasTrabalhadas = Duration.ZERO;
            long firstPeriod = 0L;
            long secondPeriod = 0L;

            for (Registro registro : registros) {
                if (registro.getHorarios ().size () == 4) {
                    
                    firstPeriod = LocalTime.parse (registro.getHorarios ().get (1)).getLong (ChronoField.SECOND_OF_DAY) - 
                                  LocalTime.parse (registro.getHorarios ().get (0)).getLong (ChronoField.SECOND_OF_DAY);

                    secondPeriod = LocalTime.parse (registro.getHorarios ().get (3)).getLong (ChronoField.SECOND_OF_DAY) - 
                                   LocalTime.parse (registro.getHorarios ().get (2)).getLong (ChronoField.SECOND_OF_DAY);                   
                    
                } else if (registro.getHorarios ().size () >= 2) {
                    firstPeriod = LocalTime.parse (registro.getHorarios ().get (1)).getLong (ChronoField.SECOND_OF_DAY) - 
                                   LocalTime.parse (registro.getHorarios ().get (0)).getLong (ChronoField.SECOND_OF_DAY);
                }

                horasTrabalhadas = horasTrabalhadas.plus (Duration.ofSeconds (firstPeriod + secondPeriod));
            }

            if (horasTrabalhadas.minus (Duration.parse ("PT220H")).isNegative ()) {

                horasDevidas = horasTrabalhadas.minus (Duration.parse ("PT220H")).abs ();

            } else if (!horasTrabalhadas.minus (Duration.parse ("PT220H")).isZero ()) {
                
                horasExcedentes = horasTrabalhadas.minus (Duration.parse ("PT220H"));
            }
        }

        return new FolhaDePonto(month, horasTrabalhadas, horasExcedentes, horasDevidas, registros, alocacoes);
    }


}
