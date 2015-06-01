package com.bulbairways.system;


import com.bulbairways.Model;
import com.bulbairways.gui.PassengerFlight.PassengerFlightChooseAirport;

import javax.swing.*;

/**
 * Created by Etienne on 2015-05-15.
 */
public class MainActivity {
    public static void main(String[] args) {

        Model model = new Model();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                LoginFrame systemStart = new LoginFrame(model);
//                systemStart.setVisible(true);
//                MainFrame systemStart = new MainFrame(model);
//                systemStart.setVisible(true);
                PassengerFlightChooseAirport systemStart = new PassengerFlightChooseAirport(model);
                systemStart.setVisible(true);
            }
        });

    }
}
