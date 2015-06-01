package com.bulbairways.gui;

import com.bulbairways.Model;
import com.bulbairways.file.AirportFileManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Etienne on 2015-05-25.
 */
public class LoginFrame extends JFrame {

    protected Model model;

    public LoginFrame(Model model) {
        initUI();
        this.model = model;
    }

    public void initUI() {

        buildLayout();

        setTitle("Client Login or Register");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void buildLayout() {

        System.out.println(System.getProperty("user.dir/src"));

        AirportFileManager handler = new AirportFileManager();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 50, 10, 10));
        panel.setBorder(new EmptyBorder(new Insets(120, 200, 120, 200)));

        JTextField name = new JTextField("Enter Name");
        JTextField id = new JTextField("Enter ID");
        JButton btnReg = new JButton("Register Client");
        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(handler.fileExist(id.getText())) {
                    System.out.println("Account already exists, try loging in.");
                } else {
                    handler.registerUser(id.getText(), name.getText());
                    new MainFrame(model).setVisible(true);
                    setVisible(false);
                }
            }
        });
        JButton btnLogin = new JButton("Login Client");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (handler.fileExist(id.getText())) {
                    model.setId(id.getText());
                    new MainFrame(model).setVisible(true);
                    setVisible(false);
                } else {
                    System.out.println("Client account does not exist, please reister the account.");
                };

            }
        });

        panel.add(name);
        panel.add(id);
        panel.add(btnLogin);
        panel.add(btnReg);


        add(panel);
    }
}
