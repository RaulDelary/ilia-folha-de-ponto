package br.com.ilia.digital.folhadeponto.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.ilia.digital.folhadeponto.model.Registro;

@Repository
public class InMemoryDb implements RegistroDao {

    public static List <Registro> db = new ArrayList <Registro> ();

    @Override
    public List<Registro> getAllRegistros() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Registro getRegistroByMonth(String month) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Registro insertRegistro(Registro theRegistro) {
        InMemoryDb.db.add(theRegistro);
        return theRegistro;
    }

    public static List<Registro> getDb() {
        return db;
    }

    public static void setDb(List<Registro> db) {
        InMemoryDb.db = db;
    }
    
    
}
