package Sample.modelV2;

import javafx.beans.property.*;

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
    public String getModel() {
        return modell.get();
    }

    public StringProperty modelProperty() {
        return modell;
    }

    public void setModel(String model) {
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
        return tilgjenglig.get();
    }

    public BooleanProperty ledighetProperty() {
        return tilgjenglig;
    }

    public void setLedighet(boolean ledighet) {
        this.tilgjenglig.set(ledighet);
    }

    //dato
    public String getDato() {
        return ledigdato.get();
    }

    public StringProperty datoProperty() {
        return ledigdato;
    }

    public void setDato(String dato) {
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

