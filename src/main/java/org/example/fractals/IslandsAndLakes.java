package org.example.fractals;

import javafx.scene.layout.Pane;
import org.example.Point;
import org.example.util.EndingPointCalculator;
import org.example.util.LineDrawer;

public class IslandsAndLakes extends Fractal {
    private final double TURNING_ANGLE = Math.PI / 2;
    public IslandsAndLakes(double startX, double startY) {
        super(startX, startY);
    }

    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        drawForward(numberOfIterations, lineLength, colored);
        turnLeft();
        drawForward(numberOfIterations, lineLength, colored);
        turnLeft();
        drawForward(numberOfIterations, lineLength, colored);
        turnLeft();
        drawForward(numberOfIterations, lineLength, colored);
        if (colored) {
            LineDrawer.colorLines(lines);
        }
        LineDrawer.displayLines(rootPane, lines);
    }

    private void drawForward(int numberOfIterations, double lineLength, boolean colored) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }


        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        moveForward(numberOfIterations-1, lineLength/ 2);
        turnRight();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        moveForward(numberOfIterations-1, lineLength / 2);
        turnLeft();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward( numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        moveForward(numberOfIterations-1, lineLength / 2);
        turnLeft();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        moveForward(numberOfIterations-1, lineLength / 2);
        turnRight();
        drawForward(numberOfIterations-1, lineLength / 2,colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
        drawForward(numberOfIterations-1, lineLength / 2, colored);
    }

    private void moveForward(int numberOfIterations, double lineLength) {
        if (numberOfIterations == 0) {
            Point endPoint = EndingPointCalculator.calculateEndingPointOfLine(turtle.getX(),turtle.getY(), lineLength,
                    turtle.getAngle());
            turtle.move(endPoint.x, endPoint.y);
            return;
        }

        moveForward(numberOfIterations-1, lineLength / 2);
        moveForward(numberOfIterations-1, lineLength / 2);
        moveForward(numberOfIterations-1, lineLength / 2);
        moveForward(numberOfIterations-1, lineLength / 2);
        moveForward(numberOfIterations-1, lineLength / 2);
        moveForward(numberOfIterations-1, lineLength / 2);
    }

    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }


}
