package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Drzava {
    private SimpleIntegerProperty idDrzave;
    private SimpleStringProperty nazivDrzave;

    public Drzava(int idDrzave, String nazivDrzave) {
        this.idDrzave = new SimpleIntegerProperty(idDrzave);
        this.nazivDrzave = new SimpleStringProperty(nazivDrzave);
    }
    public SimpleIntegerProperty idDrzaveProperty2() {
        return idDrzave;
    }
    public SimpleStringProperty  nazivDrzaveProperty() {
        return nazivDrzave;
    }

    @Override
    public String toString() {
        return '{' +
                "id_drzave:" + idDrzave.getValue() + "," +
                "naziv_drzave:" + nazivDrzave.getValue() +
                '}';
    }
}
