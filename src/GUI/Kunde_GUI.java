package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kunde_GUI{

  public Kunde_GUI(){

      JFrame kunde_frame = new JFrame("Kunde");
      JPanel kunde_GUI_panel = new JPanel();
      kunde_frame.setSize(800,800);
      kunde_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      kunde_frame.setVisible(true);
      kunde_frame.getContentPane().add(kunde_GUI_panel);


      JLabel labal_1 = new JLabel("This is Kunde GUI");
      labal_1.setBounds(10,20,80,25);
      kunde_frame.invalidate();

      JButton LoggOut = new JButton("Log Out");
      JLabel Log_Out_lable = new JLabel("Kunde Logout");

      Log_Out_lable.setBounds(10,20,80,25);
      LoggOut.setBounds(150,20,180,25);

      kunde_GUI_panel.add(LoggOut);
      kunde_GUI_panel.add(Log_Out_lable);

      LoggOut.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              kunde_frame.dispose();
              new Gui();
          }
      });


  }
  private void Kunde_Interactin(){

  }

}
