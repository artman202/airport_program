package com.bulbairways.system;

/**
 * Created by Etienne on 2015-05-15.
 */
public class LuxuryJetPlane extends Plane {

    protected Integer first_class_seat = 20;
    protected Integer private_cabin = 10;

    public LuxuryJetPlane(String dest, String date, String time, String code) {
        super(dest, date, time, code);
    }

}
