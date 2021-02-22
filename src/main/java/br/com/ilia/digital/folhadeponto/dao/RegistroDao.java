package br.com.ilia.digital.folhadeponto.dao;

import java.util.List;
import java.util.Optional;

import br.com.ilia.digital.folhadeponto.model.Registro;

public interface RegistroDao {
    
    public Registro insertRegistro (Registro theRegistro);
    public Optional <Registro> getRegistroByDate (String date);
    public List <Registro> getRegistrosByMonth (String month);
    public List <Registro> getAllRegistros ();
    public Registro updateRegistro (Registro theRegistro);
}
