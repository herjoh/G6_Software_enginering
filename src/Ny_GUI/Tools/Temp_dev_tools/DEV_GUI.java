package Ny_GUI.Tools.Temp_dev_tools;

import Ny_GUI.Ny_Crud;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DEV_GUI {
    private JTextField textField1;
    private JButton runButton;
    private JPanel QueryPanel;

    private String query = "";
    private Connection con = new Ny_Crud().sendConnection();
    private String[] newData;

    public DEV_GUI() throws SQLException {


        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                query = textField1.getText();

                try {
                    newData = new Direct_queries().viewTable(query,con);
                    new Ny_Crud().getNewTableData(newData);

                    new Ny_Crud().
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public JFrame New_DEV_GUI() throws SQLException {
        JFrame devFrame = new JFrame("Dev_Tools");
        devFrame.setContentPane(new DEV_GUI().QueryPanel);
        devFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        devFrame.pack();
        return devFrame;
    }
}
