package com.company.view;

import com.company.model.models.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class MapPanel extends JPanel implements MouseMotionListener {

    private ArrayList<Coordinate> coordinates;
    private ArrayList<CircleShape> circleShapes;

    public MapPanel() {
        coordinates = new ArrayList<>();
        circleShapes = new ArrayList<>();
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        graphics2D.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        for(Coordinate coordinate: coordinates) {
            CircleShape circleShape = new CircleShape(coordinate.getX(),coordinate.getY(),10,10, getWidth(), getHeight(), 1500);
            this.circleShapes.add(circleShape);
            graphics2D.setColor(Color.RED);
            Shape circle = new Ellipse2D.Double(circleShape.getX(), circleShape.getY(), 10, 10);
            graphics2D.fill(circle);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(coordinate.getX() + ", " + coordinate.getY(), circleShape.getX() + 20 , circleShape.getY() + 10);
        }
    }

    public void addCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        this.validate();
        this.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(CircleShape circleShape:  circleShapes) {
            if (circleShape.intercept(e.getX(), e.getY())) {
                //System.out.println("Over Circle");
            }
        }

    }
}
