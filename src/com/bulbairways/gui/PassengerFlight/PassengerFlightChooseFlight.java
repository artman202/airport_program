package com.bulbairways.gui.PassengerFlight;

import com.bulbairways.Model;
import com.bulbairways.file.AirportFileManager;
import com.bulbairways.system.PassengerPlane;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * Created by Etienne on 2015-06-01.
 */
public class PassengerFlightChooseFlight extends JFrame {

    protected Model model;
    protected String currentId;

    public PassengerFlightChooseFlight (Model model) {

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

        AirportFileManager handler = new AirportFileManager();
        Gson gson = new Gson();
        java.util.List<PassengerPlane> flightList = new ArrayList<PassengerPlane>(0);

        flightList.add(new PassengerPlane("Durban", "2nd October", "12:00", "FD1"));
        flightList.add(new PassengerPlane("Cape Town", "2nd October", "12:00", "FD2"));

        for (int x = 0; x < flightList.size(); x++) {

            PassengerPlane flightObj = flightList.get(x);

            if(flightObj.getNext_destination().contains(model.getFlightDestination())) {

                JButton btn = new JButton(flightObj.getFlightDet());
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (handler.fileExist(flightObj.getFlight_code())) {

                            model.setFlightCode(flightObj.getFlight_code());

                            new PassengerFlightChooseBooking(model).setVisible(true);
                            setVisible(false);

                        } else {

                            handler.saveFlight(flightObj.getFlight_code(), flightObj);

                        }
                    }
                });

                panel.add(btn);

            }

        }

        add(panel);

    }

}
