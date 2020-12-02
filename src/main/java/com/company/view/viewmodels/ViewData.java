package com.company.view.viewmodels;

import com.company.model.models.Coordinate;

import java.util.ArrayList;

public class ViewData {

    private ArrayList<Coordinate> coordinates;
    private boolean updating;

    public ViewData(ArrayList<Coordinate> coordinates, boolean updating) {
        this.coordinates = coordinates;
        this.updating = updating;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public boolean isUpdating() {
        return updating;
    }
}
