package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Biblioteka {
    private SimpleIntegerProperty idBiblioteke;
    private SimpleStringProperty nazivBiblioteke;
    private SimpleStringProperty adresaBiblioteke;
    private SimpleIntegerProperty id_grada;

    public Biblioteka(Integer idBiblioteke, String nazivBiblioteke, String adresaBiblioteke, int idGradaBiblioteka){
        this.idBiblioteke = new SimpleIntegerProperty(idBiblioteke);
        this.nazivBiblioteke = new SimpleStringProperty(nazivBiblioteke);
        this.adresaBiblioteke = new SimpleStringProperty(adresaBiblioteke);
        this.id_grada = new SimpleIntegerProperty(idGradaBiblioteka);
    }
    public SimpleIntegerProperty idBibliotekeProperty(){
        return idBiblioteke;
    }
    public SimpleStringProperty nazivBibliotekeProperty(){
        return nazivBiblioteke;
    }
    public SimpleStringProperty adresaBibliotekeProperty(){
        return adresaBiblioteke;
    }
    public SimpleIntegerProperty idGradaBibliotekaProperty(){
        return id_grada;
    }

    @Override
    public String toString() {
        return '{' +
                "id_biblioteke:" + idBiblioteke.getValue() + "," +
                "naziv_biblioteke:" + nazivBiblioteke.getValue() + "," +
                "adresa_biblioteke:" + adresaBiblioteke.getValue() + "," +
                "id_grada:" + id_grada.getValue() +
                '}';
    }
}
