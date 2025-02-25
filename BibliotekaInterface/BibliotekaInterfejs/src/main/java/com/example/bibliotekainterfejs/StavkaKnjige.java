package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StavkaKnjige {
    private SimpleIntegerProperty stavkaKnjigeID;
    private SimpleStringProperty isbn;
    private SimpleStringProperty idBiblioteke;

    public StavkaKnjige(Integer stavkaKnjigeID, String isbn, String idBiblioteke){
        this.stavkaKnjigeID = new SimpleIntegerProperty(stavkaKnjigeID);
        this.isbn = new SimpleStringProperty(isbn);
        this.idBiblioteke = new SimpleStringProperty(idBiblioteke);
    }

    public SimpleIntegerProperty stavkaKnjigeIDProperty() {
        return stavkaKnjigeID;
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public SimpleStringProperty idBibliotekeProperty() {
        return idBiblioteke;
    }

    @Override
    public String toString() {
        return '{' +
                "id_stavka_knjiga:" + stavkaKnjigeID.getValue() + "," +
                "isbn:" + isbn.getValue() + "," +
                "id_biblioteke:" + idBiblioteke.getValue() +
                '}';
    }
}
