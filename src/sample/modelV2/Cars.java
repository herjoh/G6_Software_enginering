package sample.modelV2;

import javafx.beans.property.*;

import java.sql.Date;

public class Cars {
    //Declare Employees Table Columns
    private StringProperty merke;
    private StringProperty model;
    private StringProperty eier;
    private IntegerProperty årsmodel;
    private StringProperty farge;
    private StringProperty område;
    private BooleanProperty ledighet;
    private StringProperty dato;
    private StringProperty regestreringsNummer;

    //Constructor
    public Cars() {
        this.merke = new SimpleStringProperty();
        this.model = new SimpleStringProperty();
        this.eier = new SimpleStringProperty();
        this.årsmodel = new SimpleIntegerProperty();
        this.farge = new SimpleStringProperty();
        this.område = new SimpleStringProperty();
        this.ledighet = new SimpleBooleanProperty();
        this.dato = new SimpleStringProperty();
        this.regestreringsNummer = new SimpleStringProperty();
    }

    //Merke
    public String getMerke() {
        return merke.get();
    }

    public StringProperty merkeProperty() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke.set(merke);
    }

    //Model
    public String getModel() {
        return model.get();
    }

    public StringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    //Eier
    public String getEier() {
        return eier.get();
    }

    public StringProperty eierProperty() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier.set(eier);
    }

    //Årsmodel
    public int getÅrsmodel() {
        return årsmodel.get();
    }

    public IntegerProperty årsmodelProperty() {
        return årsmodel;
    }

    public void setÅrsmodel(int årsmodel) {
        this.årsmodel.set(årsmodel);
    }

    //Farge
    public String getFarge() {
        return farge.get();
    }

    public StringProperty fargeProperty() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge.set(farge);
    }

    //Område
    public String getOmråde() {
        return område.get();
    }

    public StringProperty områdeProperty() {
        return område;
    }

    public void setOmråde(String område) {
        this.område.set(område);
    }

    //Ledighet
    public boolean isLedighet() {
        return ledighet.get();
    }

    public BooleanProperty ledighetProperty() {
        return ledighet;
    }

    public void setLedighet(boolean ledighet) {
        this.ledighet.set(ledighet);
    }

    //dato
    public String getDato() {
        return dato.get();
    }

    public StringProperty datoProperty() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato.set(dato);
    }

    //registreringsnummer
    public String getRegestreringsNummer() {
        return regestreringsNummer.get();
    }

    public StringProperty regestreringsNummerProperty() {
        return regestreringsNummer;
    }

    public void setRegestreringsNummer(String regestreringsNummer) {
        this.regestreringsNummer.set(regestreringsNummer);
    }
}

