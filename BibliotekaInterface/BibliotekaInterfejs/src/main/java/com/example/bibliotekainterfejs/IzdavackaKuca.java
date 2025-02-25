package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class IzdavackaKuca {
    private SimpleIntegerProperty izdavackaKucaID;
    private SimpleStringProperty nazivIzdavackeKuce;
    private SimpleStringProperty idGrada;

    public IzdavackaKuca(Integer izdavackaKucaID, String nazivIzdavackeKuce, String idGrada) {
        this.izdavackaKucaID = new SimpleIntegerProperty(izdavackaKucaID);
        this.nazivIzdavackeKuce = new SimpleStringProperty(nazivIzdavackeKuce);
        this.idGrada = new SimpleStringProperty(idGrada);
    }
    public SimpleIntegerProperty izdavackaKucaIDProperty() {
        return izdavackaKucaID;
    }
    public SimpleStringProperty nazivIzdavackeKuceProperty() {
        return nazivIzdavackeKuce;
    }
    public SimpleStringProperty idGradaProperty2() {
        return idGrada;
    }

    @Override
    public String toString() {
        return '{' +
                "izdavacka_kuca_id:" + izdavackaKucaID.getValue() + "," +
                "naziv_izdavacke_kuce:" + nazivIzdavackeKuce.getValue() + "," +
                "id_grada:" + idGrada.getValue() +
                '}';
    }
}
