package com.example.bibliotekainterfejs;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

import java.util.List;

public class Knjiga {
    private SimpleIntegerProperty isbn;
    private SimpleStringProperty nazivKnjige;
    //private SimpleStringProperty idKategorije;
    private SimpleIntegerProperty idKategorije2;
    private SimpleIntegerProperty godinaIzdavanja;
    //private SimpleStringProperty izdavackaKucaID;
    //private SimpleStringProperty izdavackaKucaID2;
    private SimpleIntegerProperty izdavackaKucaID;
    //private SimpleStringProperty izdavackaKucaID2;
    private SimpleIntegerProperty izdavackaKucaID2;
    private SimpleStringProperty autorID;
    private SimpleStringProperty autorID2;
    private SimpleStringProperty sviAutori;
    private SimpleIntegerProperty idKategorije;
    //private SimpleListProperty<Autor> autori;
    //private ListProperty<String> sviAutori;

    public Knjiga(Integer isbn, String nazivKnjige, Integer idKategorije, Integer godinaIzdavanja, Integer izdavackaKucaID, String sviAutori){
        this.isbn = new SimpleIntegerProperty(isbn);
        this.nazivKnjige = new SimpleStringProperty(nazivKnjige);
        this.idKategorije = new SimpleIntegerProperty(idKategorije);
        this.godinaIzdavanja = new SimpleIntegerProperty(godinaIzdavanja);
        this.izdavackaKucaID2 = new SimpleIntegerProperty(izdavackaKucaID);
        this.sviAutori = new SimpleStringProperty(sviAutori);
        //this.autorID = new SimpleStringProperty(idAutoraKnjiga);
    }
    /*public Knjiga(Integer isbn, String nazivKnjige, Integer idKategorije2, Integer godinaIzdavanja, Integer izdavackaKucaID2, List<Autor> allAutori){
        this.isbn = new SimpleIntegerProperty(isbn);
        this.nazivKnjige = new SimpleStringProperty(nazivKnjige);
        this.idKategorije2 = new SimpleIntegerProperty(idKategorije2);
        this.godinaIzdavanja = new SimpleIntegerProperty(godinaIzdavanja);
        this.izdavackaKucaID2 = new SimpleIntegerProperty(izdavackaKucaID2);
        this.autori = new SimpleListProperty<>(allAutori);
    }*/
    /*public Knjiga(Integer isbn, String nazivKnjige, Integer idKategorije2, Integer godinaIzdavanja, Integer izdavackaKucaID2){
        this.isbn = new SimpleIntegerProperty(isbn);
        this.nazivKnjige = new SimpleStringProperty(nazivKnjige);
        this.idKategorije2 = new SimpleIntegerProperty(idKategorije2);
        this.godinaIzdavanja = new SimpleIntegerProperty(godinaIzdavanja);
        this.izdavackaKucaID = new SimpleIntegerProperty(izdavackaKucaID2);
    }*/
    /*public SimpleListProperty<Autor> getAutori() {
        return autori;
    }*/
    public SimpleIntegerProperty isbnProperty() {
        return isbn;
    }
    public SimpleStringProperty nazivKnjigeProperty() {
        return nazivKnjige;
    }

    public SimpleIntegerProperty idKategorijeProperty(){
        return idKategorije;
    }
    /*public SimpleStringProperty idKategorijeProperty() {
        return idKategorije;
    }*/

    public SimpleIntegerProperty izdavackaKucaID2Property(){
        return izdavackaKucaID2;
    }

    public SimpleIntegerProperty godinaIzdavanjaProperty() {
        return godinaIzdavanja;
    }
    public SimpleStringProperty getAutoriProperty(){
        return sviAutori;
    }

    @Override
    public String toString() {
        return '{' +
                "isbn:" + isbn.getValue() + "," +
                "naziv_Knjige:" + nazivKnjige.getValue() + "," +
                "autor:" + sviAutori.getValue() +
                "id_kategorije:" + idKategorije.getValue() + "," +
                "godina_Izdavanja:" + godinaIzdavanja.getValue() + "," +
                "izdavacka_kuca_id:" + izdavackaKucaID2.getValue() + "," +
                '}';
    }
}
