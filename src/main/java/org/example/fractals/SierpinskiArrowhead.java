package org.example.fractals;

import javafx.scene.layout.Pane;
import org.example.util.LineDrawer;

public class SierpinskiArrowhead extends Fractal {
    private static final double TURNING_ANGLE = Math.PI / 3;
    public SierpinskiArrowhead(double startX, double startY) {
        super(startX, startY);
    }

    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        drawForwardA(rootPane, numberOfIterations, lineLength, colored);
        if (colored) {
            LineDrawer.colorLines(lines);
        }
        LineDrawer.displayLines(rootPane, lines);
    }

    private void drawForwardA(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }

        drawForwardB(rootPane, numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        drawForwardA(rootPane, numberOfIterations-1, lineLength / 2, colored);
        turnRight();
        drawForwardB(rootPane, numberOfIterations-1, lineLength / 2, colored);
    }

    private void drawForwardB(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        if (numberOfIterations == 0) {
            processLine(lineLength);
            return;
        }

        drawForwardA(rootPane, numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        drawForwardB(rootPane, numberOfIterations-1, lineLength / 2, colored);
        turnLeft();
        drawForwardA(rootPane, numberOfIterations-1, lineLength / 2, colored);
    }

    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }
}
