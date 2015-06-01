package com.bulbairways.gui.PassengerFlight;

import com.bulbairways.Model;
import com.bulbairways.system.PassengerPlane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Etienne on 2015-06-01.
 */
public class PassengerFlightChooseAirport extends JFrame {

    protected Model model;
    protected String currentId;

    public PassengerFlightChooseAirport(Model model) {

        this.model = model;
        initUI();

    }

    public void initUI() {

        createLayout();

        setTitle("Choose Destination");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void createLayout() {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));
        panel.setLayout(new GridLayout(3, 1, 20, 20));

        String[] airports = model.getAirports();

        for (String airport : airports) {

            JButton btn = new JButton(airport);
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String chosenDestination = ((JButton) e.getSource()).getText();

                    model.setFlightDestination(chosenDestination);

                    new PassengerFlightChooseFlight(model).setVisible(true);
                    setVisible(false);
                }

            });

            panel.add(btn);

        }

        add(panel);

    }

}
