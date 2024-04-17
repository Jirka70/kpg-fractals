package org.example.fractals;

import javafx.scene.layout.Pane;
import org.example.util.LineDrawer;


public class Gosper extends Fractal {
    private static final double TURNING_ANGLE = Math.PI / 3;
    public Gosper(double startX, double startY) {
        super(startX, startY);
    }

    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        drawLForward(numberOfIterations, lineLength);
        if (colored) {
            LineDrawer.colorLines(lines);
        }
        LineDrawer.displayLines(rootPane, lines);
    }

    private void drawLForward(int numberOfIterations, double lineLength) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }

        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnLeft();
        drawRForward(numberOfIterations-1, lineLength / 2);
        turnLeft();
        turnLeft();
        drawRForward(numberOfIterations - 1, lineLength / 2);
        turnRight();
        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnRight();
        turnRight();
        drawLForward(numberOfIterations - 1, lineLength / 2);
        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnRight();
        drawRForward(numberOfIterations - 1, lineLength / 2);
        turnLeft();
    }

    private void drawRForward(int numberOfIterations, double lineLength) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }

        turnRight();
        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnLeft();
        drawRForward(numberOfIterations - 1, lineLength / 2);
        drawRForward(numberOfIterations - 1, lineLength / 2);
        turnLeft();
        turnLeft();
        drawRForward(numberOfIterations - 1, lineLength / 2);
        turnLeft();
        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnRight();
        turnRight();
        drawLForward(numberOfIterations - 1, lineLength / 2);
        turnRight();
        drawRForward(numberOfIterations - 1, lineLength / 2);
    }

    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }
}
