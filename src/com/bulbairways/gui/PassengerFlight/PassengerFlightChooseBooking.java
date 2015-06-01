package com.bulbairways.gui.PassengerFlight;

import com.bulbairways.Model;
import com.bulbairways.file.AirportFileManager;
import com.bulbairways.system.PassengerPlane;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Etienne on 2015-06-01.
 */
public class PassengerFlightChooseBooking extends JFrame {

    protected Model model;
    protected String currentId;

    public PassengerFlightChooseBooking (Model model) {

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
        panel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));
        panel.setLayout(new BorderLayout());

        AirportFileManager handler = new AirportFileManager();
        Gson gson = new Gson();

        String flightObjStr = handler.flightDetToObject(model.getFlightCode());
        PassengerPlane flightObj = gson.fromJson(flightObjStr, PassengerPlane.class);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(6, 1, 0, 0));

        panelCenter.add(new JLabel("<html>Economy seats open: " + flightObj.getEconomy_seat()));
        panelCenter.add(new JLabel("First class seats open: " + flightObj.getFirst_class_seat()));

        ButtonGroup seatingGroup = new ButtonGroup();
        JRadioButton ecoSeat = new JRadioButton("Economy Seating (R700.00 p/s)");
        JRadioButton firSeat = new JRadioButton("First Class Seating (R1500.00 p/s)");
        seatingGroup.add(ecoSeat);
        seatingGroup.add(firSeat);
        panelCenter.add(ecoSeat);
        panelCenter.add(firSeat);

        JTextField bookNumSeats = new JTextField("Book number of seats");
        bookNumSeats.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                bookNumSeats.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        panelCenter.add(bookNumSeats);

        panel.add(panelCenter, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();

        JButton btn = new JButton("Confirm Booking");
        btn.setPreferredSize(new Dimension(150, 50));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String seatSelect = model.getSelectedRadioText(seatingGroup);
                Integer numSeats = Integer.parseInt(bookNumSeats.getText());

                model.setBookNumSeat(numSeats);
                model.setFlightSeating(seatSelect);

                new PassengerFlightChooseBookingConfirm(model).setVisible(true);
                setVisible(false);
            }
        });
        panelBottom.add(btn);

        panel.add(panelBottom, BorderLayout.SOUTH);

        add(panel);

    }
}
