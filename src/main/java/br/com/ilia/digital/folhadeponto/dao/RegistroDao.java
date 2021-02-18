package br.com.ilia.digital.folhadeponto.dao;

import java.util.List;

import br.com.ilia.digital.folhadeponto.model.Registro;

public interface RegistroDao {
    
    public Registro insertRegistro (Registro theRegistro);
    public Registro getRegistroByMonth (String month);
    public List <Registro> getAllRegistros ();
}
