package com.company.model.models;

public class Coordinate {

    private int x;
    private int y;
    private String name;

    public Coordinate(String coordinateString) {
        String[] coordinateData = coordinateString.split(", ");
        this.x = Integer.parseInt(coordinateData[0]);
        this.y = Integer.parseInt(coordinateData[1]);
        this.name = coordinateData[2];
    }

    public Coordinate(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
