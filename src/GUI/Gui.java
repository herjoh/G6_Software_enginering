package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gui implements ActionListener {

    // Hoved fgrame and panel + Buttons for å åpne loggin.
    private JFrame main_loggin_frame = new JFrame("Main og Login");
    private JButton kunde_1 = new JButton("Kunde login");
    private JButton admin_1 = new JButton("Admin login");
    private JButton utleier_1 = new JButton("Utleier login");
    private JPanel panel_1 = new JPanel();

    Gui() {
        Build_Gui();
        Main_Button_managment();
        Main_Button_Action();

    }

    //MAin GUI class
    private void Build_Gui(){

        main_loggin_frame.setTitle("Main Side");
        //Kunde_Frame.setSize(800,800);
        main_loggin_frame.getContentPane().setLayout(null);
        main_loggin_frame.setVisible(true);
        main_loggin_frame.setBounds(400, 100, 1000, 1000);
        main_loggin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private void Main_Button_managment(){
        kunde_1.setBounds(100, 100, 100, 80);
        admin_1.setBounds(100, 200, 100, 80);
        utleier_1.setBounds(100, 300, 100, 80);
        main_loggin_frame.add(kunde_1);
        main_loggin_frame.add(admin_1);
        main_loggin_frame.add(utleier_1);
        kunde_1.addActionListener(this);
        admin_1.addActionListener(this);
        utleier_1.addActionListener(this);
    }

    private void Main_Button_Action(){
        kunde_1.addActionListener(new ActionListener() {
            @Override
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //Main call func
    public static void main(String[] args) throws IOException {
        new Gui();

    }

}