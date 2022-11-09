package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utleier_GUI  implements ActionListener {
    private JFrame Utleier_frame = new JFrame();
    private JButton Log_out = new JButton("Log Out");

    Utleier_GUI() {
        Prep_Utleier_GUI();
        Button_Properties();
        Read_Sql();
    }

    private void Prep_Utleier_GUI() {
        Utleier_frame.setTitle("Utleier Vindu");
        Utleier_frame.getContentPane().setLayout(null);
        Utleier_frame.setVisible(true);
        Utleier_frame.setBounds(400, 100, 600, 700);
        Utleier_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Button_Properties() {
        Log_out.setBounds(150, 200, 150, 80);
        Utleier_frame.add(Log_out);
        Log_out.addActionListener(this);
    }

    private void Read_Sql(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Changing Background Color
        Utleier_frame.dispose();
        new Gui();

    }
}


