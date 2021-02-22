package br.com.ilia.digital.folhadeponto.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.model.Registro;

@Repository
public class InMemoryDb implements RegistroDao, AlocacaoDao {

    public static List <Registro> registros = new ArrayList <Registro> ();
    public static List <Alocacao> alocacoes = new ArrayList <Alocacao> ();

    @Override
    public List <Registro> getAllRegistros () {
        return InMemoryDb.registros;
    }

    @Override
    public Optional <Registro> getRegistroByDate (String date) {
        return InMemoryDb.registros.stream ()
                            .filter (reg -> reg.getDia ().equals (date))
                            .findFirst ();
        
    }

    @Override
    public Registro insertRegistro (Registro theRegistro) {
        InMemoryDb.registros.add (theRegistro);
        return theRegistro;
    }

    @Override
    public Registro updateRegistro (Registro theRegistro) {
        Optional <Registro> registro = getRegistroByDate (theRegistro.getDia ());

        if (registro.isEmpty ()) {
            return null;
        }

        InMemoryDb.registros.set (InMemoryDb.registros.indexOf (registro.get ()), theRegistro);

        return registro.get ();
        
    }

    @Override
    public Alocacao insertAlocacao(Alocacao theAlocacao) {
        InMemoryDb.alocacoes.add (theAlocacao);
        return null;
    }

    @Override
    public List<Alocacao> getAlocacoesOfDate(String theDate) {
        return InMemoryDb.alocacoes.stream ()
                                   .filter (aloc -> aloc.getDate ().equals (theDate))
                                   .collect (Collectors.toList ());
    }

    @Override
    public List<Registro> getRegistrosByMonth(String month) {
        return InMemoryDb.registros.stream ()
                                   .filter (reg -> reg.getDia ().substring (0, 7).equals (month))
                                   .collect (Collectors.toList ());

    }

    @Override
    public List<Alocacao> getAlocacoesOfMonth(String month) {
        return InMemoryDb.alocacoes.stream ()
                                   .filter (aloc -> aloc.getDate ().substring (0, 7).equals (month))
                                   .collect (Collectors.toList ());
    }

}
