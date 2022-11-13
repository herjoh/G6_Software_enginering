package OnliceExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Timeliste extends JFrame implements ActionListener {
    JButton leggtil, slett, endre;
    JTextField time;
    JTextArea Oversikt;
    JLabel avtaler;
    static JTable data;
    private Statement stmt;
    private ResultSet rs;

    public static void main(String[] args) throws Exception {
        Timeliste vindu = new Timeliste();
        vindu.setTitle("Time registrering");
        vindu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vindu.setSize(260, 170);
        vindu.setResizable(false);
        vindu.setLocationRelativeTo(null);
        vindu.opprettGUI();
        vindu.pack();
        vindu.setVisible(true);
        getConnection();

    }

    public static void getConnection() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:avtaler.db");

        System.out.println("Vellykket oppkobling til databasen!");

        conn.close();


    }

    public void opprettGUI() {
        setLayout(new FlowLayout());
        add(new JLabel("Registrer timer her!"));
        leggtil = new JButton("Legg til");
        add(leggtil);
        slett = new JButton("Slett");
        add(slett);
        endre = new JButton("Endre");
        add(endre);
        time = new JTextField(8);
        add(time);
        setTitle("Avtale registrering");
        setMinimumSize(new Dimension(200, 300));
        add(new JTable(10, 5));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}