package org.example.fractals;

import javafx.scene.layout.Pane;
import org.example.util.LineDrawer;

public class Koch extends Fractal {
    private static final double TURNING_ANGLE = Math.PI/2;

    public Koch(double startX, double startY) {
        super(startX, startY);
    }

    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
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

        drawForward(numberOfIterations - 1, lineLength / 2, colored);
        turnLeft();
        drawForward(numberOfIterations - 1, lineLength / 2, colored);
        turnRight();
        drawForward(numberOfIterations - 1, lineLength / 2, colored);
        turnRight();
        drawForward(numberOfIterations - 1, lineLength / 2, colored);
        turnLeft();
        drawForward(numberOfIterations - 1, lineLength / 2, colored);
    }

    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }
}
