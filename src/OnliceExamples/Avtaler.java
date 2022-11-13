package OnliceExamples;

import static javax.swing.JOptionPane.*;
import java.sql.*;

public class Avtaler {

    private static String url = "jdbc:sqlite:avtaler.db";
    private static Connection conn = null;

    public static void main(String[] args) {
        String utTxt = "";
        kobleOpp();  // Kontakter databasen

        try {
            Statement stmt = conn.createStatement();
            // Opprette databasen gjøres først!
            String sql = sqlNyDB(); // Spørring def i hjelpemetode
            stmt.executeUpdate(sql);
            utTxt = "Databasen er opprettet - ok!" + "\n";


            // Lister ut alle personer i databasen
            // String sql = "select * from Person;";
            sql = "select * from Avtale order by Dato;";
            ResultSet rs   = stmt.executeQuery(sql);

            while (rs.next()) {
                int nr           = rs.getInt("Nr");
                String dato   = rs.getString("Dato");
                String sted = rs.getString("Sted");
                String beskrivelse = rs.getString("Beskrivelse");
                utTxt += nr + ", " + dato+ " (" + sted + ") - " + beskrivelse + "\n";
            }

        }
        catch (Exception e) {
            utTxt = "Databasespørring feilet!";
        }

        showMessageDialog(null, utTxt);
        kobleNed();
    }


    // Kobler opp til databasen.
    private static void kobleOpp() {
        try {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.out.println( "Oppkobling til databasen " + url + " feilet." + "\n" + e.toString() );
        }
    }

    // Lukker forbindelsen til databasen.
    private static void kobleNed() {
        try {
            conn.close();
        }
        catch (SQLException e) { }
    }

    private static String sqlNyDB() {
        return       "drop table if exists Avtale; create table Avtale(Nr integer primary key, Dato varchar(50), Sted varchar(50), Beskrivelse varchar(50) );"
                + "insert into Avtale values ( 1, '2019-09-09 09:00:00', 'Oslo', 'Gruppearbeid');"
                + "insert into Avtale values ( 2, '2019-07-07 07:00:00', 'Fredrikstad', 'Signere kontrakt');"
                + "insert into Avtale values ( 3, '2019-12-05 11:30:00', 'Bø', 'Pub med gutta');"
                + "insert into Avtale values ( 4, '2019-06-09 07:45:00', 'Oslo', 'Gruppearbeid');"
                + "insert into Avtale values ( 5, '2019-08-11 12:00:00', 'Bergen', 'Basketball trening');";

    }

}