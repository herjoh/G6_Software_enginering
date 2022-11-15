package Ny_GUI;

import javax.swing.*;

public class Ny_Crud extends javax.swing.JFrame {
    private JButton lagreButton;
    private JButton slettButton;
    private JButton oppdaterButton1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTable table1;
    private JPanel Database;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ny_Crud");
        frame.setContentPane(new Ny_Crud().Database);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
