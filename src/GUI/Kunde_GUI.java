package GUI;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kunde_GUI implements ActionListener {
    private JFrame Kunde_Frame = new JFrame();
    private JButton Log_out = new JButton("Log Out");
    private JButton Order = new JButton("Order Car");
    private JButton ShoppingChart = new JButton("Check your shopping chart");

    Kunde_GUI() {
        Kunde_GUI();
        Button_Mangament();
        ButtonActivetes();
        Read_sql();
    }

    private void Kunde_GUI() {
        Kunde_Frame.setTitle("Kunde Side");
        //Kunde_Frame.setSize(800,800);
        Kunde_Frame.getContentPane().setLayout(null);
        Kunde_Frame.setVisible(true);
        Kunde_Frame.setBounds(400, 100, 800, 800);
        Kunde_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Button_Mangament() {
        Log_out.setBounds(150, 200, 150, 80);
        Order.setBounds(150, 300, 150, 80);
        ShoppingChart.setBounds(400, 200, 150, 80);
        Kunde_Frame.add(Log_out);
        Kunde_Frame.add(Order);
        Kunde_Frame.add(ShoppingChart);
        Log_out.addActionListener(this);
        Order.addActionListener(this);
        ShoppingChart.addActionListener(this);
    }

    private void Read_sql(){

    }

    private void ButtonActivetes() {
        Log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kunde_Frame.dispose();
                new Gui();
            }
        });
        Order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kunde_Frame.getContentPane().setBackground(Color.red);
            }
        });
        ShoppingChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kunde_Frame.getContentPane().setBackground(Color.BLUE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}





