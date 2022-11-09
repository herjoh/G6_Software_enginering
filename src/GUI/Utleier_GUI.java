package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utleier_GUI {

    public Utleier_GUI() {
        JFrame Utleier_frame = new JFrame("Utleier");
        JPanel Utleier_GUI_panel = new JPanel();
        Utleier_frame.setSize(800, 800);
        Utleier_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Utleier_frame.setVisible(true);
        Utleier_frame.getContentPane().add(Utleier_GUI_panel);


        JLabel labal_1 = new JLabel("This is Utleier GUI");
        labal_1.setBounds(10, 20, 80, 25);
        Utleier_frame.invalidate();

        JButton LoggOut = new JButton("Log Out");
        JLabel Log_Out_lable = new JLabel("Utleier Logout");

        Log_Out_lable.setBounds(10, 20, 80, 25);
        LoggOut.setBounds(150, 20, 180, 25);

        Utleier_GUI_panel.add(LoggOut);
        Utleier_GUI_panel.add(Log_Out_lable);

        LoggOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utleier_frame.dispose();
                new Gui();
            }
        });

    }
}
