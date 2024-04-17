package org.example.util;

import org.example.Point;

public class EndingPointCalculator {
    public static Point calculateEndingPointOfLine(double startX, double startY, double lineLength, double angle) {
        double endX = Math.sin(angle) * lineLength + startX;
        double endY = Math.cos(angle) * lineLength + startY;
        return new Point(endX, endY);
    }
}
