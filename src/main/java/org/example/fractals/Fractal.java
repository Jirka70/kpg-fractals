package org.example.fractals;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import org.example.Point;
import org.example.Turtle;
import org.example.util.EndingPointCalculator;
import org.example.util.LineDrawer;

import java.util.ArrayList;
import java.util.List;

public abstract class Fractal {
    protected final List<Line> lines = new ArrayList<>();
    protected final Turtle turtle;
    protected Fractal(double x, double y) {
        turtle = new Turtle(x, y);
    }

    public abstract void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored);

    protected void processLine(double lineLength) {
        double startX = turtle.getX();
        double startY = turtle.getY();
        Point endingPoint = EndingPointCalculator.calculateEndingPointOfLine(startX, startY,
                lineLength, turtle.getAngle());

        double endX = endingPoint.x;
        double endY = endingPoint.y;


        Line line = LineDrawer.createLine(startX, startY, endX, endY);
        lines.add(line);
        turtle.move(endX, endY);
    }
}
