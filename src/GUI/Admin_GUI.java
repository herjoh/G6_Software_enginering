package GUI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_GUI implements ActionListener {

    JFrame Admin_Frame=new JFrame();
    JButton CommitButton=new JButton("Commit Car Coice");

    Admin_GUI(){
        Prepare_GUI();
        Button_Properties();
    }

    private void Prepare_GUI(){
        Admin_Frame.setTitle("Admin Vindu");
        Admin_Frame.getContentPane().setLayout(null);
        Admin_Frame.setVisible(true);
        Admin_Frame.setBounds(400,100,600,700);
        Admin_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void Button_Properties(){
        CommitButton.setBounds(150,200,150,80);
        Admin_Frame.add(CommitButton);
        CommitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Changing Background Color
        Admin_Frame.dispose();
        new Gui();

    }
}



