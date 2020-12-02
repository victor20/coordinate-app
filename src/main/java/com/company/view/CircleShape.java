package com.company.view;

public class CircleShape {
    private int cartesianX, cartesianY, x, y, width, height;

    public CircleShape(int cartesianX, int cartesianY, int width, int height, int parentWidth, int parentHeight, int max) {
        this.cartesianX = cartesianX;
        this.cartesianY = cartesianY;
        this.width = width;
        this.height = height;

        Double x = ((max + Double.valueOf(cartesianX))/(max*2))*Double.valueOf(parentWidth);
        Double y = ((max - Double.valueOf(cartesianY))/(max*2))*Double.valueOf(parentHeight);

        this.x = x.intValue();
        this.y = y.intValue();
    }

    public int getCartesianX() {
        return cartesianX;
    }

    public int getCartesianY() {
        return cartesianY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean intercept(int xPoint, int yPoint) {
        if (xPoint < x + 10 && xPoint > x && yPoint < y + 10 && yPoint > y) {
            return true;
        }
        return false;
    }


}
