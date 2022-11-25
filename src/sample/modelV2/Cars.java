package sample.modelV2;

import javafx.beans.property.*;

import java.sql.Date;

public class Cars {
    //Declare Employees Table Columns
    private StringProperty merke;
    private StringProperty modell;
    private StringProperty eier;
    private IntegerProperty årsmodel;
    private StringProperty farge;
    private StringProperty område;
    private BooleanProperty tilgjenglig;
    private StringProperty ledigdato;
    private StringProperty regnr;

    //For inserting search & Update queries
    private StringProperty insert;

    //Constructor
    public Cars() {
        this.merke = new SimpleStringProperty();
        this.modell = new SimpleStringProperty();
        this.eier = new SimpleStringProperty();
        this.årsmodel = new SimpleIntegerProperty();
        this.farge = new SimpleStringProperty();
        this.område = new SimpleStringProperty();
        this.tilgjenglig = new SimpleBooleanProperty();
        this.ledigdato = new SimpleStringProperty();
        this.regnr = new SimpleStringProperty();

        this.insert = new SimpleStringProperty();
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
    public String getModell() {
        return modell.get();
    }

    public StringProperty modellProperty() {
        return modell;
    }

    public void setModell(String model) {
        this.modell.set(model);
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

    public IntegerProperty årsmodellProperty() {
        return årsmodel;
    }

    public void setÅrsmodell(int årsmodel) {
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
        return tilgjenglig.get();
    }

    public BooleanProperty tilgjengligProperty() {
        return tilgjenglig;
    }

    public void setTilgjenglig(boolean ledighet) {
        this.tilgjenglig.set(ledighet);
    }

    //dato
    public String getDato() {
        return ledigdato.get();
    }

    public StringProperty ledigdatoProperty() {
        return ledigdato;
    }

    public void setledigdato(String dato) {
        this.ledigdato.set(dato);
    }

    //registreringsnummer
    public String getRegestreringsNummer() {
        return regnr.get();
    }

    public StringProperty regestreringsNummerProperty() {
        return regnr;
    }

    public void setRegestreringsNummer(String regestreringsNummer) {
        this.regnr.set(regestreringsNummer);
    }

    public String getInsert() {
        return insert.get();
    }

    public StringProperty insertProperty() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert.set(insert);
    }
}

