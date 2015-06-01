package com.bulbairways.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bulbairways.Model;
import com.bulbairways.gui.PassengerFlight.PassengerFlightChooseAirport;

/**
 * Created by Etienne on 2015-05-16.
 */
public class MainFrame extends JFrame{

    protected Model model;

    public MainFrame(Model model) {
        this.model = model;
        initUI();
    }

    public void initUI() {

        createMenuBar();
        createStartPanel();

        setTitle("Bulb Airways");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void createMenuBar() {

        JMenuBar menubar = new JMenuBar();

//        Menu Objects
        JMenu fileMi = new JMenu("File");

        menubar.add(fileMi);

//        Menu items
        JMenuItem saveMi = new JMenuItem("Save");

        fileMi.add(saveMi);

//        Set JMenubar to JFrame
        setJMenuBar(menubar);

    }

    public void createStartPanel() {

        JPanel system_start_panel = new JPanel();
        system_start_panel.setLayout(new GridLayout(3, 50, 10, 10));
        system_start_panel.setBorder(new EmptyBorder(new Insets(90, 200, 90, 200)));

        JButton checkBtn = new JButton("Checkin Luggage");
        checkBtn.setPreferredSize(new Dimension(200, 50));
        JButton bookpBtn = new JButton("Book Passenger Flight");
        bookpBtn.setPreferredSize(new Dimension(200, 50));
        bookpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setFlightType("Passenger Flight");
                new PassengerFlightChooseAirport(model).setVisible(true);
                setVisible(false);
            }
        });
        JButton bookcBtn = new JButton("Book Cargo Flight");
        bookcBtn.setPreferredSize(new Dimension(200, 50));

        system_start_panel.add(bookpBtn);
        system_start_panel.add(bookcBtn);
        system_start_panel.add(checkBtn);

        add(system_start_panel);

        pack();

    }

}
