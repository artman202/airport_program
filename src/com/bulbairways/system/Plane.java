package com.bulbairways.system;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Etienne on 2015-05-15.
 */
public abstract class Plane {

    protected transient Integer economy_seat = 0;
    protected transient Integer first_class_seat = 0;
    protected transient Integer private_cabin = 0;
    protected transient Integer cargo_capacity = 400;
    protected Integer econoSeatPrice = 700;
    protected Integer firstSeatPrice = 1500;
    protected Integer privaSeatPrice = 2700;
    protected String next_destination;
    protected String flight_time;
    protected String flight_date;
    protected String flight_code;

    public Plane(String dest, String date, String time, String code) {
        next_destination = dest;
        flight_date = date;
        flight_time = time;
        flight_code = code;
    }

    public String getFlightDet() {
        return "<html>Destination: "+next_destination+"<br />Date: "+flight_date+"<br />Time: "+flight_time+"<br />Flight Code: "+getFlight_code()+"</html>";
    }

    public String[] getAirports() {
        String[] airports = {"Cape Town", "Durban", "Johannesburg"};
        Arrays.sort(airports);
        return airports;
    }

    public Integer getTicketPrice(String seatType, Integer numberSeats) {

        if (seatType.contains("Economy")) {
            return numberSeats * econoSeatPrice;
        } else if (seatType.contains("First")) {
            return numberSeats * firstSeatPrice;
        } else if (seatType.contains("Private")) {
            return numberSeats * privaSeatPrice;
        }

        return null;

    }

    public void setNewSeatNum(String seatType, Integer numberSeats) {

        if (seatType.contains("Economy")) {

            this.economy_seat = this.economy_seat - numberSeats;

        } else if (seatType.contains("First")) {

            this.first_class_seat = this.first_class_seat - numberSeats;

        } else if (seatType.contains("Private")) {

            this.private_cabin = this.private_cabin - numberSeats;

        }
    }

// Setters
    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }
    public void setEconomy_seat(Integer economy_seat) {
        this.economy_seat = economy_seat;
    }
    public void setFirst_class_seat(Integer first_class_seat) {
        this.first_class_seat = first_class_seat;
    }
    public void setPrivate_cabin(Integer private_cabin) {
        this.private_cabin = private_cabin;
    }
    public void setCargo_capacity(Integer cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }
    public void setNext_destination(String next_destination) {
        this.next_destination = next_destination;
    }

// Getters
    public String getFlight_code() {
    return flight_code;
}
    public Integer getEconomy_seat() {
        return economy_seat;
    }
    public Integer getFirst_class_seat() {
        return first_class_seat;
    }
    public Integer getPrivate_cabin() {
        return private_cabin;
    }
    public Integer getCargo_capacity() {
        return cargo_capacity;
    }
    public String getNext_destination() {
        return next_destination;
    }
    public String getFlight_time() {
        return flight_time;
    }
    public String getFlight_date() {
        return flight_date;
    }
}
