package Ny_GUI;

import swingcrud.Crud;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ny_Crud extends javax.swing.JFrame {
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
    private String url = "jdbc:sqlite:uno.db";
    Connection con = getConnection.connect(url);
    Statement st;

    public Ny_Crud() {
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

    //skal settes inn i ny klasse
    public void delete(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "DELETE FROM `uno` WHERE id_number='" + id + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ny_Crud");
        frame.setContentPane(new Ny_Crud().Database);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
