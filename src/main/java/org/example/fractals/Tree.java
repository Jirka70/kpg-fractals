package org.example.fractals;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.example.Point;
import org.example.util.EndingPointCalculator;
import org.example.util.LineDrawer;

import java.util.Stack;

public class Tree extends Fractal {
    private static final double TURNING_ANGLE = Math.PI / 4;
    private static final Color YOUNG_TREE_PART_COLOR = Color.GREEN;
    private static final Color OLD_TREE_PART_COLOR = Color.BROWN;

    private final Stack<TurtleState> lastStates = new Stack<>();
    public Tree(double x, double y) {
        super(x, y);
        turtle.turnRight(Math.PI);
    }

    @Override
    public void displayFractal(Pane rootPane, int numberOfIterations, double lineLength, boolean colored) {
        drawYoungTreePart(numberOfIterations, lineLength, colored);
        LineDrawer.displayLines(rootPane, lines);
    }

    private void drawYoungTreePart(int numberOfIterations, double lineLength, boolean colored) {
        if (numberOfIterations == 0) {
            Line line = createColoredLine(lineLength, !colored ? Color.BLACK : YOUNG_TREE_PART_COLOR);
            lines.add(line);
            turtle.move(line.getEndX(), line.getEndY());
            return;
        }

        drawOldTreePart(numberOfIterations - 1, lineLength / 2, colored);
        addTurtleState();
        turnLeft();
        drawYoungTreePart(numberOfIterations-1, lineLength / 2, colored);
        removeTurtleState();
        addTurtleState();
        turnRight();
        drawYoungTreePart(numberOfIterations - 1, lineLength / 2, colored);
        removeTurtleState();
        drawOldTreePart(numberOfIterations - 1, lineLength / 2, colored);
        drawYoungTreePart(numberOfIterations - 1, lineLength / 2, colored);

    }


    private void addTurtleState() {
        TurtleState turtleState = new TurtleState(turtle.getX(), turtle.getY(), turtle.getAngle());
        lastStates.add(turtleState);
    }

    private void removeTurtleState() {
        if (lastStates.isEmpty()) {
            return;
        }
        TurtleState removedTurtleState = lastStates.pop();
        turtle.loadState(removedTurtleState);

    }
    private void turnLeft() {
        turtle.turnLeft(TURNING_ANGLE);
    }

    private void turnRight() {
        turtle.turnRight(TURNING_ANGLE);
    }

    private Line createColoredLine(double lineLength, Color color) {
        double startX = turtle.getX();
        double startY = turtle.getY();
        Point endingPoint = EndingPointCalculator.calculateEndingPointOfLine(startX, startY,
                lineLength, turtle.getAngle());
        Line line = LineDrawer.createLine(startX, startY, endingPoint.x, endingPoint.y);
        line.setStroke(color);
        return line;
    }

    private void drawOldTreePart(int numberOfIterations, double lineLength, boolean colored) {
        if (numberOfIterations == 0) {
            Line line = createColoredLine(lineLength, colored ? OLD_TREE_PART_COLOR : Color.BLACK);
            lines.add(line);
            turtle.move(line.getEndX(), line.getEndY());
            return;
        }

        drawOldTreePart(numberOfIterations - 1, lineLength / 2, colored);
        drawOldTreePart(numberOfIterations - 1, lineLength / 2, colored);
    }
}
