package com.bulbairways.file;

import com.google.gson.Gson;

import java.io.*;

/**
 * Created by Etienne on 2015-05-25.
 */
public class AirportFileManager {

    public boolean fileExist(String fileName) {

        try {

            FileReader fileReader = new FileReader(fileName);

        } catch(IOException ex) {

            return false;

        }

        return true;

    }

    public String getClientAccount(String fileName) {

        String fileLine = null;
        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            fileLine = bufferedReader.readLine();

            bufferedReader.close();

        } catch(IOException ex) {

        }

        return fileLine;

    }

    public void registerUser(String fileName, String clientName) {
        try {

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            System.out.println(fileWriter.toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(clientName);

            bufferedWriter.close();

        } catch (IOException ex) {

        }
    }

    public String getFlightDet(String fileName) {

        String fileLine = null;
        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            fileLine = bufferedReader.readLine();

            bufferedReader.close();

        } catch(IOException ex) {

        }

        return fileLine;

    }

    public String flightDetToObject(String fileName) {

        String fileLine = null;
        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            fileLine = bufferedReader.readLine();

            bufferedReader.close();

        } catch(IOException ex) {

        }

        return fileLine;

    }

    public void saveFlight(String fileName, Object object) {

        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);

        try {

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            System.out.println(fileWriter.toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(jsonObject);

            bufferedWriter.close();

        } catch (IOException ex) {

        }
    }

}
