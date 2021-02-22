package br.com.ilia.digital.folhadeponto.model;

import java.time.Duration;
import java.util.List;


public class FolhaDePonto {
    
    private String mes;
    private Duration horasTrabalhadas;
    private Duration horasExcedentes;
    private Duration horasDevidas;

    private List <Registro> registros;
    private List <Alocacao> alocacoes;

    public FolhaDePonto (String mes,
                         Duration horasTrabalhadas, 
                         Duration horasExcedentes, 
                         Duration horasDevidas,
                         List <Registro> registros,
                         List <Alocacao> alocacoes) 
    {
        this.mes = mes;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExcedentes = horasExcedentes;
        this.horasDevidas = horasDevidas;
        this.registros = registros;
        this.alocacoes = alocacoes;
    }


	public String getMes () {
        return mes;
    }

    public void setMes (String mes) {
        this.mes = mes;
    }

    public Duration getHorasTrabalhadas () {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas (Duration horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Duration getHorasExcedentes () {
        return horasExcedentes;
    }

    public void setHorasExcedentes (Duration horasExcedentes) {
        this.horasExcedentes = horasExcedentes;
    }

    public Duration getHorasDevidas () {
        return horasDevidas;
    }

    public void setHorasDevidas (Duration horasDevidas) {
        this.horasDevidas = horasDevidas;
    }

    public List <Registro> getRegistros () {
        return registros;
    }

    public List <Alocacao> getAlocacoes () {
        return alocacoes;
    }

}
