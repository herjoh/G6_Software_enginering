package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_GUI  {

    public Admin_GUI(){
        JFrame Admin_frame = new JFrame("Admin");
        JPanel Admin_GUI_panel = new JPanel();
        Admin_frame.setSize(800,800);
        Admin_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Admin_frame.setVisible(true);
        Admin_frame.getContentPane().add(Admin_GUI_panel);


        JLabel labal_1 = new JLabel("This is Admin GUI");
        labal_1.setBounds(10,20,80,25);
        Admin_frame.invalidate();

        JButton LoggOut = new JButton("Log Out");
        JLabel Log_Out_lable = new JLabel("Admin Logout");

        Log_Out_lable.setBounds(10,20,80,25);
        LoggOut.setBounds(150,20,180,25);

        Admin_GUI_panel.add(LoggOut);
        Admin_GUI_panel.add(Log_Out_lable);

        LoggOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin_frame.dispose();
                new Gui();
            }
        });

    }
}

