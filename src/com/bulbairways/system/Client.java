package com.bulbairways.system;

/**
 * Created by Etienne on 2015-05-25.
 */
public class Client {

    private String name;
    private String idNumber;

    public Client(String n, String id) {
        name = n;
        idNumber = id;
    }

    public String getName() {
        return name;
    }
    public String getIdNumber() {
        return idNumber;
    }
}
