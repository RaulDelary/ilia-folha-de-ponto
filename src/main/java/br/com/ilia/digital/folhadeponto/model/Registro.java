package br.com.ilia.digital.folhadeponto.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registro {
    private String dia;
    
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private List <String> horarios = new ArrayList <String> ();

    public Registro () {}

    public Registro (@JsonProperty ("dataHora") String dateTime) {
        String day = LocalDateTime.parse (dateTime).format (DateTimeFormatter.ofPattern ("yyyy-MM-dd"));
        String horario = LocalDateTime.parse (dateTime).format (DateTimeFormatter.ofPattern ("HH:mm:ss"));

        this.dia = day;
        this.horarios.add (horario);
    }

    public Registro (@JsonProperty ("dataHora") String dia, String horario) {
        this.dia = dia;
        this.horarios.add (horario);
    }

    public String getDia () {
        return dia;
    }

    public void setDia (String dia) {
        this.dia = dia;
    }

    public List <String> getHorarios () {
        return horarios;
    }

    public void setHorarios (List <String> horarios) {
        this.horarios = horarios;
    }

    public void addHorario (String horario) {
        this.horarios.add (horario);
        Collections.sort(this.horarios);
    }
    
}
