package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Kategorija {
    private SimpleIntegerProperty idKategorije;
    private SimpleStringProperty nazivKategorije;

    public Kategorija(int idKategorije, String nazivKategorije) {
        this.idKategorije = new SimpleIntegerProperty(idKategorije);
        this.nazivKategorije = new SimpleStringProperty(nazivKategorije);
    }
    public SimpleIntegerProperty idKategorijeProperty() {
        return idKategorije;
    }
    public SimpleStringProperty nazivKategorijeProperty() {
        return nazivKategorije;
    }
}
