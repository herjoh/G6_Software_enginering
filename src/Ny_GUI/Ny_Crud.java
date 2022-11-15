package Ny_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ny_Crud");
        frame.setContentPane(new Ny_Crud().Database);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
