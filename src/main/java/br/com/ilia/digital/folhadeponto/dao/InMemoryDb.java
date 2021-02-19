package br.com.ilia.digital.folhadeponto.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ilia.digital.folhadeponto.model.Registro;

@Repository
public class InMemoryDb implements RegistroDao {

    public static List <Registro> db = new ArrayList <Registro> ();

    @Override
    public List <Registro> getAllRegistros () {
        return InMemoryDb.db;
    }

    @Override
    public Optional <Registro> getRegistroByDate (String date) {
        return InMemoryDb.db.stream ()
                            .filter (reg -> reg.getDia ().equals (date))
                            .findFirst ();
        
    }

    @Override
    public Registro insertRegistro (Registro theRegistro) {
        InMemoryDb.db.add (theRegistro);
        return theRegistro;
    }

    @Override
    public Registro updateRegistro (Registro theRegistro) {
        Optional <Registro> registro = getRegistroByDate (theRegistro.getDia ());

        if (registro.isEmpty ()) {
            return null;
        }

        InMemoryDb.db.set (InMemoryDb.db.indexOf (registro.get ()), theRegistro);

        return registro.get ();
        
    }

    public static List<Registro> getDb () {
        return db;
    }

    public static void setDb (List <Registro> db) {
        InMemoryDb.db = db;
    }
}
