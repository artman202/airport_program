package com.bulbairways.gui.PassengerFlight;

import com.bulbairways.Model;
import com.bulbairways.file.AirportFileManager;
import com.bulbairways.gui.MainFrame;
import com.bulbairways.system.PassengerPlane;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Etienne on 2015-06-01.
 */
public class PassengerFlightChooseBookingConfirm extends JFrame {

    protected Model model;
    protected String currentId;

    public PassengerFlightChooseBookingConfirm (Model model) {

        this.model = model;
        initUI();

    }

    public void initUI() {

        createLayout();

        setTitle("Confirm Booking");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void createLayout() {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));
        panel.setLayout(new BorderLayout());

        AirportFileManager handler = new AirportFileManager();
        Gson gson = new Gson();
        String flightObjStr = handler.flightDetToObject(model.getFlightCode());
        PassengerPlane flightObj = gson.fromJson(flightObjStr, PassengerPlane.class);

        JLabel flightBooking = new JLabel(model.getBookFlightDet());
        panel.add(flightBooking, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();

        JButton btn = new JButton("Book Flight");
        btn.setPreferredSize(new Dimension(150, 50));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                flightObj.setNewSeatNum(model.getFlightSeating(), model.getBookNumSeat());

                handler.saveFlight(model.getFlightCode(), flightObj);

                new MainFrame(model).setVisible(true);
                setVisible(false);
            }
        });
        panelBottom.add(btn);

        panel.add(panelBottom, BorderLayout.SOUTH);

        add(panel);

    }

}
