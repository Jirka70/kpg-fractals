package org.example.util;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;

import java.util.List;

public class LineDrawer {

    public static Line createLine(double startX, double startY, double endX, double endY) {
        return new Line(startX, startY, endX, endY);
    }
    public static void colorLines(List<Line> lines) {
        double startHue = 0;
        double endHue = 360;
        for (int i = 0; i < lines.size(); i++) {
            Line currentLine = lines.get(i);
            double hue = startHue + (endHue - startHue) * (i / (double) lines.size());
            Color color = Color.hsb(hue, 1.0, 1.0);
            Stop[] stops = new Stop[] {
                    new Stop(0, color),
                    new Stop(1, color)
            };
            LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true,
                    CycleMethod.NO_CYCLE, stops);

            currentLine.setStroke(gradient);
            currentLine.setStrokeWidth(1);
        }
    }

    public static void displayLines(Pane pane, List<Line> lines) {
        pane.getChildren().addAll(lines);
    }
}
