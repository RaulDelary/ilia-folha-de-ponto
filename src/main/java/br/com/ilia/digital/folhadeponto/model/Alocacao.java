package br.com.ilia.digital.folhadeponto.model;

public class Alocacao {
    private String date;
    private String tempo;
    private String nomeProjeto;

    public Alocacao () {}

    public Alocacao (String date, String tempo, String nomeProjeto) {
        this.date = date;
        this.tempo = tempo;
        this.nomeProjeto = nomeProjeto;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getTempo () {
        return tempo;
    }

    public void setTempo (String tempo) {
        this.tempo = tempo;
    }

    public String getNomeProjeto () {
        return nomeProjeto;
    }

    public void setNomeProjeto (String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

}
