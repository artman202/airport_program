package com.bulbairways;

import javax.swing.*;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by Etienne on 2015-05-26.
 */
public class Model {

    protected String name;
    protected String id;
    protected String flightDest;
    protected String flightType;
    protected String flightCode;
    protected String flightSeating;
    protected Integer bookNumSeat;
    protected Integer flightPrice;

    public String[] getAirports() {
        String[] airports = {"Cape Town", "Johannesburg", "Durban"};
        Arrays.sort(airports);
        return airports;
    }

    public String getSelectedRadioText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public String getBookFlightDet() {
        return "<html>Client Name: "+getName()+"<br><br>Client ID: "+getId()+"<br><br>Ticket(s) Seating: "+getFlightSeating()+"<br><br>Number of Seats: "+getBookNumSeat()+"<br><br>Ticket(s) Price: R"+getFlightPrice()+".00</html>";
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getFlightType() {
        return flightType;
    }
    public String getFlightDestination() {
        return flightDest;
    }
    public String getFlightCode() {
        return flightCode;
    }
    public String getFlightSeating() {
        return flightSeating;
    }
    public Integer getBookNumSeat() {
        return bookNumSeat;
    }
    public Integer getFlightPrice() {
        return flightPrice;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
    public void setFlightDestination(String flightDestination) {
        this.flightDest = flightDestination;
    }
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    public void setFlightSeating(String flightSeating) {
        this.flightSeating = flightSeating;
    }
    public void setBookNumSeat(Integer flightNumSeats) {
        this.bookNumSeat = flightNumSeats;
    }
    public void setFlightPrice(Integer flightPrice) {
        this.flightPrice = flightPrice;
    }
}
