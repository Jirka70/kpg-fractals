package org.example;

import org.example.fractals.TurtleState;

public class Turtle {
    private double x;
    private double y;
    private double angle;

    public Turtle(double x, double y) {
        move(x,y);
        this.angle = 0;
    }

    public void turnLeft(double radians) {
        angle += radians;
    }

    public void turnRight(double radians) {
        angle -= radians;
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void loadState(TurtleState turtleState) {
        move(turtleState.x, turtleState.y);
        angle = turtleState.angle;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }
}
