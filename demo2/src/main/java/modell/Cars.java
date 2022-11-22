//package ;

import javafx.beans.property.*;

public class Cars {

    private StringProperty merke;
    private StringProperty modell;
    private StringProperty eier;
    private IntegerProperty årsmodell;
    private StringProperty farge;
    private StringProperty område;
    private BooleanProperty tilgjenglig;
    private StringProperty ledigdato;
    private StringProperty regnr;


    public Cars(StringProperty merke, StringProperty modell, StringProperty eier, IntegerProperty årsmodell, StringProperty farge, StringProperty område, BooleanProperty tilgjenglig, StringProperty ledigdato, StringProperty regnr) {
        this.merke = merke;
        this.modell = modell;
        this.eier = eier;
        this.årsmodell = årsmodell;
        this.farge = farge;
        this.område = område;
        this.tilgjenglig = tilgjenglig;
        this.ledigdato = ledigdato;
        this.regnr = regnr;
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


    //Modell
    public String getModell() {
        return modell.get();
    }
    public StringProperty modellProperty() {
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


    //Årsmodell
    public int getÅrsmodell() {
        return årsmodell.get();
    }
    public IntegerProperty årsmodellProperty() {
        return årsmodell;
    }
    public void setÅrsmodell(int årsmodell) {
        this.årsmodell.set(årsmodell);
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


    //Tilgjenglig
    public boolean isTilgjenglig() {
        return tilgjenglig.get();
    }
    public BooleanProperty tilgjengligProperty() {
        return tilgjenglig;
    }
    public void setTilgjenglig(boolean tilgjenglig) {
        this.tilgjenglig.set(tilgjenglig);
    }


    //Ledigdato
    public String getLedigdato() {
        return ledigdato.get();
    }
    public StringProperty ledigdatoProperty() {
        return ledigdato;
    }
    public void setLedigdato(String ledigdato) {
        this.ledigdato.set(ledigdato);
    }


    //Regnr
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







