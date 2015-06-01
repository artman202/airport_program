package com.bulbairways.system;

/**
 * Created by Etienne on 2015-05-15.
 */
public class CargoPlane extends Plane {

    protected Integer cargo_capacity = 1200;

    public CargoPlane(String dest, String date, String time, String code) {
        super(dest, date, time, code);
    }

}
