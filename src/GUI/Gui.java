package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    // Hoved fgrame and panel + Buttons for å åpne loggin.
    private JFrame main_loggin_frame = new JFrame("Main og Login");
    private JButton kunde_1 = new JButton("Kunde login");
    private JButton admin_1 = new JButton("Admin login");
    private JButton utleier_1 = new JButton("Utleier login");
    private JPanel panel_1 = new JPanel();

    //MAin GUI class
    public Gui(){
        //Setter Layout, samt størelse på hoved
        main_loggin_frame.setSize(800,800);
        main_loggin_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        main_loggin_frame.setVisible(true);
        main_loggin_frame.getContentPane().add(kunde_1);
        main_loggin_frame.getContentPane().add(admin_1);
        main_loggin_frame.getContentPane().add(utleier_1);

        main_loggin_frame.add(panel_1);
        panel_1.setLayout(null);

        //Ad and place Logging namres & Buttons
        JLabel label_Kunde = new JLabel("User");
        JLabel label_Admin = new JLabel("Admin");
        JLabel label_Ut = new JLabel("Utleier");

        //Location of Label & Buttons
        label_Kunde.setBounds(10,20,80,25);
        kunde_1.setBounds(150,20,180,25);
        label_Admin.setBounds(10,100,80,25);
        admin_1.setBounds(150,100,180,25);
        label_Ut.setBounds(10,200,80,25);
        utleier_1.setBounds(150,200,180,25);

        //Add to panel
        panel_1.add(label_Kunde);
        panel_1.add(label_Admin);
        panel_1.add(label_Ut);

        kunde_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main_loggin_frame.dispose();
                new Kunde_GUI();
            }
        });


        admin_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_loggin_frame.dispose();
                new Admin_GUI();
            }
        });


        utleier_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_loggin_frame.dispose();
                new Utleier_GUI();
            }
        });
    }

    //Main call func
    public static void main(String[] args) {
        new Gui();

    }



}