package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Utleier_GUI  implements ActionListener {
    private JFrame Utleier_frame = new JFrame();
    private JButton Log_out = new JButton("Log Out");
    private JButton Edit = new JButton("Edit");
    private JButton Commit = new JButton("Commit");
    private JButton Clear = new JButton("Clear");
    //Merke
    private JTextField merke = new JTextField();
    //Model
    private JTextField Model = new JTextField();
    //Eier
    private JTextField Eier = new JTextField();
    //Årsmodel
    private JTextField AArsmodel = new JTextField();
    //Farge
    private JTextField Farge = new JTextField();
    //Område
    private JTextField Område = new JTextField();
    //Tilgjenlig
    private JTextField Tilgjenlig = new JTextField();
    //Ledig dato
    private JTextField Date = new JTextField();
    // Resistreringsnummer
    private JTextField Resistreringsnummer = new JTextField();

    Utleier_GUI() {
        Prep_Utleier_GUI();
        Insert_Moetode();
        Button_Properties();
        ButtonActivetes();
        Insert_Moetode();
        Read_Sql();
    }

    private void Prep_Utleier_GUI() {
        Utleier_frame.setTitle("Utleier Vindu");
        Utleier_frame.getContentPane().setLayout(null);
        Utleier_frame.setVisible(true);
        Utleier_frame.setBounds(400, 100, 1400, 1000);
        Utleier_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Button_Properties() {
        //Log out button
        Log_out.setBounds(25, 950, 100, 50);
        Utleier_frame.add(Log_out);
        Log_out.addActionListener(this);

        //Edit Button
        Edit.setBounds(125, 950, 100, 50);
        Utleier_frame.add(Edit);
        Edit.addActionListener(this);
        //Comit
        Commit.setBounds(225, 950, 100, 50);
        Utleier_frame.add(Commit);
        Commit.addActionListener(this);

        //Clear Textfields
        Clear.setBounds(325, 950, 100, 50);
        Utleier_frame.add(Clear);
        Clear.addActionListener(this);
    }

    private void Insert_Moetode(){
        JLabel name = new JLabel("Merke type: ");
        name.setBounds(25, 25, 100, 50);
        Utleier_frame.getContentPane().add(name);
        merke.setBounds(125, 25, 100, 50);
        Utleier_frame.add(merke);
        merke.addActionListener(this);
        //Model

        JLabel model_type = new JLabel("Model type: ");
        model_type.setBounds(25, 125, 100, 50);
        Utleier_frame.getContentPane().add(model_type);
        Model.setBounds(125, 125, 100, 50);
        Utleier_frame.add(Model);
        Model.addActionListener(this);
        //Eier

        JLabel Onwer_NAme = new JLabel("Eier Navn: ");
        Onwer_NAme.setBounds(25, 225, 100, 50);
        Utleier_frame.getContentPane().add(Onwer_NAme);
        Eier.setBounds(125, 225, 100, 50);
        Utleier_frame.add(Eier);
        Eier.addActionListener(this);
        //Årsmodel

        JLabel Armodel = new JLabel("Årsmodel: ");
        Armodel.setBounds(25, 325, 100, 50);
        Utleier_frame.getContentPane().add(Armodel);
        AArsmodel.setBounds(125, 325, 100, 50);
        Utleier_frame.add(AArsmodel);
        AArsmodel.addActionListener(this);
        //Farge

        JLabel Colour = new JLabel("Car Colour: ");
        Colour.setBounds(25, 425, 100, 50);
        Utleier_frame.getContentPane().add(Colour);
        Farge.setBounds(125, 425, 100, 50);
        Utleier_frame.add(Farge);
        Farge.addActionListener(this);
        //Område

        JLabel Sted = new JLabel("Område: ");
        Sted.setBounds(25, 525, 100, 50);
        Utleier_frame.getContentPane().add(Sted);
        Område.setBounds(125, 525, 100, 50);
        Utleier_frame.add(Område);
        Område.addActionListener(this);
        //Tilgjenglighter

        JLabel Leasable = new JLabel("Tilgjenglig: ");
        Leasable.setBounds(25, 625, 100, 50);
        Utleier_frame.getContentPane().add(Leasable);
        Tilgjenlig.setBounds(125, 625, 100, 50);
        Utleier_frame.add(Tilgjenlig);
        Tilgjenlig.addActionListener(this);
        //Date

        JLabel Dato = new JLabel("Date: ");
        Dato.setBounds(25, 725, 100, 50);
        Utleier_frame.getContentPane().add(Dato);
        Date.setBounds(125, 725, 100, 50);
        Utleier_frame.add(Date);
        Date.addActionListener(this);
        //Resistreringsnummer

        JLabel Reg_NR = new JLabel("Reg NR: ");
        Reg_NR.setBounds(25, 825, 100, 50);
        Utleier_frame.getContentPane().add(Reg_NR);
        Resistreringsnummer.setBounds(125, 825, 100, 50);
        Utleier_frame.add(Resistreringsnummer);
        Resistreringsnummer.addActionListener(this);
    }

    private void Read_Sql() {

    }

    private void ButtonActivetes() {
        Log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utleier_frame.dispose();
                new Gui();
            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             merke.setText(null);
             Model.setText(null);
             Eier.setText(null);
             AArsmodel.setText(null);
             Farge.setText(null);
             Område.setText(null);
             Tilgjenlig.setText(null);
             Date.setText(null);
             Resistreringsnummer.setText(null);
            }
        });
        Commit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (merke.getText().isEmpty() || Model.getText().isEmpty() || Eier.getText().isEmpty() || AArsmodel.getText().isEmpty() || Farge.getText().isEmpty() || Område.getText().isEmpty() || Tilgjenlig.getText().isEmpty() || Date.getText().isEmpty() || Resistreringsnummer.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"Data Missing");
                else
                    JOptionPane.showMessageDialog(null,"Data Submitted");



            }
        });

    }
    @Override
    public void actionPerformed (ActionEvent e){

    }
}

class Click_BTN{
    public static void main(String[] args)  {
        new Utleier_GUI();

    }
}

