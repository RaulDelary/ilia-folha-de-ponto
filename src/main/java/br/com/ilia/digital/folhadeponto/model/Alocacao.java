package br.com.ilia.digital.folhadeponto.model;

import java.time.Duration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alocacao {

    @NotBlank
    @NotEmpty
    private String date;

    @NotBlank
    @NotEmpty
    private Duration tempo;

    @NotBlank
    @NotEmpty
    private String nomeProjeto;

    public Alocacao () {}

    public Alocacao (@JsonProperty ("dia") String date,
                     @JsonProperty ("tempo") String tempo,
                     @JsonProperty ("nomeProjeto") String nomeProjeto)
    {

        this.date = date;
        this.tempo = Duration.parse(tempo);
        this.nomeProjeto = nomeProjeto;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public Duration getTempo () {
        return tempo;
    }

    public void setTempo (String tempo) {
        this.tempo = Duration.parse(tempo);
    }

    public String getNomeProjeto () {
        return nomeProjeto;
    }

    public void setNomeProjeto (String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

}
