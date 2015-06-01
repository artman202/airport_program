package com.bulbairways.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Etienne on 2015-05-15.
 */
public class PassengerPlane extends Plane {

    protected Integer economy_seat = 20;
    protected Integer first_class_seat = 10;

    public PassengerPlane(String dest, String date, String time, String code) {
        super(dest, date, time, code);
    }

    public void setNewSeatNum(String seatType, Integer numberSeats) {

        if (seatType.contains("Economy")) {

            this.economy_seat = this.economy_seat - numberSeats;

        } else if (seatType.contains("First")) {

            this.first_class_seat = this.first_class_seat - numberSeats;

        }

    }

    @Override
    public Integer getEconomy_seat() {
        return economy_seat;
    }

    @Override
    public void setEconomy_seat(Integer economy_seat) {
        this.economy_seat = economy_seat;
    }

    @Override
    public Integer getFirst_class_seat() {
        return first_class_seat;
    }

    @Override
    public void setFirst_class_seat(Integer first_class_seat) {
        this.first_class_seat = first_class_seat;
    }
}
