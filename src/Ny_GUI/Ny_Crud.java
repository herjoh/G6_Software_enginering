package Ny_GUI;

import Ny_GUI.Tools.Temp_dev_tools.DEV_GUI;
import Ny_GUI.Tools.getConnection;
import Ny_GUI.Tools.readData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


public class Ny_Crud extends javax.swing.JFrame {
    //start deklarering av swing elementer.
    private JButton lagreButton;
    private JButton slettButton;
    private JButton oppdaterButton1;
    private JTextField TekstMerke;
    private JTextField TekstModell;
    private JTextField TekstEier;
    private JTextField TekstÅrsmodell;
    private JTextField TekstFarge;
    private JTextField TekstOmråde;
    private JTextField TekstTilgjengelig;
    private JTextField TekstLedig_dato;
    private JTextField TekstRegistreringsnummer;
    private JTable table1;
    private JPanel Database;
    //slutt deklarering av swing elementer.

    private final String[] collumnNames = {"type","name","tbl_name","rootpage","sql"};
    private final Object[][] data=new Object[5][5];
    private final String url = "jdbc:sqlite:src/Ny_GUI/DB/uno.db";
    public Connection con = getConnection.connect(url);

    public Connection sendConnection() {
        return con;
    }
    public Ny_Crud() throws SQLException {
        data = getNewTableData(readData.viewTable());
        updateTable();

        oppdaterButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        slettButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        lagreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public String[][] getNewTableData(String[] dataToWrite) throws SQLException {

        //readData.viewtable() funksjonen outputter et array med alle elementene i databasen.
        String[] newData = dataToWrite;
        String[][] output = new String[5][5];

        //Veldig tungvint løsning, men den er bare midlertidig og viktigst av alt den fungerer :).
        //x går gjennom indexen i første element av 2D arrayet data, dette kan sees på som radene i en tabell.
        //y går gjennom indexen i andre element av 2D arrayet data, dette kan sees på som kolonnene i en tabell.
        //z går gjennom indexen i newData og legger til dataen fra tabellen i riktig data[x][y] index.
        int x=0;
        int y=0;
        int z=0;
        while (x<5) {
            output[x][y] = newData[z];
            z++;
            y++;
            output[x][y] = newData[z];
            z++;
            y++;
            output[x][y] = newData[z];
            z++;
            y++;
            output[x][y] = newData[z];
            z++;
            y++;
            output[x][y] = newData[z];
            y=0;
            z++;
            x++;
        }

        return output;

    }

    public void updateTable(String[][] inputData) throws SQLException {
        table1.setModel(new DefaultTableModel(inputData,collumnNames));
    }



    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Ny_Crud");
        frame.setContentPane(new Ny_Crud().Database);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //temp
        JFrame devFrame = new DEV_GUI().New_DEV_GUI();
        devFrame.setVisible(true);
        //temp
    }



}
