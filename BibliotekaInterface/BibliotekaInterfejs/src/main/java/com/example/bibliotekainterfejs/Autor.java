package com.example.bibliotekainterfejs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Autor {
    private SimpleIntegerProperty idAutora;
    private SimpleStringProperty imeAutora;
    private SimpleStringProperty prezimeAutora;
    private SimpleIntegerProperty godineAutora;

    public Autor(Integer idAutora, String imeAutora, String prezimeAutora, Integer godineAutora){
        this.idAutora = new SimpleIntegerProperty(idAutora);
        this.imeAutora = new SimpleStringProperty(imeAutora);
        this.prezimeAutora = new SimpleStringProperty(prezimeAutora);
        this.godineAutora = new SimpleIntegerProperty(godineAutora);
    }
    public SimpleIntegerProperty idAutoraProperty(){
        return idAutora;
    }
    public SimpleStringProperty imeAutoraProperty(){
        return imeAutora;
    }
    public SimpleStringProperty prezimeAutoraProperty(){
        return prezimeAutora;
    }
    public SimpleIntegerProperty godineAutoraProperty(){
        return godineAutora;
    }
}
