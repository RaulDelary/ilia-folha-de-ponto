package br.com.ilia.digital.folhadeponto.dao;

import java.util.List;

import br.com.ilia.digital.folhadeponto.model.Alocacao;

public interface AlocacaoDao {

    public Alocacao insertAlocacao (Alocacao theAlocacao);
    public List <Alocacao> getAlocacoesOfDate (String date);
    public List <Alocacao> getAlocacoesOfMonth (String month);

}
