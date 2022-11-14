package swingcrud;

/**
 *
 * @author JAMES
 */
public class User {
    String fname, lname, Cmodel, merke, aarsmodel, farge, date, tilgjenlighet, omrode, Reg_id;

    public User(String fname, String lname, String Cmodel, String merke, String aarsmodel, String farge, String date, String tilgjenglighet, String omroode, String Reg_ID) {
        this.fname = fname;
        this.lname = lname;
        this.Cmodel = Cmodel;
        this.merke = merke;
        this.farge = farge;
        this.aarsmodel = aarsmodel;
        this.date = date;
        this.tilgjenlighet = tilgjenglighet;
        this.omrode = omroode;
        this.Reg_id = Reg_ID;
    }

    //getters
    public String getLname() {
        return this.lname;
    }

    public String getFname() {
        return this.fname;
    }

    public String getCmodel() {
        return this.Cmodel;
    }

    public String getMerke() {
        return this.merke;
    }

    public String getAarsmodel() {
        return this.aarsmodel;
    }

    public String getFarge() {
        return this.farge;
    }

    public String getDate() {
        return this.date;
    }

    public String getTilgjenlighet() {
        return this.tilgjenlighet;
    }

    public String getReg_id() {
        return this.Reg_id;
    }

    public String getOmrode() {
        return this.omrode;
    }
}




