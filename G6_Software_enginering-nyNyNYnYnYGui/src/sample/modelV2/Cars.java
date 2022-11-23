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

    public StringProperty modelProperty() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell.set(modell);
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
    public boolean isTilgjengelig() {
        return tilgjenglig.get();
    }

    public BooleanProperty tilgjengeligProperty() {
        return tilgjenglig;
    }

    public void setTilgjenglig(boolean tilgjenglig) {
        this.tilgjenglig.set(tilgjenglig);
    }

    //dato
    public String getLedigDato() {
        return ledigdato.get();
    }

    public StringProperty ledigDatoProperty() {
        return ledigdato;
    }

    public void setLedigdatoDato(String ledigDato) {
        this.ledigdato.set(ledigDato);
    }

    //registreringsnummer
    public String getRegnr() {
        return regnr.get();
    }

    public StringProperty regnrProperty() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr.set(regnr);
    }
}

