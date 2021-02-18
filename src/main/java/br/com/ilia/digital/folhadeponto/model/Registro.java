package br.com.ilia.digital.folhadeponto.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Registro {
    private String dia;
    
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private List <String> horarios = new ArrayList <String> ();
    
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private List <Alocacao> alocacoes = new ArrayList <Alocacao> ();

    // public Registro () {}

    public Registro (@JsonProperty ("dataHora") String dateTime) {
        String day = LocalDateTime.parse(dateTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String horario = LocalDateTime.parse(dateTime).format(DateTimeFormatter.ofPattern("HH:mm:SS"));

        this.dia = day;
        this.horarios.add (horario);
    }

    // public Registro (@JsonProperty ("name") String dia, String horario) {
    //     this.dia = dia;
    //     this.horarios.add (horario);
    // }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public void addHorario (String horario) {
        this.horarios.add (horario);
    }

    public void addAlocacao (Alocacao alocacao) {
        this.alocacoes.add (alocacao);
    }
    
}
