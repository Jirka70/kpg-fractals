package org.example;

import javafx.beans.property.*;
import org.example.fractals.Fractal;

public class FractalModel {
    private final StringProperty fractal = new SimpleStringProperty();
    private final DoubleProperty xProperty = new SimpleDoubleProperty();
    private final DoubleProperty yProperty = new SimpleDoubleProperty();
    private final BooleanProperty hsbEffect = new SimpleBooleanProperty();

    public String getFractal() {
        return fractal.get();
    }

    public StringProperty fractalProperty() {
        return fractal;
    }

    public void setFractal(String fractal) {
        this.fractal.set(fractal);
    }

    public double getXProperty() {
        return xProperty.get();
    }

    public DoubleProperty xProperty() {
        return xProperty;
    }

    public void setX(double xProperty) {
        this.xProperty.set(xProperty);
    }

    public double getYProperty() {
        return yProperty.get();
    }

    public DoubleProperty yProperty() {
        return yProperty;
    }

    public void setYProperty(double yProperty) {
        this.yProperty.set(yProperty);
    }

    public boolean isHsbEffect() {
        return hsbEffect.get();
    }

    public BooleanProperty hsbEffectProperty() {
        return hsbEffect;
    }

    public void setHsbEffect(boolean hsbEffect) {
        this.hsbEffect.set(hsbEffect);
    }
}
