package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Grad {
    private SimpleIntegerProperty id_grada;
    private SimpleStringProperty nazivGrada;
    private SimpleStringProperty postanskiBroj;
    private SimpleStringProperty idDrzave;

    private int idGrada;
    private String nazivGrada2;
    private String postanskiBroj2;

    private Drzava drzava;

    public Grad(Integer idGrada){
        this.id_grada = new SimpleIntegerProperty(idGrada);
    }
    public Grad(Integer idGrada, String nazivGrada, String postanskiBroj, String idDrzave){
        this.id_grada = new SimpleIntegerProperty(idGrada);
        this.nazivGrada = new SimpleStringProperty(nazivGrada);
        this.postanskiBroj = new SimpleStringProperty(postanskiBroj);
        this.idDrzave = new SimpleStringProperty(idDrzave);
    }
    public Grad(int idGrada, String nazivGrada, String postanskiBroj, Drzava drzava){
        this.idGrada = idGrada;
        this.nazivGrada2 = nazivGrada;
        this.postanskiBroj2 = postanskiBroj;
        this.drzava = drzava;
    }
    public int getIDGrada(){
        return idGrada;
    }
    public String getNazivGrada2(){
        return nazivGrada2;
    }
    public String getPostanskiBroj2(){
        return postanskiBroj2;
    }
    public Drzava getDrzava(){
        return drzava;
    }
    public SimpleIntegerProperty idGradaProperty(){
        return id_grada;
    }
    public SimpleStringProperty nazivGradaProperty(){
        return nazivGrada;
    }
    public SimpleStringProperty postanskiBrojProperty(){
        return postanskiBroj;
    }
    public SimpleStringProperty idDrzaveProperty(){
        return idDrzave;
    }

    @Override
    public String toString() {
        return '{' +
                "id_grada:" + id_grada.getValue() + "," +
                "naziv_grada:" + nazivGrada.getValue() + "," +
                "postanski_broj:" + postanskiBroj.getValue() + "," +
                "id_drzave:" + idDrzave.getValue() +
                '}';
    }
}
