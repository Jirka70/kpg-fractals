package org.example.fractals;

import javafx.scene.layout.Pane;
import org.example.Point;
import org.example.util.EndingPointCalculator;
import org.example.util.LineDrawer;

public class SnowFlake extends Fractal {
    private static final double TURNING_ANGLE = Math.PI / 3;
    private static final double LINE_DIFFERENCE = 2;

    public SnowFlake(double x, double y) {
        super(x, y);
    }

    @Override
    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        drawForward(numberOfIterations, lineLength);
        turnLeft();
        turnLeft();
        drawForward(numberOfIterations, lineLength);
        turnLeft();
        turnLeft();
        drawForward(numberOfIterations, lineLength);

        if (colored) {
            LineDrawer.colorLines(lines);
        }
        LineDrawer.displayLines(rootPane, lines);
    }

    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }

    private void drawForward(int numberOfIterations, double lineLength) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }

        drawForward(numberOfIterations-1, lineLength);
        turnRight();
        drawForward(numberOfIterations-1, lineLength);
        turnLeft();
        turnLeft();
        drawForward(numberOfIterations-1, lineLength);
        turnRight();
        drawForward(numberOfIterations-1, lineLength);
    }

    private void moveForward(int numberOfIterations, double lineLength) {
        if (numberOfIterations == 0) {
            Point endPoint = EndingPointCalculator.calculateEndingPointOfLine(turtle.getX(),turtle.getY(), lineLength,
                    turtle.getAngle());
            turtle.move(endPoint.x, endPoint.y);
            return;
        }

        moveForward(numberOfIterations - 1, lineLength / LINE_DIFFERENCE);
        moveForward(numberOfIterations - 1, lineLength / LINE_DIFFERENCE);
        moveForward(numberOfIterations - 1, lineLength / LINE_DIFFERENCE);
    }
}
