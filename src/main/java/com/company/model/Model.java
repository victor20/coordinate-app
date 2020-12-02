package com.company.model;

import com.company.model.models.ContactInfo;
import com.company.model.models.Coordinate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Model {

    private URLConnection connection = null;
    private static final String SERVER_URL = "XXXXX";

    public Model() {

    }

    public ArrayList<Coordinate> getCoordinates() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        try {
            connection =  new URL(SERVER_URL).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                if(inputLine.charAt(0) != '#') {
                    Coordinate coordinate = new Coordinate(inputLine);
                    coordinates.add(coordinate);
                }
            }
            br.close();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return coordinates;
    }

    public ContactInfo getContactInfo() {
        return new ContactInfo(
                "Erik",
                "Jansson",
                "erik@gamil.com",
                "Gatan 12",
                "Staden",
                "14499");
    }

    public void parseCoordinates(String text) {
        System.out.println(text);
    }

}
