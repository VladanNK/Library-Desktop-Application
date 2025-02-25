package com.example.bibliotekainterfejs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController implements Initializable {
    @FXML
    private Label MenuActivate = new Label();

    @FXML
    private Label MenuBack = new Label();

    @FXML
    private Pane slider = new Pane();

    @FXML
    private ImageView MenuActivate2 = new ImageView();

    @FXML
    private ImageView MenuDeactivate2 = new ImageView();

    @FXML
    private Pane slider2 = new Pane();

    @FXML
    private Button zaIzlazak = new Button();

    @FXML
    private Pane paneInputs;

    @FXML
    private Pane paneAutor = new Pane();

    @FXML
    private Pane paneBiblioteka = new Pane();

    @FXML
    private Pane paneDrzava = new Pane();

    @FXML
    private Pane paneGrad = new Pane();

    @FXML
    private Pane paneIK = new Pane();

    @FXML
    private Pane paneKategorija = new Pane();

    @FXML
    private Pane paneKnjiga = new Pane();

    @FXML
    private Pane paneStavkaKnjiga = new Pane();

    @FXML
    private RadioButton optionAutor = new RadioButton("Autor");

    @FXML
    private RadioButton optionBiblioteka = new RadioButton("Biblioteka");

    @FXML
    private RadioButton optionDrzava = new RadioButton("Drzava");

    @FXML
    private RadioButton optionGrad = new RadioButton("Grad");

    @FXML
    private RadioButton optionIzdavackaKuca = new RadioButton("Izdavacka Kuca");

    @FXML
    private RadioButton optionKategorija = new RadioButton("Kategorija");

    @FXML
    private RadioButton optionKnjiga = new RadioButton("Knjiga");

    @FXML
    private RadioButton optionStavkaKnjiga = new RadioButton("Stavka Knjiga");

    @FXML
    private Button submitCreate = new Button();

    @FXML
    private Button submitUpdate = new Button();

    @FXML
    private TextField unosImenaAutora = new TextField();

    @FXML
    private TextField unosPrezimenaAutora = new TextField();

    @FXML
    private TextField unosGodinaAutora = new TextField();

    @FXML
    private TableView<Autor> tableAutor2 = new TableView<>();

    @FXML
    private TableColumn<Autor, Integer> idAutora;

    @FXML
    private TableColumn<Autor, String> imeAutora;

    @FXML
    private TableColumn<Autor, String> prezimeAutora;

    @FXML
    private TableColumn<Autor, Integer> godineAutora;

    @FXML
    private ObservableList<Autor> autorLista = FXCollections.observableArrayList();

    @FXML
    private TableView<Biblioteka> tableBiblioteka2 = new TableView<>();

    @FXML
    private TableColumn<Biblioteka, Integer> idBiblioteke;

    @FXML
    private TableColumn<Biblioteka, String> nazivBiblioteke;

    @FXML
    private TableColumn<Biblioteka, String> adresaBiblioteke;

    @FXML
    private TableColumn<Biblioteka, Integer> idGradaZaBiblioteku;

    @FXML
    private ObservableList<Biblioteka> bibliotekaLista = FXCollections.observableArrayList();

    @FXML
    private TableView<Drzava> tableDrzava2 = new TableView<>();

    @FXML
    private TableColumn<Drzava, Integer> idDrzave2;

    @FXML
    private TableColumn<Drzava, String> nazivDrzave;

    @FXML
    private ObservableList<Drzava> drzavaLista = FXCollections.observableArrayList();

    @FXML
    private TableView<Grad> tableGrad2 = new TableView<>();

    @FXML
    private TableColumn<Grad, Integer> idGrada;

    @FXML
    private TableColumn<Grad, String> nazivGrada;

    @FXML
    private TableColumn<Grad, String> postanskiBroj;

    @FXML
    private TableColumn<Grad, String> idDrzave;

    @FXML
    private ObservableList<Grad> gradLista = FXCollections.observableArrayList();

    @FXML
    private TableView<Kategorija> tableKategorija2 = new TableView<>();

    @FXML
    private TableColumn<Kategorija, Integer> idKategorije;

    @FXML
    private TableColumn<Kategorija, String> nazivKategorije;

    @FXML
    private ObservableList<Kategorija> kategorijaLista = FXCollections.observableArrayList();

    @FXML
    private TableView<Knjiga> tableKnjiga2 = new TableView<>();

    @FXML
    private TableColumn<Knjiga, Integer> isbn2;

    @FXML
    private TableColumn<Knjiga, String> nazivKnjige2;

    @FXML
    private TableColumn<Knjiga, Integer> idKategorije2;

    @FXML
    private TableColumn<Knjiga, Integer> godinaIzdavanjaKnjige;

    @FXML
    private TableColumn<Knjiga, Integer> izdavackaKucaID;

    @FXML
    private TableColumn<Knjiga, String> autori;

    @FXML
    private CheckComboBox<String> izborAutora = new CheckComboBox<>();

    @FXML
    private ObservableList<Knjiga> knjigaLista = FXCollections.observableArrayList();

    @FXML
    private TableView<IzdavackaKuca> tableIK2 = new TableView<>();

    @FXML
    private TableColumn<IzdavackaKuca, Integer> izdavackaKucaID2;

    @FXML
    private TableColumn<IzdavackaKuca, String> nazivIzdavackeKuce;

    @FXML
    private TableColumn<IzdavackaKuca, String> idGrada2;

    @FXML
    private ObservableList<IzdavackaKuca> izdavackaKucaLista = FXCollections.observableArrayList();

    @FXML
    private TableView<StavkaKnjige> tableStavkaKnjiga2 = new TableView<>();

    @FXML
    private TableColumn<StavkaKnjige, Integer> stavkaKnjigaID;

    @FXML
    private TableColumn<StavkaKnjige, String> isbnKnjige;

    @FXML
    private TableColumn<StavkaKnjige, String> idBiblioteke2;

    @FXML
    private ObservableList<StavkaKnjige> stavkaKnjigeLista = FXCollections.observableArrayList();

    @FXML
    private TextField unosNazivaBiblioteke = new TextField();

    @FXML
    private TextField unosAdreseBiblioteke = new TextField();

    @FXML
    private ChoiceBox<String> izborGradova = new ChoiceBox<>();

    @FXML
    private TextField unosDrzave = new TextField();

    @FXML
    private TextField unosNazivaGrada = new TextField();

    @FXML
    private TextField unosPostanskogBroja = new TextField();

    @FXML
    private ChoiceBox<String> izborDrzave = new ChoiceBox<>();

    @FXML
    private TextField unosIK = new TextField();

    @FXML
    private ChoiceBox<String> izborGradovaZaIK = new ChoiceBox<>();

    @FXML
    private TextField unosKategorije = new TextField();

    //pane Knjiga za create
    @FXML
    private TextField unosNazivaKnjige = new TextField();

    @FXML
    private ChoiceBox<String> izborKategorije = new ChoiceBox<>();

    @FXML
    private TextField unosGodineIzdavanja = new TextField();

    @FXML
    private ChoiceBox<String> izborIK2 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> odabirKnjige = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> odabirBiblioteke = new ChoiceBox<>();

    @FXML
    private CheckBox buttonAutor = new CheckBox();

    @FXML
    private CheckBox buttonBiblioteka = new CheckBox();

    @FXML
    private CheckBox buttonDrzava = new CheckBox();

    @FXML
    private CheckBox buttonGrad = new CheckBox();

    @FXML
    private CheckBox buttonIK = new CheckBox();

    @FXML
    private CheckBox buttonKategorija = new CheckBox();

    @FXML
    private CheckBox buttonKnjiga = new CheckBox();

    @FXML
    private CheckBox buttonStavkaKnjiga = new CheckBox();

    @FXML
    private TextField idAutoraUpdate = new TextField();

    @FXML
    private TextField imeAutoraUpdate = new TextField();

    @FXML
    private TextField prezimeAutoraUpdate = new TextField();

    @FXML
    private TextField godineAutoraUpdate = new TextField();

    @FXML
    private TextField idBibliotekeUpdate = new TextField();

    @FXML
    private TextField nazivBibliotekeUpdate = new TextField();

    @FXML
    private TextField adresaBibliotekeUpdate = new TextField();

    @FXML
    private TextField idDrzaveUpdate = new TextField();

    @FXML
    private TextField nazivDrzaveUpdate = new TextField();

    @FXML
    private TextField idGradaUpdate = new TextField();

    @FXML
    private TextField nazivGradaUpdate = new TextField();

    @FXML
    private TextField postanskiBrojUpdate = new TextField();

    @FXML
    private TextField idIKUpdate = new TextField();

    @FXML
    private TextField nazivIKUpdate = new TextField();

    @FXML
    private TextField idKategorijeUpdate = new TextField();

    @FXML
    private TextField nazivKategorijeUpdate = new TextField();

    @FXML
    private TextField isbnUpdate = new TextField();

    @FXML
    private TextField nazivKnjigeUpdate = new TextField();

    @FXML
    private ChoiceBox<String> kategorijaUpdate = new ChoiceBox<>();

    @FXML
    private TextField godinaIzdavanjaKnjigeUpdate = new TextField();

    @FXML
    private ChoiceBox<String> IKUpdate = new ChoiceBox<>();

    @FXML
    private CheckComboBox<String> izborAutoraUpdate = new CheckComboBox<>();

    @FXML
    private TextField idStavkaKnjigaUpdate = new TextField();

    @FXML
    private ChoiceBox<String> knjigaUpdate2 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> bibliotekaUpdate2 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> gradUpdate3 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> drzavaUpdate3 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> gradUpdate33 = new ChoiceBox<>();
    //******************Elementi delete ************************
    @FXML
    private TextField idAutoraDelete = new TextField();

    @FXML
    private TextField imeAutoraDelete = new TextField();

    @FXML
    private TextField prezimeAutoraDelete = new TextField();

    @FXML
    private TextField godineAutoraDelete = new TextField();

    @FXML
    private TextField idBibliotekeDelete = new TextField();

    @FXML
    private TextField nazivBibliotekeDelete = new TextField();

    @FXML
    private TextField adresaBibliotekeDelete = new TextField();

    @FXML
    private ChoiceBox<String> gradDelete = new ChoiceBox<>();

    @FXML
    private TextField idDrzaveDelete = new TextField();

    @FXML
    private TextField nazivDrzaveDelete = new TextField();

    @FXML
    private TextField idGradaDelete = new TextField();

    @FXML
    private TextField nazivGradaDelete = new TextField();

    @FXML
    private TextField postanskiBrojDelete = new TextField();

    @FXML
    private ChoiceBox<String> drzavaDelete3 = new ChoiceBox<>();

    @FXML
    private TextField idIKDelete = new TextField();

    @FXML
    private TextField nazivIKDelete = new TextField();

    @FXML
    private ChoiceBox<String> gradDelete33 = new ChoiceBox<>();

    @FXML
    private TextField idKategorijeDelete = new TextField();

    @FXML
    private TextField nazivKategorijeDelete = new TextField();

    @FXML
    private TextField isbnDelete = new TextField();

    @FXML
    private TextField nazivKnjigeDelete = new TextField();

    @FXML
    private ChoiceBox<String> kategorijaDelete = new ChoiceBox<>();

    @FXML
    private TextField godinaIzdavanjaKnjigeDelete = new TextField();

    @FXML
    private ChoiceBox<String> IKDelete = new ChoiceBox<>();

    @FXML
    private CheckComboBox<String> izborAutoraDelete = new CheckComboBox<>();

    @FXML
    private TextField idStavkaKnjigaDelete = new TextField();

    @FXML
    private ChoiceBox<String> knjigaDelete2 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> bibliotekaDelete2 = new ChoiceBox<>();

    @FXML
    private Button submitDelete = new Button();

    @FXML
    private TextArea allUpdates = new TextArea();

    public static StringProperty textContent = new SimpleStringProperty();
    public static StringBuilder textContent2 = new StringBuilder();

    private ToggleGroup toggleGroup;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public static LocalDateTime now = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");

    public Writer file;

    public static boolean hasRun = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAutori();
        loadBiblioteke();
        loadGrad();
        loadDrzave();
        loadKategorije();
        loadKnjige();
        loadIzdavackaKuca();
        loadStavkaKnjiga();
        readFromFile();

        slider.setTranslateX(-262);
        MenuActivate.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-262);

            slide.setOnFinished((ActionEvent e) -> {
                MenuActivate.setVisible(false);
                MenuBack.setVisible(true);
            });
        });
        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(slider);

            slide.setToX(-262);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                MenuActivate.setVisible(true);
                MenuBack.setVisible(false);
            });
        });

        slider2.setTranslateX(-1202);
        MenuActivate2.setOnMouseClicked(event -> {
            TranslateTransition slide2 = new TranslateTransition();
            slide2.setDuration(Duration.seconds(0.9));
            slide2.setNode(slider2);

            slide2.setToX(1);
            slide2.play();

            slider2.setTranslateX(1110);

            slide2.setOnFinished((ActionEvent e) -> {
                MenuActivate2.setVisible(false);
                MenuDeactivate2.setVisible(true);
            });
        });
        MenuDeactivate2.setOnMouseClicked(event -> {
            TranslateTransition slide2 = new TranslateTransition();
            slide2.setDuration(Duration.seconds(0.9));
            slide2.setNode(slider2);
            slide2.setToX(-1202);
            slide2.play();
            slider2.setTranslateX(-1202);
            slide2.setOnFinished((ActionEvent e) -> {
                MenuActivate2.setVisible(true);
                MenuDeactivate2.setVisible(false);
            });
        });
        toggleGroup = new ToggleGroup();
        optionAutor.setToggleGroup(toggleGroup);
        optionBiblioteka.setToggleGroup(toggleGroup);
        optionDrzava.setToggleGroup(toggleGroup);
        optionGrad.setToggleGroup(toggleGroup);
        optionIzdavackaKuca.setToggleGroup(toggleGroup);
        optionKategorija.setToggleGroup(toggleGroup);
        optionKnjiga.setToggleGroup(toggleGroup);
        optionStavkaKnjiga.setToggleGroup(toggleGroup);

        optionAutor.setSelected(true);

        buttonAutor.setSelected(true);
            buttonBiblioteka.setSelected(true);
            buttonDrzava.setSelected(true);
            buttonGrad.setSelected(true);
            buttonIK.setSelected(true);
            buttonKategorija.setSelected(true);
            buttonKnjiga.setSelected(true);
            buttonStavkaKnjiga.setSelected(true);

            tableAutor2.setVisible(true);
            tableBiblioteka2.setVisible(true);
            tableGrad2.setVisible(true);
            tableKnjiga2.setVisible(true);
            tableDrzava2.setVisible(true);
            tableKategorija2.setVisible(true);
            tableIK2.setVisible(true);
            tableStavkaKnjiga2.setVisible(true);

        buttonAutor.setOnAction(event -> {
            tableAutor2.setVisible(buttonAutor.isSelected());
        });
        buttonBiblioteka.setOnAction(event -> {
            tableBiblioteka2.setVisible(buttonBiblioteka.isSelected());
        });
        buttonGrad.setOnAction(event -> {
            tableGrad2.setVisible(buttonGrad.isSelected());
        });
        buttonDrzava.setOnAction(event -> {
            tableDrzava2.setVisible(buttonDrzava.isSelected());
        });
        buttonIK.setOnAction(event -> {
            tableIK2.setVisible(buttonIK.isSelected());
        });
        buttonKategorija.setOnAction(event -> {
            tableKategorija2.setVisible(buttonKategorija.isSelected());
        });
        buttonKnjiga.setOnAction(event -> {
            tableKnjiga2.setVisible(buttonKnjiga.isSelected());
        });
        buttonStavkaKnjiga.setOnAction(event -> {
            tableStavkaKnjiga2.setVisible(buttonStavkaKnjiga.isSelected());
        });

        idAutora = new TableColumn<>("ID Autora");
        idAutora.setCellValueFactory(data -> data.getValue().idAutoraProperty().asObject());

        imeAutora = new TableColumn<>("Ime Autora");
        imeAutora.setCellValueFactory(data -> data.getValue().imeAutoraProperty());

        prezimeAutora = new TableColumn<>("Prezime Autora");
        prezimeAutora.setCellValueFactory(data -> data.getValue().prezimeAutoraProperty());

        godineAutora = new TableColumn<>("Godine Autora");
        godineAutora.setCellValueFactory(data -> data.getValue().godineAutoraProperty().asObject());

        tableAutor2.getColumns().addAll(Arrays.asList(idAutora, imeAutora, prezimeAutora, godineAutora));
        tableAutor2.setItems(autorLista);

        idBiblioteke = new TableColumn<>("ID Biblioteke");
        idBiblioteke.setCellValueFactory(data -> data.getValue().idBibliotekeProperty().asObject());

        nazivBiblioteke = new TableColumn<>("Naziv Biblioteke");
        nazivBiblioteke.setCellValueFactory(data -> data.getValue().nazivBibliotekeProperty());

        adresaBiblioteke = new TableColumn<>("Adresa Biblioteke");
        adresaBiblioteke.setCellValueFactory(data -> data.getValue().adresaBibliotekeProperty());

        idGradaZaBiblioteku = new TableColumn<>("ID Grada");
        idGradaZaBiblioteku.setCellValueFactory(data -> data.getValue().idGradaBibliotekaProperty().asObject());

        tableBiblioteka2.getColumns().addAll(Arrays.asList(idBiblioteke, nazivBiblioteke, adresaBiblioteke, idGradaZaBiblioteku));
        tableBiblioteka2.setItems(bibliotekaLista);

        idDrzave2 = new TableColumn<>("ID Drzave");
        idDrzave2.setCellValueFactory(data -> data.getValue().idDrzaveProperty2().asObject());

        nazivDrzave = new TableColumn<>("Naziv Drzave");
        nazivDrzave.setCellValueFactory(data -> data.getValue().nazivDrzaveProperty());

        tableDrzava2.getColumns().addAll(Arrays.asList(idDrzave2, nazivDrzave));
        tableDrzava2.setItems(drzavaLista);

        idGrada = new TableColumn<>("ID Grada");
        idGrada.setCellValueFactory(data -> data.getValue().idGradaProperty().asObject());

        nazivGrada = new TableColumn<>("Naziv Grada");
        nazivGrada.setCellValueFactory(data -> data.getValue().nazivGradaProperty());

        postanskiBroj = new TableColumn<>("Postanski Broj");
        postanskiBroj.setCellValueFactory(data -> data.getValue().postanskiBrojProperty());

        idDrzave = new TableColumn<>("ID Drzave");
        idDrzave.setCellValueFactory(data -> data.getValue().idDrzaveProperty());

        tableGrad2.getColumns().addAll(Arrays.asList(idGrada, nazivGrada, postanskiBroj, idDrzave));
        tableGrad2.setItems(gradLista);

        idKategorije = new TableColumn<>("ID Kategorije");
        idKategorije.setCellValueFactory(data -> data.getValue().idKategorijeProperty().asObject());

        nazivKategorije = new TableColumn<>("Naziv Kategorije");
        nazivKategorije.setCellValueFactory(data -> data.getValue().nazivKategorijeProperty());

        tableKategorija2.getColumns().addAll(Arrays.asList(idKategorije, nazivKategorije));
        tableKategorija2.setItems(kategorijaLista);

        isbn2 = new TableColumn<>("ISBN");
        isbn2.setCellValueFactory(data -> data.getValue().isbnProperty().asObject());

        nazivKnjige2 = new TableColumn<>("Naziv Knjige");
        nazivKnjige2.setCellValueFactory(data -> data.getValue().nazivKnjigeProperty());

        idKategorije2 = new TableColumn<>("ID Kategorije");
        idKategorije2.setCellValueFactory(data -> data.getValue().idKategorijeProperty().asObject());

        godinaIzdavanjaKnjige = new TableColumn<>("Godina Izdavanja");
        godinaIzdavanjaKnjige.setCellValueFactory(data -> data.getValue().godinaIzdavanjaProperty().asObject());

        izdavackaKucaID = new TableColumn<>("Izdavacka Kuca ID");
        izdavackaKucaID.setCellValueFactory(data -> data.getValue().izdavackaKucaID2Property().asObject());

        autori = new TableColumn<>("Autori");
        autori.setCellValueFactory(data -> data.getValue().getAutoriProperty());

        tableKnjiga2.getColumns().addAll(Arrays.asList(isbn2, nazivKnjige2, idKategorije2, godinaIzdavanjaKnjige, izdavackaKucaID, autori));
        tableKnjiga2.setItems(knjigaLista);

        izdavackaKucaID2 = new TableColumn<>("Izdavacka Kuca ID");
        izdavackaKucaID2.setCellValueFactory(data -> data.getValue().izdavackaKucaIDProperty().asObject());

        nazivIzdavackeKuce = new TableColumn<>("Naziv Izdavacke Kuce");
        nazivIzdavackeKuce.setCellValueFactory(data -> data.getValue().nazivIzdavackeKuceProperty());

        idGrada2 = new TableColumn<>("ID Grada");
        idGrada2.setCellValueFactory(data -> data.getValue().idGradaProperty2());

        tableIK2.getColumns().addAll(Arrays.asList(izdavackaKucaID2, nazivIzdavackeKuce, idGrada2));
        tableIK2.setItems(izdavackaKucaLista);

        stavkaKnjigaID = new TableColumn<>("ID Stavka Knjiga");
        stavkaKnjigaID.setCellValueFactory(data -> data.getValue().stavkaKnjigeIDProperty().asObject());

        isbnKnjige = new TableColumn<>("ISBN Knjige");
        isbnKnjige.setCellValueFactory(data -> data.getValue().isbnProperty());

        idBiblioteke2 = new TableColumn<>("ID Biblioteke");
        idBiblioteke2.setCellValueFactory(data -> data.getValue().idBibliotekeProperty());

        tableStavkaKnjiga2.getColumns().addAll(Arrays.asList(stavkaKnjigaID, isbnKnjige, idBiblioteke2));
        tableStavkaKnjiga2.setItems(stavkaKnjigeLista);

        izborGradova.setValue("--Izaberi grad--");
        izborGradova.getItems().add("--Izaberi grad--");

        izborGradovaZaIK.setValue("--Izaberi grad--");
        izborGradovaZaIK.getItems().add("--Izaberi grad--");

        odabirKnjige.setValue("--Izaberi knjigu--");
        odabirKnjige.getItems().add("--Izaberi knjigu--");

        knjigaUpdate2.setValue("--Izaberi knjigu--");
        knjigaUpdate2.getItems().add("--Izaberi knjigu--");

        bibliotekaUpdate2.setValue("--Izaberi biblioteku--");
        bibliotekaUpdate2.getItems().add("--Izaberi biblioteku--");

        odabirBiblioteke.setValue("--Izaberi biblioteku--");
        odabirBiblioteke.getItems().add("--Izaberi biblioteku--");

        gradUpdate3.setValue("--Izaberi grad--");
        gradUpdate3.getItems().add("--Izaberi grad--");

        gradUpdate33.setValue("--Izaberi grad--");
        gradUpdate33.getItems().add("--Izaberi grad--");

        for(Autor autor : autorLista){
            izborAutora.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
            izborAutoraUpdate.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
            izborAutoraDelete.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
        }
        for(Grad grad : gradLista){
            izborGradova.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
            izborGradovaZaIK.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
            gradUpdate3.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
            gradUpdate33.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
        }
        for(Knjiga knjiga : knjigaLista){
            odabirKnjige.getItems().add(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
            knjigaUpdate2.getItems().add(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
        }
        for(Biblioteka biblioteka : bibliotekaLista){
            odabirBiblioteke.getItems().add(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
            bibliotekaUpdate2.getItems().add(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
        }

        izborKategorije.setValue("--Izaberi kategoriju--");
        izborKategorije.getItems().add("--Izaberi kategoriju--");
        kategorijaUpdate.setValue("--Izaberi kategoriju--");
        kategorijaUpdate.getItems().add("--Izaberi kategoriju--");
        for(Kategorija kategorija : kategorijaLista){
            izborKategorije.getItems().add(String.format("ID Kategorije: %s Naziv Kategorije: %s", kategorija.idKategorijeProperty().get(), kategorija.nazivKategorijeProperty().get()));
            kategorijaUpdate.getItems().add(String.format("ID Kategorije: %s Naziv Kategorije: %s", kategorija.idKategorijeProperty().get(), kategorija.nazivKategorijeProperty().get()));
        }
        izborIK2.setValue("--Izaberi Izdavacku Kucu--");
        izborIK2.getItems().add("--Izaberi Izdavacku Kucu--");
        IKUpdate.setValue("--Izaberi Izdavacku Kucu--");
        IKUpdate.getItems().add("--Izaberi Izdavacku Kucu--");
        for(IzdavackaKuca izdavackaKuca : izdavackaKucaLista){
            izborIK2.getItems().add(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", izdavackaKuca.izdavackaKucaIDProperty().get(), izdavackaKuca.nazivIzdavackeKuceProperty().get()));
            IKUpdate.getItems().add(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", izdavackaKuca.izdavackaKucaIDProperty().get(), izdavackaKuca.nazivIzdavackeKuceProperty().get()));
        }
        izborDrzave.setValue("--Izaberi drzavu--");
        izborDrzave.getItems().add("--Izaberi drzavu--");

        drzavaUpdate3.setValue("--Izaberi drzavu--");
        drzavaUpdate3.getItems().add("--Izaberi drzavu--");
        for(Drzava drzava : drzavaLista){
            izborDrzave.getItems().add(String.format("ID Drzave: %s Naziv Drzave: %s", drzava.idDrzaveProperty2().get(), drzava.nazivDrzaveProperty().get()));
            drzavaUpdate3.getItems().add(String.format("ID Drzave: %s Naziv Drzave: %s", drzava.idDrzaveProperty2().get(), drzava.nazivDrzaveProperty().get()));
        }

        allUpdates.textProperty().bind(textContent);

        //Click event za popunjavanje polja iz tabela (UPDATE i DELETE)

        tableAutor2.setRowFactory(arg -> {
            TableRow<Autor> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    Autor autor = row.getItem();
                    fillFieldsAutor(autor);
                }
            });
            return row;
        });
        tableBiblioteka2.setRowFactory(arg -> {
            TableRow<Biblioteka> row2 = new TableRow<>();
            row2.setOnMouseClicked(event -> {
                if(!row2.isEmpty() && event.getClickCount() == 1){
                    Biblioteka biblioteka = row2.getItem();
                    fillFieldsBiblioteka(biblioteka);
                }
            });
            return row2;
        });
        tableDrzava2.setRowFactory(arg -> {
            TableRow<Drzava> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    Drzava drzava = row.getItem();
                    fillFieldsDrzava(drzava);
                }
            });
            return row;
        });
        tableGrad2.setRowFactory(arg -> {
            TableRow<Grad> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    Grad grad = row.getItem();
                    fillFieldsGrad(grad);
                }
            });
            return row;
        });
        tableIK2.setRowFactory(arg -> {
            TableRow<IzdavackaKuca> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    IzdavackaKuca izdavackaKuca = row.getItem();
                    fillFieldsIK(izdavackaKuca);
                }
            });
            return row;
        });
        tableKategorija2.setRowFactory(arg -> {
            TableRow<Kategorija> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    Kategorija kategorija = row.getItem();
                    fillFieldsKategorija(kategorija);
                }
            });
            return row;
        });
        tableKnjiga2.setRowFactory(arg -> {
            TableRow<Knjiga> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    Knjiga knjiga = row.getItem();
                    fillFieldsKnjiga(knjiga);
                }
            });
            return row;
        });
        tableStavkaKnjiga2.setRowFactory(arg -> {
            TableRow<StavkaKnjige> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount() == 1){
                    StavkaKnjige stavkaKnjige = row.getItem();
                    fillFieldsStavkaKnjiga(stavkaKnjige);
                }
            });
            return row;
        });

        //Dodavanje na Backend i u bazu podataka

        submitCreate.setOnAction(event -> {
            if(optionAutor.isSelected()){
                String imeAutora2 = unosImenaAutora.getText();
                String prezimeAutora2 = unosPrezimenaAutora.getText();
                Integer godineAutora2 = Integer.parseInt(unosGodinaAutora.getText());
                addAutor(imeAutora2, prezimeAutora2, godineAutora2);
                unosImenaAutora.clear();
                unosPrezimenaAutora.clear();
                unosGodinaAutora.clear();
            } else if(optionBiblioteka.isSelected()){
                String nazivBiblioteke = unosNazivaBiblioteke.getText();
                String adresaBiblioteke = unosAdreseBiblioteke.getText();

                String izborGrada = izborGradova.getSelectionModel().getSelectedItem();
                if (izborGrada != null) {
                    Pattern pattern = Pattern.compile("ID Grada:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborGrada);

                    JsonObject obj = new JsonObject();
                    if(matcher.find()){
                        int idString = Integer.parseInt(matcher.group(1));

                        Grad selectedGrad = null;
                        for (Grad grad : gradLista) {
                            if (grad.idGradaProperty().get() == idString) {
                                selectedGrad = grad; // Nađi odgovarajući grad sa istim ID-jem
                                //addBiblioteka(nazivBiblioteke, adresaBiblioteke, selectedGrad, );
                                System.out.println("Ovo je izvuceni grad: " + selectedGrad);

                                String gradJson = selectedGrad.toString();
                                System.out.println("#####################" + gradJson);
                                System.out.println("stizes1");
                                JSONObject jsonObject = new JSONObject(gradJson);
                                int idDrzave2 = jsonObject.getInt("id_drzave");

                                //Pattern drzavaPattern = Pattern.compile("\"id_drzave\":\\s*(\\d+)");
                                //Matcher drzavaMatcher = drzavaPattern.matcher(gradJson);
                                System.out.println("stizes2");
                                Drzava selectedDrzava = null;
                                if (true) {
                                    //int idDrzave = Integer.parseInt(drzavaMatcher.group(1));
                                    for (Drzava drzava : drzavaLista) {
                                        if (drzava.idDrzaveProperty2().get() == idDrzave2) {
                                            selectedDrzava = drzava; // Nađena država sa odgovarajućim ID-jem
                                            System.out.println("Ovo je izvucena drzava: " + selectedDrzava);
                                            addBiblioteka(nazivBiblioteke, adresaBiblioteke, selectedGrad, selectedDrzava);
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("nisam nasao");
                                }
                            }
                        }
                    }
                }
                unosNazivaBiblioteke.clear();
                unosAdreseBiblioteke.clear();
                izborGradova.setValue("--Izaberi grad--");
            } else if(optionDrzava.isSelected()){
                String nazivDrzave = unosDrzave.getText();
                addDrzava(nazivDrzave);
                unosDrzave.clear();
            } else if(optionGrad.isSelected()){
                String nazivGrada = unosNazivaGrada.getText();
                String postanskiBroj = unosPostanskogBroja.getText();

                String izborDrzave2 = izborDrzave.getSelectionModel().getSelectedItem();
                if(izborDrzave2 != null){
                    Pattern pattern = Pattern.compile("ID Drzave:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborDrzave2);

                    if(matcher.find()) {
                        int idString = Integer.parseInt(matcher.group(1));
                        Drzava selectedDrzava = null;
                        for (Drzava drzava : drzavaLista) {
                            if (drzava.idDrzaveProperty2().get() == idString) {
                                selectedDrzava = drzava; // Nađi odgovarajući grad sa istim ID-jem
                                addGrad(nazivGrada, postanskiBroj, selectedDrzava);
                                System.out.println("Ovo je izvucena drzava: " + selectedDrzava);
                                break;
                            }
                        }
                    }
                }
                unosNazivaGrada.clear();
                unosPostanskogBroja.clear();
                izborDrzave.setValue("--Izaberi drzavu--");
            } else if(optionIzdavackaKuca.isSelected()){
                String nazivIK = unosIK.getText();

                String izborGrada = izborGradovaZaIK.getSelectionModel().getSelectedItem();
                if(izborGrada != null){
                    Pattern pattern = Pattern.compile("ID Grada:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborGrada);

                    if(matcher.find()){
                        int idString = Integer.parseInt(matcher.group(1));

                        Grad selectedGrad = null;
                        for (Grad grad : gradLista) {
                            if (grad.idGradaProperty().get() == idString) {
                                selectedGrad = grad; // Nađi odgovarajući grad sa istim ID-jem
                                String gradJson = selectedGrad.toString();
                                JSONObject jsonObject = new JSONObject(gradJson);
                                int idDrzave2 = jsonObject.getInt("id_drzave");

                                Drzava selectedDrzava = null;
                                if (true) {
                                    for (Drzava drzava : drzavaLista) {
                                        if (drzava.idDrzaveProperty2().get() == idDrzave2) {
                                            selectedDrzava = drzava; // Nađena država sa odgovarajućim ID-jem
                                            addIzdavackaKuca(nazivIK, selectedGrad, selectedDrzava);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                unosIK.clear();
                izborGradovaZaIK.setValue("--Izaberi grad--");
            } else if(optionKategorija.isSelected()){
                String nazivKategorije = unosKategorije.getText();
                addKategorija(nazivKategorije);
                unosKategorije.clear();
            } else if(optionKnjiga.isSelected()){
                String nazivKnjige = unosNazivaKnjige.getText();
                String godinaIzdanja = unosGodineIzdavanja.getText();

                String izborKategorije2 = izborKategorije.getSelectionModel().getSelectedItem();
                String izborIK22 = izborIK2.getSelectionModel().getSelectedItem();
                ObservableList<String> odabirAutora = izborAutora.getCheckModel().getCheckedItems();
                String nesto = odabirAutora.toString();
                System.out.println("ovo je odabir autora " + odabirAutora);
                if(izborKategorije2 != null && izborIK22 != null && !odabirAutora.isEmpty()){
                    Pattern pattern = Pattern.compile("ID Kategorije:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborKategorije2);

                    Pattern pattern2 = Pattern.compile("ID Izdavacke Kuce:\\s*(\\d+)");
                    Matcher matcher2 = pattern2.matcher(izborIK22);

                    if(matcher.find() && matcher2.find()){
                        int idKategorije = Integer.parseInt(matcher.group(1));
                        int idIzdavackeKuce = Integer.parseInt(matcher2.group(1));

                        Kategorija selectedKategorija = kategorijaLista.stream()
                                .filter(k -> k.idKategorijeProperty().get() == idKategorije)
                                .findFirst().orElse(null);

                        IzdavackaKuca selectedIK = izdavackaKucaLista.stream()
                                .filter(ik -> ik.izdavackaKucaIDProperty().get() == idIzdavackeKuce)
                                .findFirst().orElse(null);

                        if (selectedKategorija != null && selectedIK != null) {
                            Grad selectedGrad = gradLista.stream()
                                    .filter(g -> g.idGradaProperty().get() == Integer.parseInt(selectedIK.idGradaProperty2().get()))
                                    .findFirst().orElse(null);

                            Drzava selectedDrzava = drzavaLista.stream()
                                    .filter(d -> d.idDrzaveProperty2().get() == selectedGrad.idGradaProperty().get())
                                    .findFirst().orElse(null);

                            List<Autor> listaAutora = new ArrayList<>();
                            Pattern pattern3 = Pattern.compile("ID Autora:\\s*(\\d+)");
                            for (String autorStr : odabirAutora) {
                                Matcher matcher3 = pattern3.matcher(autorStr);
                                if (matcher3.find()) {
                                    int idAutora = Integer.parseInt(matcher3.group(1));
                                    autorLista.stream()
                                            .filter(a -> a.idAutoraProperty().get() == idAutora)
                                            .findFirst()
                                            .ifPresent(listaAutora::add);
                                }
                            }

                            if (selectedGrad != null && selectedDrzava != null) {
                                addKnjiga(nazivKnjige, selectedKategorija, godinaIzdanja, selectedIK, selectedGrad, selectedDrzava, listaAutora);
                            }
                        }
                    }
                }
                unosNazivaKnjige.clear();
                unosGodineIzdavanja.clear();
                izborKategorije.setValue("--Izaberi kategoriju--");
                izborIK2.setValue("--Izaberi Izdavacku Kucu--");
            } else if(buttonStavkaKnjiga.isSelected()){
                String odabirKnjige2 = odabirKnjige.getSelectionModel().getSelectedItem();
                String odabirBiblioteke2 = odabirBiblioteke.getSelectionModel().getSelectedItem();
                ObservableList<String> odabirAutora = izborAutora.getCheckModel().getCheckedItems();
                if(odabirKnjige2 != null && odabirBiblioteke2 != null){
                    Pattern pattern1 = Pattern.compile("ISBN Knjige:\\s*(\\d+)");
                    Matcher matcher = pattern1.matcher(odabirKnjige2);

                    Pattern pattern11 = Pattern.compile("ID Biblioteke:\\s*(\\d+)");
                    Matcher matcher2 = pattern11.matcher(odabirBiblioteke2);

                    if(matcher.find() && matcher2.find()){
                        int idString1 = Integer.parseInt(matcher.group(1));
                        int idString2 = Integer.parseInt(matcher2.group(1));

                        Knjiga selectedKnjiga = knjigaLista.stream()
                                .filter(k -> k.isbnProperty().get() == idString1)
                                .findFirst().orElse(null);
                        Biblioteka selectedBiblioteka = bibliotekaLista.stream()
                                .filter(b -> b.idBibliotekeProperty().get() == idString2)
                                .findFirst().orElse(null);
                        if(selectedKnjiga != null && selectedBiblioteka != null){
                            Kategorija selectedKategorija = kategorijaLista.stream()
                                    .filter(k -> k.idKategorijeProperty().get() == selectedKnjiga.idKategorijeProperty().get())
                                    .findFirst().orElse(null);

                            IzdavackaKuca selectedIK = izdavackaKucaLista.stream()
                                    .filter(ik -> ik.izdavackaKucaIDProperty().get() == selectedKnjiga.izdavackaKucaID2Property().get())
                                    .findFirst().orElse(null);
                            if(selectedKategorija != null && selectedIK != null){
                                Grad selectedGrad = gradLista.stream()
                                        .filter(g -> g.idGradaProperty().get() == Integer.parseInt(selectedIK.idGradaProperty2().get()))
                                        .findFirst().orElse(null);
                                Drzava selectedDrzava = drzavaLista.stream()
                                        .filter(d -> d.idDrzaveProperty2().get() == Integer.parseInt(selectedGrad.idDrzaveProperty().get()))
                                        .findFirst().orElse(null);
                                Grad selectedGradBiblioteka = gradLista.stream()
                                        .filter(g -> g.idGradaProperty().get() == selectedBiblioteka.idGradaBibliotekaProperty().get())
                                        .findFirst().orElse(null);
                                Drzava selectedDrzavaBiblioteka = drzavaLista.stream()
                                        .filter(d -> d.idDrzaveProperty2().get() == Integer.parseInt(selectedGradBiblioteka.idDrzaveProperty().get()))
                                        .findFirst().orElse(null);
                                List<Autor> autorList = new ArrayList<>();
                                Pattern pattern3 = Pattern.compile("ID Autora:\\s*(\\d+)");
                                for(String autorStr : odabirAutora){
                                    Matcher matcher3 = pattern3.matcher(autorStr);
                                    if (matcher3.find()) {
                                        int idAutora = Integer.parseInt(matcher3.group(1));
                                        autorLista.stream()
                                                .filter(a -> a.idAutoraProperty().get() == idAutora)
                                                .findFirst()
                                                .ifPresent(autorList::add);
                                    }
                                }
                                if (selectedGrad != null && selectedDrzava != null) {
                                    addStavkaKnjiga(selectedKnjiga, selectedKategorija, selectedIK, selectedGrad, selectedDrzava, selectedBiblioteka, selectedGradBiblioteka, selectedDrzavaBiblioteka, autorList);
                                    //Knjiga knjiga, Kategorija kategorija, IzdavackaKuca izdavackaKuca, Grad grad2, Drzava drzava2, Biblioteka biblioteka, Grad grad3, Drzava drzava3, List<Autor> autori
                                }
                            }
                        }
                    }
                }
                odabirKnjige.setValue("--Izaberi knjigu--");
                odabirBiblioteke.setValue("--Izaberi biblioteku--");
            }
        });
        //Update baze podataka
        submitUpdate.setOnAction(event -> {
            if(optionAutor.isSelected()){
                int idAutora = Integer.parseInt(idAutoraUpdate.getText());
                String imeAutora21 = imeAutoraUpdate.getText();
                String prezimeAutora21 = prezimeAutoraUpdate.getText();
                Integer godineAutora21 = Integer.parseInt(godineAutoraUpdate.getText());
                updateAutor(idAutora, imeAutora21, prezimeAutora21, godineAutora21);
                idAutoraUpdate.clear();
                imeAutoraUpdate.clear();
                prezimeAutoraUpdate.clear();
                godineAutoraUpdate.clear();
            } else if(optionBiblioteka.isSelected()){
                int idBiblioteke = Integer.parseInt(idBibliotekeUpdate.getText());
                String nazivBiblioteke = nazivBibliotekeUpdate.getText();
                String adresaBiblioteke = adresaBibliotekeUpdate.getText();

                String izborGrada = gradUpdate3.getSelectionModel().getSelectedItem();
                if (izborGrada != null) {
                    Pattern pattern = Pattern.compile("ID Grada:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborGrada);

                    JsonObject obj = new JsonObject();
                    if(matcher.find()){
                        int idString = Integer.parseInt(matcher.group(1));
                        System.out.println("stigao1");
                        Grad selectedGrad = null;
                        for (Grad grad : gradLista) {
                            if (grad.idGradaProperty().get() == idString) {
                                selectedGrad = grad; // Nađi odgovarajući grad sa istim ID-jem
                                String gradJson = selectedGrad.toString();
                                JSONObject jsonObject = new JSONObject(gradJson);
                                int idDrzave2 = jsonObject.getInt("id_drzave");
                                Drzava selectedDrzava = null;
                                System.out.println("Stigao2");
                                if (true) {
                                    for (Drzava drzava : drzavaLista) {
                                        if (drzava.idDrzaveProperty2().get() == idDrzave2) {
                                            System.out.println("Stigao3");
                                            selectedDrzava = drzava; // Nađena država sa odgovarajućim ID-jem
                                            updateBiblioteka(idBiblioteke, nazivBiblioteke, adresaBiblioteke, selectedGrad, selectedDrzava);
                                            System.out.println("Pozvana f-ja za update biblitoeke");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                idBibliotekeUpdate.clear();
                nazivBibliotekeUpdate.clear();
                adresaBibliotekeUpdate.clear();
                gradUpdate3.setValue("--Izaberi grad--");
            } else if(optionDrzava.isSelected()){
                int idDrzave = Integer.parseInt(idDrzaveUpdate.getText());
                String nazivDrzave = nazivDrzaveUpdate.getText();
                updateDrzava(idDrzave, nazivDrzave);
                idDrzaveUpdate.clear();
                nazivDrzaveUpdate.clear();
            } else if(optionGrad.isSelected()){
                int idGrada22 = Integer.parseInt(idGradaUpdate.getText());
                String nazivGrada = nazivGradaUpdate.getText();
                String postanskiBroj = postanskiBrojUpdate.getText();

                String izborDrzave2 = drzavaUpdate3.getSelectionModel().getSelectedItem();
                if(izborDrzave2 != null){
                    Pattern pattern = Pattern.compile("ID Drzave:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborDrzave2);

                    if(matcher.find()) {
                        int idString = Integer.parseInt(matcher.group(1));
                        Drzava selectedDrzava = null;
                        for (Drzava drzava : drzavaLista) {
                            if (drzava.idDrzaveProperty2().get() == idString) {
                                selectedDrzava = drzava; // Nađi odgovarajući grad sa istim ID-jem
                                updateGrad(idGrada22, nazivGrada, postanskiBroj, selectedDrzava);
                                break;
                            }
                        }
                    }
                }
                idGradaUpdate.clear();
                nazivGradaUpdate.clear();
                postanskiBrojUpdate.clear();
                drzavaUpdate3.setValue("--Izaberi drzavu--");
            } else if(optionIzdavackaKuca.isSelected()){
                int idIK = Integer.parseInt(idIKUpdate.getText());
                String nazivIK = nazivIKUpdate.getText();

                String izborGrada = gradUpdate33.getSelectionModel().getSelectedItem();
                if(izborGrada != null){
                    Pattern pattern = Pattern.compile("ID Grada:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborGrada);

                    if(matcher.find()){
                        int idString = Integer.parseInt(matcher.group(1));

                        Grad selectedGrad = null;
                        for (Grad grad : gradLista) {
                            if (grad.idGradaProperty().get() == idString) {
                                selectedGrad = grad; // Nađi odgovarajući grad sa istim ID-jem
                                String gradJson = selectedGrad.toString();
                                JSONObject jsonObject = new JSONObject(gradJson);
                                int idDrzave2 = jsonObject.getInt("id_drzave");

                                Drzava selectedDrzava = null;
                                if (true) {
                                    for (Drzava drzava : drzavaLista) {
                                        if (drzava.idDrzaveProperty2().get() == idDrzave2) {
                                            selectedDrzava = drzava; // Nađena država sa odgovarajućim ID-jem
                                            updateIzdavackaKuca(idIK, nazivIK, selectedGrad, selectedDrzava);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                idIKUpdate.clear();
                unosIK.clear();
                gradUpdate33.setValue("--Izaberi grad--");
            } else if(optionKategorija.isSelected()){
                int idKategorije = Integer.parseInt(idKategorijeUpdate.getText());
                String nazivKategorije = nazivKategorijeUpdate.getText();
                updateKategorija(idKategorije, nazivKategorije);
                idKategorijeUpdate.clear();
                nazivKategorijeUpdate.clear();
            } else if(optionKnjiga.isSelected()){
                int idKnjige = Integer.parseInt(isbnUpdate.getText());
                String nazivKnjige = nazivKnjigeUpdate.getText();
                String godinaIzdanja = godinaIzdavanjaKnjigeUpdate.getText();

                String izborKategorije2 = kategorijaUpdate.getSelectionModel().getSelectedItem();
                String izborIK22 = IKUpdate.getSelectionModel().getSelectedItem();
                ObservableList<String> odabirAutora2 = izborAutoraUpdate.getCheckModel().getCheckedItems();
                String nesto = odabirAutora2.toString();
                System.out.println("ovo je odabir autora " + odabirAutora2);
                if(izborKategorije2 != null && izborIK22 != null && !odabirAutora2.isEmpty()){
                    Pattern pattern = Pattern.compile("ID Kategorije:\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(izborKategorije2);

                    Pattern pattern2 = Pattern.compile("ID Izdavacke Kuce:\\s*(\\d+)");
                    Matcher matcher2 = pattern2.matcher(izborIK22);

                    if(matcher.find() && matcher2.find()){
                        int idKategorije = Integer.parseInt(matcher.group(1));
                        int idIzdavackeKuce = Integer.parseInt(matcher2.group(1));

                        Kategorija selectedKategorija2 = kategorijaLista.stream()
                                .filter(k -> k.idKategorijeProperty().get() == idKategorije)
                                .findFirst().orElse(null);

                        IzdavackaKuca selectedIK2 = izdavackaKucaLista.stream()
                                .filter(ik -> ik.izdavackaKucaIDProperty().get() == idIzdavackeKuce)
                                .findFirst().orElse(null);

                        if (selectedKategorija2 != null && selectedIK2 != null) {
                            Grad selectedGrad = gradLista.stream()
                                    .filter(g -> g.idGradaProperty().get() == Integer.parseInt(selectedIK2.idGradaProperty2().get()))
                                    .findFirst().orElse(null);

                            Drzava selectedDrzava = drzavaLista.stream()
                                    .filter(d -> d.idDrzaveProperty2().get() == selectedGrad.idGradaProperty().get())
                                    .findFirst().orElse(null);

                            List<Autor> listaAutora = new ArrayList<>();
                            Pattern pattern3 = Pattern.compile("ID Autora:\\s*(\\d+)");
                            for (String autorStr : odabirAutora2) {
                                Matcher matcher3 = pattern3.matcher(autorStr);
                                if (matcher3.find()) {
                                    int idAutora = Integer.parseInt(matcher3.group(1));
                                    autorLista.stream()
                                            .filter(a -> a.idAutoraProperty().get() == idAutora)
                                            .findFirst()
                                            .ifPresent(listaAutora::add);
                                }
                            }

                            if (selectedGrad != null && selectedDrzava != null) {
                                System.out.println("Pozvao sam funkciju");
                                updateKnjiga(idKnjige, nazivKnjige, selectedKategorija2, godinaIzdanja, selectedIK2, selectedGrad, selectedDrzava, listaAutora);
                            }
                        }
                    }
                }
                isbnUpdate.clear();
                nazivKnjigeUpdate.clear();
                godinaIzdavanjaKnjigeUpdate.clear();
                kategorijaUpdate.setValue("--Izaberi kategoriju--");
                IKUpdate.setValue("--Izaberi Izdavacku Kucu--");
            } else if(buttonStavkaKnjiga.isSelected()){
                int idStavkaKnjiga22 = Integer.parseInt(idStavkaKnjigaUpdate.getText());
                String odabirKnjige2 = knjigaUpdate2.getSelectionModel().getSelectedItem();
                String odabirBiblioteke2 = bibliotekaUpdate2.getSelectionModel().getSelectedItem();
                ObservableList<String> odabirAutora = izborAutora.getCheckModel().getCheckedItems();
                if(odabirKnjige2 != null && odabirBiblioteke2 != null){
                    Pattern pattern1 = Pattern.compile("ISBN Knjige:\\s*(\\d+)");
                    Matcher matcher = pattern1.matcher(odabirKnjige2);

                    Pattern pattern11 = Pattern.compile("ID Biblioteke:\\s*(\\d+)");
                    Matcher matcher2 = pattern11.matcher(odabirBiblioteke2);

                    if(matcher.find() && matcher2.find()){
                        int idString1 = Integer.parseInt(matcher.group(1));
                        int idString2 = Integer.parseInt(matcher2.group(1));

                        Knjiga selectedKnjiga = knjigaLista.stream()
                                .filter(k -> k.isbnProperty().get() == idString1)
                                .findFirst().orElse(null);
                        Biblioteka selectedBiblioteka = bibliotekaLista.stream()
                                .filter(b -> b.idBibliotekeProperty().get() == idString2)
                                .findFirst().orElse(null);
                        if(selectedKnjiga != null && selectedBiblioteka != null){
                            Kategorija selectedKategorija = kategorijaLista.stream()
                                    .filter(k -> k.idKategorijeProperty().get() == selectedKnjiga.idKategorijeProperty().get())
                                    .findFirst().orElse(null);

                            IzdavackaKuca selectedIK = izdavackaKucaLista.stream()
                                    .filter(ik -> ik.izdavackaKucaIDProperty().get() == selectedKnjiga.izdavackaKucaID2Property().get())
                                    .findFirst().orElse(null);
                            if(selectedKategorija != null && selectedIK != null){
                                Grad selectedGrad = gradLista.stream()
                                        .filter(g -> g.idGradaProperty().get() == Integer.parseInt(selectedIK.idGradaProperty2().get()))
                                        .findFirst().orElse(null);
                                Drzava selectedDrzava = drzavaLista.stream()
                                        .filter(d -> d.idDrzaveProperty2().get() == Integer.parseInt(selectedGrad.idDrzaveProperty().get()))
                                        .findFirst().orElse(null);
                                Grad selectedGradBiblioteka = gradLista.stream()
                                        .filter(g -> g.idGradaProperty().get() == selectedBiblioteka.idGradaBibliotekaProperty().get())
                                        .findFirst().orElse(null);
                                Drzava selectedDrzavaBiblioteka = drzavaLista.stream()
                                        .filter(d -> d.idDrzaveProperty2().get() == Integer.parseInt(selectedGradBiblioteka.idDrzaveProperty().get()))
                                        .findFirst().orElse(null);
                                List<Autor> autorList = new ArrayList<>();
                                Pattern pattern3 = Pattern.compile("ID Autora:\\s*(\\d+)");
                                for(String autorStr : odabirAutora){
                                    Matcher matcher3 = pattern3.matcher(autorStr);
                                    if (matcher3.find()) {
                                        int idAutora = Integer.parseInt(matcher3.group(1));
                                        autorLista.stream()
                                                .filter(a -> a.idAutoraProperty().get() == idAutora)
                                                .findFirst()
                                                .ifPresent(autorList::add);
                                    }
                                }
                                if (selectedGrad != null && selectedDrzava != null) {
                                    updateStavkaKnjiga(idStavkaKnjiga22, selectedKnjiga, selectedKategorija, selectedIK, selectedGrad, selectedDrzava, selectedBiblioteka, selectedGradBiblioteka, selectedDrzavaBiblioteka, autorList);
                                    //Knjiga knjiga, Kategorija kategorija, IzdavackaKuca izdavackaKuca, Grad grad2, Drzava drzava2, Biblioteka biblioteka, Grad grad3, Drzava drzava3, List<Autor> autori
                                }
                            }
                        }
                    }
                }
                idStavkaKnjigaUpdate.clear();
                knjigaUpdate2.setValue("--Izaberi knjigu--");
                bibliotekaUpdate2.setValue("--Izaberi biblioteku--");
            }
        });
        //Delete sa baze podataka
        submitDelete.setOnAction(event -> {
            if(optionAutor.isSelected()){
                int idAutora = Integer.parseInt(idAutoraDelete.getText());
                deleteAutor(idAutora);
                idAutoraDelete.clear();
                imeAutoraDelete.clear();
                prezimeAutoraDelete.clear();
                godineAutoraDelete.clear();
            } else if(optionBiblioteka.isSelected()){
                int idBiblioteke = Integer.parseInt(idBibliotekeDelete.getText());
                deleteBiblioteka(idBiblioteke);
                idBibliotekeDelete.clear();
                nazivBibliotekeDelete.clear();
                adresaBibliotekeDelete.clear();
                gradDelete.setValue("");
            } else if(optionDrzava.isSelected()){
                int idDrzave = Integer.parseInt(idDrzaveDelete.getText());
                deleteDrzava(idDrzave);
                idDrzaveDelete.clear();
                nazivDrzaveDelete.clear();
            } else if(optionGrad.isSelected()){
                int idGrada = Integer.parseInt(idGradaDelete.getText());
                deleteGrad(idGrada);
                idGradaDelete.clear();
                nazivGradaDelete.clear();
                postanskiBrojDelete.clear();
                drzavaDelete3.setValue("--Izaberi drzavu--");
            } else if(optionIzdavackaKuca.isSelected()){
                int idIK = Integer.parseInt(idIKDelete.getText());
                deleteIK(idIK);
                idIKDelete.clear();
                nazivIKDelete.clear();
                gradDelete33.setValue("--Izaberi Izdavacku Kucu--");
            } else if(optionKategorija.isSelected()){
                int idKategorije = Integer.parseInt(idKategorijeDelete.getText());
                deleteKategorija(idKategorije);
                idKategorijeDelete.clear();
                nazivKategorijeDelete.clear();
            } else if(optionKnjiga.isSelected()){
                int idKnjige = Integer.parseInt(isbnDelete.getText());
                deleteKnjiga(idKnjige);
                isbnDelete.clear();
                nazivKnjigeDelete.clear();
                kategorijaDelete.setValue("--Izaberi kategoriju--");
                godinaIzdavanjaKnjigeDelete.clear();
                IKDelete.setValue("--Izaberi Izdavacku Kucu--");
            } else if(optionStavkaKnjiga.isSelected()){
                int idSK = Integer.parseInt(idStavkaKnjigaDelete.getText());
                deleteStavkaKnjiga(idSK);
                idStavkaKnjigaDelete.clear();
                knjigaDelete2.setValue("--Izaberi knjigu--");
                bibliotekaDelete2.setValue("--Izaberi biblioteku--");
            }
        });

        //*******Zavrsetak********

        /*tableAutor.getColumns().add(idAutora);
        tableAutor.getColumns().add(imeAutora);
        tableAutor.getColumns().add(prezimeAutora);
        tableAutor.getColumns().add(godineAutora);

        stackTabela.getChildren().add(tableAutor);*/

        /*create2.setDisable(false);
        create21.setDisable(true);
        create22.setDisable(true);
        create23.setDisable(true);

        create2.getItems().addAll("Autor", "Biblioteka", "Drzava", "Grad", "Izdavacka Kuca", "Kategorija", "Knjiga", "Stavka Knjiga");
        create21.getItems().addAll("Autor", "Biblioteka", "Drzava", "Grad", "Izdavacka Kuca", "Kategorija", "Knjiga", "Stavka Knjiga");
        create22.getItems().addAll("Autor", "Biblioteka", "Drzava", "Grad", "Izdavacka Kuca", "Kategorija", "Knjiga", "Stavka Knjiga");
        create23.getItems().addAll("Autor", "Biblioteka", "Drzava", "Grad", "Izdavacka Kuca", "Kategorija", "Knjiga", "Stavka Knjiga");

        create2.setValue("Autor"); //po default-u*/
        paneAutor.setVisible(true);
        paneBiblioteka.setVisible(false);
        paneDrzava.setVisible(false);
        paneGrad.setVisible(false);
        paneIK.setVisible(false);
        paneKategorija.setVisible(false);
        paneKnjiga.setVisible(false);
        paneStavkaKnjiga.setVisible(false);

        //za kasnije, remeti u read jer sklanja sve tabele osim autora
        /*tableAutor2.setVisible(true);
        tableBiblioteka2.setVisible(false);
        tableDrzava2.setVisible(false);
        tableGrad2.setVisible(false);
        tableIK2.setVisible(false);
        tableKategorija2.setVisible(false);
        tableKnjiga2.setVisible(false);
        tableStavkaKnjiga2.setVisible(false);*/

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    RadioButton izabraniButton = (RadioButton) newValue;
                    if(izabraniButton.equals(optionAutor)){
                        paneAutor.setVisible(true);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);

                        tableAutor2.setVisible(true);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionBiblioteka)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(true);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(true);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionDrzava)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(true);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);
                        tableDrzava2.setVisible(true);
                        tableStavkaKnjiga2.setVisible(false);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(true);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionGrad)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(true);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);
                        tableGrad2.setVisible(true);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(true);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionIzdavackaKuca)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(true);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);
                        tableIK2.setVisible(true);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(true);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionKategorija)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(true);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(false);
                        tableKategorija2.setVisible(true);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(true);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionKnjiga)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(true);
                        paneStavkaKnjiga.setVisible(false);
                        tableKnjiga2.setVisible(true);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(true);
                        tableStavkaKnjiga2.setVisible(false);
                    } else if(izabraniButton.equals(optionStavkaKnjiga)){
                        paneAutor.setVisible(false);
                        paneBiblioteka.setVisible(false);
                        paneDrzava.setVisible(false);
                        paneGrad.setVisible(false);
                        paneIK.setVisible(false);
                        paneKategorija.setVisible(false);
                        paneKnjiga.setVisible(false);
                        paneStavkaKnjiga.setVisible(true);

                        tableAutor2.setVisible(false);
                        tableBiblioteka2.setVisible(false);
                        tableDrzava2.setVisible(false);
                        tableGrad2.setVisible(false);
                        tableIK2.setVisible(false);
                        tableKategorija2.setVisible(false);
                        tableKnjiga2.setVisible(false);
                        tableStavkaKnjiga2.setVisible(true);
                    }
                }
            }
        });
    }
    private void fillFieldsAutor(Autor autor){
        idAutoraUpdate.setText(String.valueOf(autor.idAutoraProperty().getValue()));
        imeAutoraUpdate.setText(autor.imeAutoraProperty().getValue());
        prezimeAutoraUpdate.setText(autor.prezimeAutoraProperty().getValue());
        godineAutoraUpdate.setText(String.valueOf(autor.godineAutoraProperty().getValue()));

        idAutoraDelete.setText(String.valueOf(autor.idAutoraProperty().getValue()));
        imeAutoraDelete.setText(autor.imeAutoraProperty().getValue());
        prezimeAutoraDelete.setText(autor.prezimeAutoraProperty().getValue());
        godineAutoraDelete.setText(String.valueOf(autor.godineAutoraProperty().getValue()));
    }
    private void fillFieldsBiblioteka(Biblioteka biblioteka){
        for(Grad grad : gradLista){
            if(grad.idGradaProperty().getValue().equals(biblioteka.idGradaBibliotekaProperty().getValue())){
                idBibliotekeUpdate.setText(String.valueOf(biblioteka.idBibliotekeProperty().getValue()));
                nazivBibliotekeUpdate.setText(biblioteka.nazivBibliotekeProperty().getValue());
                adresaBibliotekeUpdate.setText(biblioteka.adresaBibliotekeProperty().getValue());
                gradUpdate3.setValue(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));

                idBibliotekeDelete.setText(String.valueOf(biblioteka.idBibliotekeProperty().getValue()));
                nazivBibliotekeDelete.setText(biblioteka.nazivBibliotekeProperty().getValue());
                adresaBibliotekeDelete.setText(biblioteka.adresaBibliotekeProperty().getValue());
                gradDelete.setValue(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
            }
        }
    }
    private void fillFieldsDrzava(Drzava drzava){
        idDrzaveUpdate.setText(String.valueOf(drzava.idDrzaveProperty2().getValue()));
        nazivDrzaveUpdate.setText(drzava.nazivDrzaveProperty().getValue());

        idDrzaveDelete.setText(String.valueOf(drzava.idDrzaveProperty2().getValue()));
        nazivDrzaveDelete.setText(drzava.nazivDrzaveProperty().getValue());
    }
    private void fillFieldsGrad(Grad grad){
        for(Drzava drzava1 : drzavaLista){
            if(drzava1.idDrzaveProperty2().getValue().equals(Integer.parseInt(grad.idDrzaveProperty().getValue()))){
                idGradaUpdate.setText(String.valueOf(grad.idGradaProperty().getValue()));
                nazivGradaUpdate.setText(grad.nazivGradaProperty().getValue());
                postanskiBrojUpdate.setText(grad.postanskiBrojProperty().getValue());
                drzavaUpdate3.setValue(String.format("ID Drzave: %s Naziv Drzave: %s", drzava1.idDrzaveProperty2().get(), drzava1.nazivDrzaveProperty().get()));

                idGradaDelete.setText(String.valueOf(grad.idGradaProperty().getValue()));
                nazivGradaDelete.setText(grad.nazivGradaProperty().getValue());
                postanskiBrojDelete.setText(grad.postanskiBrojProperty().getValue());
                drzavaDelete3.setValue(String.format("ID Drzave: %s Naziv Drzave: %s", drzava1.idDrzaveProperty2().get(), drzava1.nazivDrzaveProperty().get()));
            }
        }
    }
    private void fillFieldsIK(IzdavackaKuca izdavackaKuca){
        for(Grad grad : gradLista){
            if(grad.idGradaProperty().getValue().equals(Integer.parseInt(izdavackaKuca.idGradaProperty2().getValue()))){
                idIKUpdate.setText(String.valueOf(izdavackaKuca.izdavackaKucaIDProperty().getValue()));
                nazivIKUpdate.setText(izdavackaKuca.nazivIzdavackeKuceProperty().getValue());
                gradUpdate33.setValue(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));

                idIKDelete.setText(String.valueOf(izdavackaKuca.izdavackaKucaIDProperty().getValue()));
                nazivIKDelete.setText(izdavackaKuca.nazivIzdavackeKuceProperty().getValue());
                gradDelete33.setValue(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
            }
        }
    }
    private void fillFieldsKategorija(Kategorija kategorija){
        idKategorijeUpdate.setText(String.valueOf(kategorija.idKategorijeProperty().getValue()));
        nazivKategorijeUpdate.setText(kategorija.nazivKategorijeProperty().getValue());

        idKategorijeDelete.setText(String.valueOf(kategorija.idKategorijeProperty().getValue()));
        nazivKategorijeDelete.setText(kategorija.nazivKategorijeProperty().getValue());
    }
    private void fillFieldsKnjiga(Knjiga knjiga){
        for (IzdavackaKuca ik2 : izdavackaKucaLista) {
            if(ik2.izdavackaKucaIDProperty().getValue().equals(Integer.valueOf(knjiga.izdavackaKucaID2Property().getValue()))){
                isbnUpdate.setText(String.valueOf(knjiga.isbnProperty().getValue()));
                nazivKnjigeUpdate.setText(knjiga.nazivKnjigeProperty().getValue());
                kategorijaUpdate.setValue(String.format("ID Kategorije: %d Naziv Kategorije: %s", Integer.valueOf(knjiga.idKategorijeProperty().getValue()), knjiga.nazivKnjigeProperty().getValue()));
                godinaIzdavanjaKnjigeUpdate.setText(String.valueOf(knjiga.godinaIzdavanjaProperty().getValue()));
                IKUpdate.setValue(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", knjiga.izdavackaKucaID2Property().getValue(), ik2.nazivIzdavackeKuceProperty().getValue()));
                //ovde si stao (dodaj click event za autore u update i delete)
                izborAutoraUpdate.getCheckModel().clearChecks();
                String autoriString = knjiga.getAutoriProperty().get();
                if (autoriString != null && !autoriString.isEmpty()) {
                    String[] autoriNiz = autoriString.split(",");

                    for (String autor : autoriNiz) {
                        String autorTrimovan = autor.trim();
                        for (String item : izborAutoraUpdate.getItems()) {
                            if (item.contains("Ime Autora: " + autorTrimovan.split(" ")[0]) &&
                                item.contains("Prezime Autora: " + autorTrimovan.split(" ")[1])) {
                                izborAutoraUpdate.getCheckModel().check(item);
                                break;
                            }
                        }
                    }
                }


                isbnDelete.setText(String.valueOf(knjiga.isbnProperty().getValue()));
                nazivKnjigeDelete.setText(knjiga.nazivKnjigeProperty().getValue());
                kategorijaDelete.setValue(String.format("ID Kategorije: %d Naziv Kategorije: %s", Integer.valueOf(knjiga.idKategorijeProperty().getValue()), knjiga.nazivKnjigeProperty().getValue()));
                godinaIzdavanjaKnjigeDelete.setText(String.valueOf(knjiga.godinaIzdavanjaProperty().getValue()));
                IKDelete.setValue(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", knjiga.izdavackaKucaID2Property().getValue(), ik2.nazivIzdavackeKuceProperty().getValue()));
                izborAutoraDelete.getCheckModel().clearChecks();
                String autoriString2 = knjiga.getAutoriProperty().get();
                if(autoriString2 != null && !autoriString2.isEmpty()){
                    String[] autoriNiz2 = autoriString2.split(",");

                    for(String autor : autoriNiz2){
                        String autorTrimovan2 = autor.trim();
                        for(String item : izborAutoraDelete.getItems()){
                            if(item.contains("Ime Autora: " + autorTrimovan2.split(" ")[0]) &&
                                item.contains("Prezime Autora: " + autorTrimovan2.split(" ")[1])){
                                izborAutoraDelete.getCheckModel().check(item);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    private void fillFieldsStavkaKnjiga(StavkaKnjige stavkaKnjige){
        for(Knjiga knjiga : knjigaLista){
            if(knjiga.isbnProperty().getValue().equals(Integer.valueOf(stavkaKnjige.isbnProperty().getValue()))){
                for(Biblioteka biblioteka : bibliotekaLista){
                    if(biblioteka.idBibliotekeProperty().getValue().equals(Integer.valueOf(stavkaKnjige.idBibliotekeProperty().getValue()))){
                        idStavkaKnjigaUpdate.setText(String.valueOf(stavkaKnjige.stavkaKnjigeIDProperty().getValue()));
                        knjigaUpdate2.setValue(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
                        bibliotekaUpdate2.setValue(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));

                        idStavkaKnjigaDelete.setText(String.valueOf(stavkaKnjige.stavkaKnjigeIDProperty().getValue()));
                        knjigaDelete2.setValue(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
                        bibliotekaDelete2.setValue(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
                    }
                }
            }
        }
    }
    private void addAutor(String imeAutora2, String prezimeAutora2, Integer godineAutora2) {
        try {
            URL url = new URL("http://localhost:8080/createAutor");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"ime_autora\": \"%s\", \"prezime_autora\": \"%s\", \"godine_autora\": %d}", imeAutora2, prezimeAutora2, godineAutora2);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                loadAutori();
                /*submitCreate.setOnAction(e -> {
                    izborAutora.getItems().addLast(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s"));
                });*/
                izborAutora.getItems().clear();
                for(Autor autor : autorLista){
                    izborAutora.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreiran je novi Autor pod ID-jem: ").append(autorLista.getLast().idAutoraProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreiran je novi Autor pod ID-jem: " + autorLista.getLast().idAutoraProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBiblioteka(String nazivBiblioteke, String adresaBiblioteke, Grad grad, Drzava drzava){
        try{
            URL url = new URL("http://localhost:8080/createBiblioteka");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            //Drzava drzava = new Drzava(1, "Srbija");
            String drzavaJSON = "{" +
                    "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                    "}";

            String jsonInputString =
                    "{" +
                            "\"naziv_biblioteke\": \"" + nazivBiblioteke + "\"," +
                            "\"adresa_biblioteke\": \"" + adresaBiblioteke + "\"," +
                            "\"grad\": {" +
                            "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                            "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                            "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                            "\"drzava\": " + drzavaJSON +
                            "}" +
                            "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);
            System.out.println("Ovo je id grada: " + idGrada);
            System.out.println("ovo je json:" + jsonInputString);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadBiblioteke();
                odabirBiblioteke.getItems().clear();
                odabirBiblioteke.setValue("--Izaberi biblioteku--");
                odabirBiblioteke.getItems().add("--Izaberi biblioteku--");
                for(Biblioteka biblioteka : bibliotekaLista){
                    odabirBiblioteke.getItems().add(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Biblioteka pod ID-jem: ").append(bibliotekaLista.getLast().idBibliotekeProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Biblioteka pod ID-jem: " + bibliotekaLista.getLast().idBibliotekeProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addDrzava(String nazivDrzave){
        try{
            URL url = new URL("http://localhost:8080/createDrzava");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"naziv_drzave\": \"%s\"}", nazivDrzave);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                loadDrzave();
                izborDrzave.getItems().clear();
                izborDrzave.setValue("--Izaberi drzavu--");
                izborDrzave.getItems().add("--Izaberi drzavu--");
                for(Drzava drzava : drzavaLista){
                    izborDrzave.getItems().add(String.format("ID Drzave: %s Naziv Drzave: %s", drzava.idDrzaveProperty2().get(), drzava.nazivDrzaveProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Drzava pod ID-jem: ").append(drzavaLista.getLast().idDrzaveProperty2().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Drzava pod ID-jem: " + drzavaLista.getLast().idDrzaveProperty2().get() + "\n";
                writeToFile(argFile);
            }

            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addGrad(String nazivGrada, String postanskiBroj, Drzava drzava){
        try{
            URL url = new URL("http://localhost:8080/createGrad");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString =
                    "{" +
                            "\"naziv_grada\": \"" + nazivGrada + "\"," +
                            "\"postanski_broj\": \"" + postanskiBroj + "\"," +
                            "\"drzava\": {" +
                            "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                            "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                            "}" +
                    "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);
            System.out.println("Ovo je id grada: " + idGrada);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadGrad();
                izborGradova.getItems().clear();
                izborGradova.setValue("--Izaberi grad--");
                izborGradova.getItems().add("--Izaberi grad--");
                for(Grad grad : gradLista){
                    izborGradova.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreiran je novi Grad pod ID-jem: ").append(gradLista.getLast().idGradaProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreiran je novi Grad pod ID-jem: " + gradLista.getLast().idGradaProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addIzdavackaKuca(String nazivIK, Grad grad, Drzava drzava){
        try {
            URL url = new URL("http://localhost:8080/createIzdavackaKuca");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String drzavaJSON = "{" +
                    "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                    "}";

            String jsonInputString =
                    "{" +
                            "\"naziv_izdavacke_kuce\": \"" + nazivIK + "\"," +
                            "\"grad\": {" +
                            "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                            "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                            "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                            "\"drzava\": " + drzavaJSON +
                            "}" +
                            "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);
            System.out.println("Ovo je id grada: " + idGrada);
            System.out.println("ovo je json:" + jsonInputString);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadIzdavackaKuca();
                izborIK2.getItems().clear();
                izborIK2.setValue("--Izaberi Izdavacku Kucu--");
                izborIK2.getItems().add("--Izaberi Izdavacku Kucu--");
                for(IzdavackaKuca izdavackaKuca : izdavackaKucaLista){
                    izborIK2.getItems().add(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", izdavackaKuca.izdavackaKucaIDProperty().get(), izdavackaKuca.nazivIzdavackeKuceProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Izdavacka Kuca pod ID-jem: ").append(izdavackaKucaLista.getLast().izdavackaKucaIDProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Izdavacka Kuca pod ID-jem: " + izdavackaKucaLista.getLast().izdavackaKucaIDProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addKategorija(String nazivKategorije){
        try {
            URL url = new URL("http://localhost:8080/createKategorija");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"naziv_kategorije\": \"%s\"}", nazivKategorije);
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKategorije();
                izborKategorije.getItems().clear();
                izborKategorije.setValue("--Izaberi kategoriju--");
                izborKategorije.getItems().add("--Izaberi kategoriju--");
                for(Kategorija kategorija : kategorijaLista){
                    izborKategorije.getItems().add(String.format("ID Kategorije: %s Naziv Kategorije: %s", kategorija.idKategorijeProperty().get(), kategorija.nazivKategorijeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Kategorija pod ID-jem: ").append(kategorijaLista.getLast().idKategorijeProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Kategorija pod ID-jem: " + kategorijaLista.getLast().idKategorijeProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addKnjiga(String nazivKnjige, Kategorija kategorija, String godinaIzdavanja, IzdavackaKuca izdavackaKuca, Grad grad, Drzava drzava, List<Autor> autori){
        try{
            URL url = new URL("http://localhost:8080/createKnjiga");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String kategorijaJSON = "{" +
                    "\"id_kategorije\": " + kategorija.idKategorijeProperty().getValue() + "," +
                    "\"naziv_kategorije\": \"" + kategorija.nazivKategorijeProperty().getValue() + "\"" +
                    "}";
            List<String> autorList = new ArrayList<>();
            for(Autor autor : autori){
                String autorJSON2 = "{" +
                        "\"id_autora\": " + autor.idAutoraProperty().getValue() + "," +
                        "\"ime_autora\": \"" + autor.imeAutoraProperty().getValue() + "\"," +
                        "\"prezime_autora\": \"" + autor.prezimeAutoraProperty().getValue() + "\"," +
                        "\"godine_autora\": \"" + autor.godineAutoraProperty().getValue() + "\"" +
                        "}";
                autorList.add(autorJSON2);
            }
            String autorJSON = "[" +
                    String.join(",", autorList) + "]";
            String izdavackaKucaJSON = "{" +
                    "\"izdavacka_kuca_id\": " + izdavackaKuca.izdavackaKucaIDProperty().getValue() + "," +
                    "\"naziv_izdavacke_kuce\": \"" + izdavackaKuca.nazivIzdavackeKuceProperty().getValue() + "\"," +
                    "\"grad\": {" +
                        "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                        "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                        "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                        "\"drzava\": {" +
                            "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                            "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                            "}" +
                        "}" +
                    "}";
            String jsonInputString = "{" +
                    "\"naziv_Knjige\": \"" + nazivKnjige + "\"," +
                    "\"kategorija\": " + kategorijaJSON + "," +
                    "\"godina_Izdavanja\": " + godinaIzdavanja + "," +
                    "\"izdavackaKuca\": " + izdavackaKucaJSON + "," +
                    "\"autor\": " + autorJSON +
                    "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            System.out.println("Ovo je kategorija JSON " + kategorijaJSON);
            System.out.println("Ovo je izdavacka kuca JSON" + izdavackaKucaJSON);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKnjige();
                odabirKnjige.getItems().clear();
                odabirKnjige.setValue("--Izaberi knjigu--");
                odabirKnjige.getItems().add("--Izaberi knjigu--");
                for(Knjiga knjiga : knjigaLista){
                    odabirKnjige.getItems().add(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Knjiga pod ID-jem: ").append(knjigaLista.getLast().isbnProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Knjiga pod ID-jem: " + knjigaLista.getLast().isbnProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addStavkaKnjiga(Knjiga knjiga, Kategorija kategorija, IzdavackaKuca izdavackaKuca, Grad grad2, Drzava drzava2, Biblioteka biblioteka, Grad grad3, Drzava drzava3, List<Autor> autori){
        try {
            URL url = new URL("http://localhost:8080/createStavkaKnjige");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            List<String> autorList = new ArrayList<>();
            for(Autor autor : autori){
                String autorJSON2 = "{" +
                        "\"id_autora\": " + autor.idAutoraProperty().getValue() + "," +
                        "\"ime_autora\": \"" + autor.imeAutoraProperty().getValue() + "\"," +
                        "\"prezime_autora\": \"" + autor.prezimeAutoraProperty().getValue() + "\"," +
                        "\"godine_autora\": \"" + autor.godineAutoraProperty().getValue() + "\"" +
                        "}";
                autorList.add(autorJSON2);
            }
            String autorJSON = "[" +
                    String.join(",", autorList) + "]";
            String knjigaJSON = "{" +
                    "\"isbn\": " + knjiga.isbnProperty().getValue() + "," +
                    "\"naziv_Knjige\": \"" + knjiga.nazivKnjigeProperty().getValue() + "\"," +
                    "\"autor\": " +
                        autorJSON +
                    "," +
                    "\"kategorija\": {" +
                        "\"id_kategorije\": " + kategorija.idKategorijeProperty().getValue() + "," +
                        "\"naziv_kategorije\": \"" + kategorija.nazivKategorijeProperty().getValue() + "\"" +
                        "}," +
                    "\"godina_Izdavanja\": " + knjiga.godinaIzdavanjaProperty().getValue() + "," +
                    "\"izdavackaKuca\": {" +
                        "\"izdavacka_kuca_id\": " + izdavackaKuca.izdavackaKucaIDProperty().getValue() + "," +
                        "\"naziv_izdavacke_kuce\": \"" + izdavackaKuca.nazivIzdavackeKuceProperty().getValue() + "\"," +
                        "\"grad\": {" +
                            "\"id_grada\": " + grad2.idGradaProperty().getValue() + "," +
                            "\"naziv_grada\": \"" + grad2.nazivGradaProperty().getValue() + "\"," +
                            "\"postanski_broj\": \"" + grad2.postanskiBrojProperty().getValue() + "\"," +
                            "\"drzava\": {" +
                                "\"id_drzave\": " + drzava2.idDrzaveProperty2().getValue() + "," +
                                "\"naziv_drzave\": \"" + drzava2.nazivDrzaveProperty().getValue() + "\"" +
                            "}" +
                        "}" +
                    "}" +
                    "}";

            String bibliotekaJSON = "{" +
                    "\"id_biblioteke\": " + biblioteka.idBibliotekeProperty().getValue() + "," +
                    "\"naziv_biblioteke\": \"" + biblioteka.nazivBibliotekeProperty().getValue() + "\"," +
                    "\"adresa_biblioteke\": \"" + biblioteka.adresaBibliotekeProperty().getValue() + "\"," +
                    "\"grad\": {" +
                        "\"id_grada\": " + grad3.idGradaProperty().getValue() + "," +
                        "\"naziv_grada\": \"" + grad3.nazivGradaProperty().getValue() + "\"," +
                        "\"postanski_broj\": \"" + grad3.postanskiBrojProperty().getValue() + "\"," +
                        "\"drzava\": {" +
                            "\"id_drzave\": " + drzava3.idDrzaveProperty2().getValue() + "," +
                            "\"naziv_drzave\": \"" + drzava3.nazivDrzaveProperty().getValue() + "\"" +
                        "}" +
                    "}" +
                    "}";

            String jsonInputString = "{" +
                    "\"knjiga\": " + knjigaJSON + "," +
                    "\"biblioteka\": " + bibliotekaJSON +
                    "}";

            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            System.out.println("Ovo je knjiga JSON " + knjigaJSON);
            System.out.println("Ovo je biblioteka kuca JSON" + bibliotekaJSON);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            System.out.println(jsonInputString);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadStavkaKnjiga();
                String text = formatter.format(now);
                textContent2.append(text).append(" Kreirana je nova Stavka Knjiga pod ID-jem: ").append(stavkaKnjigeLista.getLast().stavkaKnjigeIDProperty().get()).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Kreirana je nova Stavka Knjiga pod ID-jem: " + stavkaKnjigeLista.getLast().stavkaKnjigeIDProperty().get() + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateAutor(int idAutora, String imeAutora21, String prezimeAutora21, Integer godineAutora21){
        try {
            URL url = new URL("http://localhost:8080/updateAutor/" + idAutora);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"id_autora\": \"%d\", \"ime_autora\": \"%s\", \"prezime_autora\": \"%s\", \"godine_autora\": %d}", idAutora, imeAutora21, prezimeAutora21, godineAutora21);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("PUT Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                loadAutori();
                izborAutoraUpdate.getItems().clear();
                for(Autor autor : autorLista){
                    izborAutoraUpdate.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azuriran je Autor pod ID-jem: ").append(idAutora).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azuriran je Autor pod ID-jem: " + idAutora + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateBiblioteka(int idBiblioteke, String nazivBiblioteke, String adresaBiblioteke, Grad grad, Drzava drzava){
        try{
            URL url = new URL("http://localhost:8080/updateBiblioteka/" + idBiblioteke);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String drzavaJSON = "{" +
                    "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                    "}";

            String jsonInputString =
                    "{" +
                            "\"id_biblioteke\": \"" + idBiblioteke + "\"," +
                            "\"naziv_biblioteke\": \"" + nazivBiblioteke + "\"," +
                            "\"adresa_biblioteke\": \"" + adresaBiblioteke + "\"," +
                            "\"grad\": {" +
                            "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                            "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                            "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                            "\"drzava\": " + drzavaJSON +
                            "}" +
                            "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadBiblioteke();
                bibliotekaUpdate2.getItems().clear();
                bibliotekaUpdate2.setValue("--Izaberi biblioteku--");
                bibliotekaUpdate2.getItems().add("--Izaberi biblioteku--");
                for(Biblioteka biblioteka : bibliotekaLista){
                    bibliotekaUpdate2.getItems().add(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Biblioteka pod ID-jem: ").append(idBiblioteke).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azurirana je Biblioteka pod ID-jem: " + idBiblioteke + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateDrzava(int idDrzave, String nazivDrzave){
        try{
            URL url = new URL("http://localhost:8080/updateDrzava/" + idDrzave);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"id_drzave\": \"%d\", \"naziv_drzave\": \"%s\"}", idDrzave, nazivDrzave);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                loadDrzave();
                drzavaUpdate3.getItems().clear();
                drzavaUpdate3.setValue("--Izaberi drzavu--");
                drzavaUpdate3.getItems().add("--Izaberi drzavu--");
                for(Drzava drzava : drzavaLista){
                    drzavaUpdate3.getItems().add(String.format("ID Drzave: %s Naziv Drzave: %s", drzava.idDrzaveProperty2().get(), drzava.nazivDrzaveProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Drzava pod ID-jem: ").append(idDrzave).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azurirana je Drzava pod ID-jem: " + idDrzave + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateGrad(int idGrada, String nazivGrada, String postanskiBroj, Drzava drzava){
        try{
            URL url = new URL("http://localhost:8080/updateGrad/" + idGrada);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString =
                    "{" +
                            "\"id_grada\": \"" + idGrada + "\"," +
                            "\"naziv_grada\": \"" + nazivGrada + "\"," +
                            "\"postanski_broj\": \"" + postanskiBroj + "\"," +
                            "\"drzava\": {" +
                            "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                            "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                            "}" +
                            "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadGrad();
                gradUpdate3.getItems().clear();
                gradUpdate33.getItems().clear();
                gradUpdate3.setValue("--Izaberi grad--");
                gradUpdate3.getItems().add("--Izaberi grad--");
                gradUpdate33.setValue("--Izaberi grad--");
                gradUpdate33.getItems().add("--Izaberi grad--");
                for(Grad grad : gradLista){
                    gradUpdate3.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
                    gradUpdate33.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azuriran je Grad pod ID-jem: ").append(idGrada).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azuriran je Grad pod ID-jem: " + idGrada + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateIzdavackaKuca(int idIK, String nazivIzdavackeKuce, Grad grad, Drzava drzava){
        try {
            URL url = new URL("http://localhost:8080/updateIzdavackaKuca/" + idIK);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String drzavaJSON = "{" +
                    "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                    "}";

            String jsonInputString =
                    "{" +
                            "\"izdavacka_kuca_id\": \"" + idIK + "\"," +
                            "\"naziv_izdavacke_kuce\": \"" + nazivIzdavackeKuce + "\"," +
                            "\"grad\": {" +
                            "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                            "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                            "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                            "\"drzava\": " + drzavaJSON +
                            "}" +
                            "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadIzdavackaKuca();
                IKUpdate.getItems().clear();
                IKUpdate.setValue("--Izaberi Izdavacku Kucu--");
                IKUpdate.getItems().add("--Izaberi Izdavacku Kucu--");
                for(IzdavackaKuca izdavackaKuca : izdavackaKucaLista){
                    IKUpdate.getItems().add(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", izdavackaKuca.izdavackaKucaIDProperty().get(), izdavackaKuca.nazivIzdavackeKuceProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Izdavacka Kuca pod ID-jem: ").append(idIK).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azuriran je Grad pod ID-jem: " + idIK + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateKategorija(int idKategorije, String nazivKategorije){
        try {
            URL url = new URL("http://localhost:8080/updateKategorija/" + idKategorije);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"id_kategorije\": \"%d\", \"naziv_kategorije\": \"%s\"}", idKategorije, nazivKategorije);
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKategorije();
                kategorijaUpdate.getItems().clear();
                kategorijaUpdate.setValue("--Izaberi kategoriju--");
                kategorijaUpdate.getItems().add("--Izaberi kategoriju--");
                for(Kategorija kategorija : kategorijaLista){
                    kategorijaUpdate.getItems().add(String.format("ID Kategorije: %s Naziv Kategorije: %s", kategorija.idKategorijeProperty().get(), kategorija.nazivKategorijeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Kategorija pod ID-jem: ").append(idKategorije).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azurirana je Kategorija pod ID-jem: " + idKategorije + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateKnjiga(int idKnjige, String nazivKnjige, Kategorija kategorija, String godinaIzdavanja, IzdavackaKuca izdavackaKuca, Grad grad, Drzava drzava, List<Autor> autori){
        try{
            URL url = new URL("http://localhost:8080/updateKnjiga/" + idKnjige);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String kategorijaJSON = "{" +
                    "\"id_kategorije\": " + kategorija.idKategorijeProperty().getValue() + "," +
                    "\"naziv_kategorije\": \"" + kategorija.nazivKategorijeProperty().getValue() + "\"" +
                    "}";
            List<String> autorList = new ArrayList<>();
            for(Autor autor : autori){
                String autorJSON2 = "{" +
                        "\"id_autora\": " + autor.idAutoraProperty().getValue() + "," +
                        "\"ime_autora\": \"" + autor.imeAutoraProperty().getValue() + "\"," +
                        "\"prezime_autora\": \"" + autor.prezimeAutoraProperty().getValue() + "\"," +
                        "\"godine_autora\": \"" + autor.godineAutoraProperty().getValue() + "\"" +
                        "}";
                autorList.add(autorJSON2);
            }
            String autorJSON = "[" +
                    String.join(",", autorList) + "]";
            String izdavackaKucaJSON = "{" +
                    "\"izdavacka_kuca_id\": " + izdavackaKuca.izdavackaKucaIDProperty().getValue() + "," +
                    "\"naziv_izdavacke_kuce\": \"" + izdavackaKuca.nazivIzdavackeKuceProperty().getValue() + "\"," +
                    "\"grad\": {" +
                    "\"id_grada\": " + grad.idGradaProperty().getValue() + "," +
                    "\"naziv_grada\": \"" + grad.nazivGradaProperty().getValue() + "\"," +
                    "\"postanski_broj\": \"" + grad.postanskiBrojProperty().getValue() + "\"," +
                    "\"drzava\": {" +
                    "\"id_drzave\": " + drzava.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava.nazivDrzaveProperty().getValue() + "\"" +
                    "}" +
                    "}" +
                    "}";
            String jsonInputString = "{" +
                    "\"isbn\": \"" + idKnjige + "\"," +
                    "\"naziv_Knjige\": \"" + nazivKnjige + "\"," +
                    "\"autor\":" + autorJSON + "," +
                    "\"kategorija\": " + kategorijaJSON + "," +
                    "\"godina_Izdavanja\": " + godinaIzdavanja + "," +
                    "\"izdavackaKuca\": " + izdavackaKucaJSON +
                    "}";
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKnjige();
                knjigaUpdate2.getItems().clear();
                knjigaUpdate2.setValue("--Izaberi knjigu--");
                knjigaUpdate2.getItems().add("--Izaberi knjigu--");
                for(Knjiga knjiga : knjigaLista){
                    knjigaUpdate2.getItems().add(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Knjiga pod ID-jem: ").append(idKnjige).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azurirana je Knjiga pod ID-jem: " + idKnjige + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void updateStavkaKnjiga(int idStavkaKnjiga22, Knjiga knjiga, Kategorija kategorija, IzdavackaKuca izdavackaKuca2, Grad grad2, Drzava drzava2, Biblioteka biblioteka, Grad grad3, Drzava drzava3, List<Autor> autori){
        try {
            URL url = new URL("http://localhost:8080/updateStavkaKnjige/" + idStavkaKnjiga22);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            List<String> autorList = new ArrayList<>();
            for(Autor autor : autori){
                String autorJSON2 = "{" +
                        "\"id_autora\": " + autor.idAutoraProperty().getValue() + "," +
                        "\"ime_autora\": \"" + autor.imeAutoraProperty().getValue() + "\"," +
                        "\"prezime_autora\": \"" + autor.prezimeAutoraProperty().getValue() + "\"," +
                        "\"godine_autora\": \"" + autor.godineAutoraProperty().getValue() + "\"" +
                        "}";
                autorList.add(autorJSON2);
            }
            String autorJSON = "[" +
                    String.join(",", autorList) + "]";
            String knjigaJSON = "{" +
                    "\"isbn\": " + knjiga.isbnProperty().getValue() + "," +
                    "\"naziv_Knjige\": \"" + knjiga.nazivKnjigeProperty().getValue() + "\"," +
                    "\"autor\": " +
                    autorJSON +
                    "," +
                    "\"kategorija\": {" +
                    "\"id_kategorije\": " + kategorija.idKategorijeProperty().getValue() + "," +
                    "\"naziv_kategorije\": \"" + kategorija.nazivKategorijeProperty().getValue() + "\"" +
                    "}," +
                    "\"godina_Izdavanja\": " + knjiga.godinaIzdavanjaProperty().getValue() + "," +
                    "\"izdavackaKuca\": {" +
                    "\"izdavacka_kuca_id\": " + izdavackaKuca2.izdavackaKucaIDProperty().getValue() + "," +
                    "\"naziv_izdavacke_kuce\": \"" + izdavackaKuca2.nazivIzdavackeKuceProperty().getValue() + "\"," +
                    "\"grad\": {" +
                    "\"id_grada\": " + grad2.idGradaProperty().getValue() + "," +
                    "\"naziv_grada\": \"" + grad2.nazivGradaProperty().getValue() + "\"," +
                    "\"postanski_broj\": \"" + grad2.postanskiBrojProperty().getValue() + "\"," +
                    "\"drzava\": {" +
                    "\"id_drzave\": " + drzava2.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava2.nazivDrzaveProperty().getValue() + "\"" +
                    "}" +
                    "}" +
                    "}" +
                    "}";

            String bibliotekaJSON = "{" +
                    "\"id_biblioteke\": " + biblioteka.idBibliotekeProperty().getValue() + "," +
                    "\"naziv_biblioteke\": \"" + biblioteka.nazivBibliotekeProperty().getValue() + "\"," +
                    "\"adresa_biblioteke\": \"" + biblioteka.adresaBibliotekeProperty().getValue() + "\"," +
                    "\"grad\": {" +
                    "\"id_grada\": " + grad3.idGradaProperty().getValue() + "," +
                    "\"naziv_grada\": \"" + grad3.nazivGradaProperty().getValue() + "\"," +
                    "\"postanski_broj\": \"" + grad3.postanskiBrojProperty().getValue() + "\"," +
                    "\"drzava\": {" +
                    "\"id_drzave\": " + drzava3.idDrzaveProperty2().getValue() + "," +
                    "\"naziv_drzave\": \"" + drzava3.nazivDrzaveProperty().getValue() + "\"" +
                    "}" +
                    "}" +
                    "}";

            String jsonInputString = "{" +
                    "\"id_stavka_knjiga\": " + idStavkaKnjiga22 + "," +
                    "\"knjiga\": " + knjigaJSON + "," +
                    "\"biblioteka\": " + bibliotekaJSON +
                    "}";

            try(OutputStream os = conn.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadStavkaKnjiga();
                String text = formatter.format(now);
                textContent2.append(text).append(" Azurirana je Stavka Knjiga pod ID-jem: ").append(idStavkaKnjiga22).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Azurirana je Stavka Knjiga pod ID-jem: " + idStavkaKnjiga22 + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteAutor(int idAutora){
        try{
            URL url = new URL("http://localhost:8080/deleteAutor/" + idAutora);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadAutori();
                izborAutoraDelete.getItems().clear();
                for(Autor autor : autorLista){
                    izborAutoraDelete.getItems().add(String.format("ID Autora: %s Ime Autora: %s Prezime Autora: %s", autor.idAutoraProperty().get(), autor.imeAutoraProperty().get(), autor.prezimeAutoraProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisan je Autor pod ID-jem: ").append(idAutora).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisan je Autor pod ID-jem: " + idAutora + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteBiblioteka(int idBiblioteke){
        try{
            URL url = new URL("http://localhost:8080/deleteBiblioteka/" + idBiblioteke);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadBiblioteke();
                odabirBiblioteke.getItems().clear();
                odabirBiblioteke.setValue("--Izaberi biblioteku--");
                odabirBiblioteke.getItems().add("--Izaberi biblioteku--");
                for(Biblioteka biblioteka : bibliotekaLista){
                    odabirBiblioteke.getItems().add(String.format("ID Biblioteke: %s Naziv Biblioteke: %s", biblioteka.idBibliotekeProperty().get(), biblioteka.nazivBibliotekeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Biblioteka pod ID-jem: ").append(idBiblioteke).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Biblioteka pod ID-jem: " + idBiblioteke + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteDrzava(int idDrzave){
        try{
            URL url = new URL("http://localhost:8080/deleteDrzava/" + idDrzave);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadDrzave();
                izborDrzave.getItems().clear();
                izborDrzave.setValue("--Izaberi drzavu--");
                izborDrzave.getItems().add("--Izaberi drzavu--");
                for(Drzava drzava : drzavaLista){
                    izborDrzave.getItems().add(String.format("ID Drzave: %s Naziv Drzave: %s", drzava.idDrzaveProperty2().get(), drzava.nazivDrzaveProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Drzava pod ID-jem: ").append(idDrzave).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Drzava pod ID-jem: " + idDrzave + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteGrad(int idGrada){
        try{
            URL url = new URL("http://localhost:8080/deleteGrad/" + idGrada);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadGrad();
                izborGradova.getItems().clear();
                izborGradova.setValue("--Izaberi grad--");
                izborGradova.getItems().add("--Izaberi grad--");
                for(Grad grad : gradLista){
                    izborGradova.getItems().add(String.format("ID Grada: %s Naziv Grada: %s", grad.idGradaProperty().get(), grad.nazivGradaProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisan je Grad pod ID-jem: ").append(idGrada).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisan je Grad pod ID-jem: " + idGrada + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteIK(int idIK){
        try{
            URL url = new URL("http://localhost:8080/deleteIzdavackaKuca/" + idIK);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadIzdavackaKuca();
                izborIK2.getItems().clear();
                izborIK2.setValue("--Izaberi Izdavacku Kucu--");
                izborIK2.getItems().add("--Izaberi Izdavacku Kucu--");
                for(IzdavackaKuca izdavackaKuca : izdavackaKucaLista){
                    izborIK2.getItems().add(String.format("ID Izdavacke Kuce: %s Naziv Izdavacke Kuce: %s", izdavackaKuca.izdavackaKucaIDProperty().get(), izdavackaKuca.nazivIzdavackeKuceProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Izdavacka Kuca pod ID-jem: ").append(idIK).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Izdavacka Kuca pod ID-jem: " + idIK + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteKategorija(int idKategorije){
        try{
            URL url = new URL("http://localhost:8080/deleteKategorija/" + idKategorije);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKategorije();
                izborKategorije.setValue("--Izaberi kategoriju--");
                izborKategorije.getItems().add("--Izaberi kategoriju--");
                for(Kategorija kategorija : kategorijaLista){
                    izborKategorije.getItems().add(String.format("ID Kategorije: %s Naziv Kategorije: %s", kategorija.idKategorijeProperty().get(), kategorija.nazivKategorijeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Kategorija pod ID-jem: ").append(idKategorije).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Kategorija pod ID-jem: " + idKategorije + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteKnjiga(int idKnjige){
        try{
            URL url = new URL("http://localhost:8080/deleteKnjiga/" + idKnjige);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadKnjige();
                odabirKnjige.getItems().clear();
                odabirKnjige.setValue("--Izaberi knjigu--");
                odabirKnjige.getItems().add("--Izaberi knjigu--");
                for(Knjiga knjiga : knjigaLista){
                    odabirKnjige.getItems().add(String.format("ISBN Knjige: %s Naziv Knjige: %s", knjiga.isbnProperty().get(), knjiga.nazivKnjigeProperty().get()));
                }
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Knjiga pod ID-jem: ").append(idKnjige).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Knjiga pod ID-jem: " + idKnjige + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteStavkaKnjiga(int idSK){
        try{
            URL url = new URL("http://localhost:8080/deleteStavkaKnjige/" + idSK);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                loadStavkaKnjiga();
                String text = formatter.format(now);
                textContent2.append(text).append(" Obrisana je Stavka Knjiga pod ID-jem: ").append(idSK).append("\n");
                textContent.set(textContent2.toString());
                String argFile = text + " Obrisana je Stavka Knjiga pod ID-jem: " + idSK + "\n";
                writeToFile(argFile);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void loadAutori() {
        try {
            URL url = new URL("http://localhost:8080/allAutori");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");

            autorLista.clear();
            for (String item : items) {
                String[] fields = item.replace("{", "").replace("}", "").replace("\"", "").split(",");
                int idA  = Integer.parseInt(fields[0].split(":")[1]);
                String imeA = fields[1].split(":")[1];
                String prezimeA = fields[2].split(":")[1];
                int godineA = Integer.parseInt(fields[3].split(":")[1]);
                autorLista.add(new Autor(idA, imeA, prezimeA, godineA));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadBiblioteke(){
        try {
            URL url = new URL("http://localhost:8080/allBiblioteke");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");

            bibliotekaLista.clear();
            for (String item : items) {
                item = item.replace("{", "").replace("}", "").replace("\"", "");

                String[] parts = item.split("grad\\:");
                String osnovnaPolja = parts[0];
                String ugnjezdeniObj = parts[1];

                String[] osnovnaPolja2 = osnovnaPolja.split(",");
                int idB  = Integer.parseInt(osnovnaPolja2[0].split(":")[1]);
                String nazivB = osnovnaPolja2[1].split(":")[1];
                String adresaB = osnovnaPolja2[2].split(":")[1];

                ugnjezdeniObj = ugnjezdeniObj.replace("{", "").replace("}", "").replace("\"", "");
                String[] ugnjezdeniObj2 = ugnjezdeniObj.split(",");
                int idGrad = Integer.parseInt(ugnjezdeniObj2[0].split(":")[1]);

                bibliotekaLista.add(new Biblioteka(idB, nazivB, adresaB, idGrad));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadGrad(){
        try{
            URL url = new URL("http://localhost:8080/allGradovi");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");

            gradLista.clear();
            for(String item : items){
                item = item.replace("{", "").replace("}", "").replace("\"", "");

                String[] parts = item.split("drzava\\:");
                String osnovnaPolja = parts[0];
                String ugnjezdeniObj = parts[1];

                String[] osnovnaPolja2 = osnovnaPolja.split(",");
                int idGrada = Integer.parseInt(osnovnaPolja2[0].split(":")[1]);
                String nazivGrada = osnovnaPolja2[1].split(":")[1];
                String postanskiBroj = osnovnaPolja2[2].split(":")[1];

                if(ugnjezdeniObj != null && !ugnjezdeniObj.equals("null")){
                    ugnjezdeniObj = ugnjezdeniObj.replace("{", "").replace("}", "");
                    String[] ugnjezdenaPolja2 = ugnjezdeniObj.split(",");
                    String idDrzave = ugnjezdenaPolja2[0].split(":")[1];

                    gradLista.add(new Grad(idGrada, nazivGrada, postanskiBroj, idDrzave));
                } else {
                    gradLista.add(new Grad(idGrada, nazivGrada, postanskiBroj, "null"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadDrzave(){
        try{
            URL url = new URL("http://localhost:8080/allDrzave");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();

            while((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "").replace("\"", "");
            String[] items = json.split("\\},\\{");
            drzavaLista.clear();
            for(String item : items){
                String[] fields = item.replace("{", "").replace("}", "").replace("\"", "").split(",");
                int drzavaID = Integer.parseInt(fields[0].split(":")[1]);
                String nazivDrzave = fields[1].split(":")[1];
                drzavaLista.add(new Drzava(drzavaID, nazivDrzave));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadKategorije(){
        try {
            URL url = new URL("http://localhost:8080/allKategorije");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");
            kategorijaLista.clear();
            for(String item : items){
                String[] fields = item.replace("{", "").replace("}", "").replace("\"", "").split(",");

                int idKat = Integer.parseInt(fields[0].split(":")[1]);
                String nazivKat = fields[1].split(":")[1];
                kategorijaLista.add(new Kategorija(idKat, nazivKat));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadKnjige() {
        try {
            URL url = new URL("http://localhost:8080/allKnjige");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String json = content.toString().trim();
            System.out.println("Ovo je json: " + json);
            knjigaLista.clear();

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject knjiga = jsonArray.getJSONObject(i);

                int isbn = knjiga.getInt("isbn");
                String nazivKnjige = knjiga.getString("naziv_Knjige");
                int godinaIzdavanja = knjiga.getInt("godina_Izdavanja");

                JSONObject kategorijaObj = knjiga.getJSONObject("kategorija");

                int idKategorije = kategorijaObj.getInt("id_kategorije");

                JSONObject izdavackaKucaObj = knjiga.getJSONObject("izdavackaKuca");
                int izdavackaKucaID = izdavackaKucaObj.getInt("izdavacka_kuca_id");

                JSONArray autoriArray = knjiga.getJSONArray("autor");
                List<String> autoriList = new ArrayList<>();

                for (int j = 0; j < autoriArray.length(); j++) {
                    JSONObject autor = autoriArray.getJSONObject(j);
                    String ime = autor.getString("ime_autora");
                    String prezime = autor.getString("prezime_autora");
                    autoriList.add(ime + " " + prezime);
                }

                String autoriString = String.join(", ", autoriList);

                knjigaLista.add(new Knjiga(isbn, nazivKnjige, idKategorije, godinaIzdavanja, izdavackaKucaID, autoriString));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadIzdavackaKuca(){
        try{
            URL url = new URL("http://localhost:8080/allIzdavackeKuce");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String json = content.toString();
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");
            izdavackaKucaLista.clear();
            for(String item : items){
                item = item.replace("{", "").replace("}", "").replace("\"", "");

                String[] fields = item.split(",");

                int idIK = 0;
                String nazivIK = "null";
                String idGrada = "null";
                for(String field : fields){
                    String[] keyValue = field.split(":");
                    if (keyValue.length < 2) continue;

                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    switch (key){
                        case "izdavacka_kuca_id":
                            idIK = Integer.parseInt(value);
                            break;
                        case "naziv_izdavacke_kuce":
                            nazivIK = value;
                            break;
                        case "grad":
                            String[] gradParts = field.split(":");
                            if(gradParts.length >= 3){
                                idGrada = gradParts[2].trim();
                            } else {
                                idGrada = "null";
                            }
                            break;
                    }
                }
                izdavackaKucaLista.add(new IzdavackaKuca(idIK, nazivIK, idGrada));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadStavkaKnjiga(){
        try {
            URL url = new URL("http://localhost:8080/allStavkaKnjige");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            String json = content.toString();
            JSONArray jsonArray1 = new JSONArray(json);
            /*System.out.println("Ovo je json promenljiva: " + json);
            json = json.replace("[", "").replace("]", "");
            String[] items = json.split("\\},\\{");*/
            stavkaKnjigeLista.clear();
            int skID = 0;
            String isbnKnjige = "null";
            String idBiblioteke = "null";
            for (Object item : jsonArray1) {
                JSONObject noviItem = (JSONObject) item;
                /*item = item.replace("{", "").replace("}", "").replace("\"", "");
                String[] parts = item.split(",");*/
                skID = noviItem.getInt("id_stavka_knjiga");
                isbnKnjige = "" + noviItem.getJSONObject("knjiga").getInt("isbn");
                idBiblioteke = "" + noviItem.getJSONObject("biblioteka").getInt("id_biblioteke");
                stavkaKnjigeLista.add(new StavkaKnjige(skID, isbnKnjige, idBiblioteke));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void writeToFile(String singleLine){
        try{
            file = new BufferedWriter(new FileWriter("C:\\Users\\Vladan\\Desktop\\BibliotekaInterface\\BibliotekaInterfejs\\src\\main\\java\\com\\example\\bibliotekainterfejs\\fajl_za_textarea.txt", true));
            file.append(singleLine);
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        if(!hasRun){
            hasRun = true;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Vladan\\Desktop\\BibliotekaInterface\\BibliotekaInterfejs\\src\\main\\java\\com\\example\\bibliotekainterfejs\\fajl_za_textarea.txt"))){
                String line;
                while((line = bufferedReader.readLine()) != null){
                    textContent2.append(line).append("\n");
                    textContent.set(textContent2.toString());
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Izgled.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateInterfejs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRead(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ReadInterfejs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToUpdate(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("UpdateInterfejs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDelete(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteInterfejs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exitFromProgram() {
        zaIzlazak.setOnMouseClicked(event1 -> {
            System.exit(0);
        });
    }
}