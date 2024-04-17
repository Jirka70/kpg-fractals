package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.fractals.*;


public class App extends Application {
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private final BorderPane rootPane = new BorderPane();
    private final FractalModel fractalModel = new FractalModel();
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        initComponents();

    }

    private void initComponents() {
        Pane pane = new Pane();
        VBox rightBox = getRightBox();
        rightBox.prefWidthProperty().bind(rootPane.widthProperty().divide(4));
        pane.prefWidthProperty().bind(rootPane.widthProperty().multiply(3).divide(4));
        rootPane.setCenter(pane);
        rootPane.setRight(rightBox);
    }

    private VBox getRightBox() {
        VBox rightBox = new VBox(15);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton gosperBox = new RadioButton("Gosper");
        gosperBox.setToggleGroup(toggleGroup);
        RadioButton islandsAndLakes = new RadioButton("Islands and lakes");
        islandsAndLakes.setToggleGroup(toggleGroup);
        RadioButton koch = new RadioButton("Koch");
        koch.setToggleGroup(toggleGroup);
        RadioButton sierpinskiArrowhead = new RadioButton("Sierpinski arrowhead");
        sierpinskiArrowhead.setToggleGroup(toggleGroup);
        RadioButton tree = new RadioButton("Tree");
        tree.setToggleGroup(toggleGroup);
        RadioButton flake = new RadioButton("Snowflake");
        flake.setToggleGroup(toggleGroup);
        ComboBox<RadioButton> comboBox = new ComboBox<>();
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            comboBox.setPromptText(null);
            if (newValue != null) {
                comboBox.setPromptText(((RadioButton) newValue).getText());
                fractalModel.fractalProperty().set(((RadioButton) newValue).getText());
            }
        });

        comboBox.prefWidthProperty().bind(rightBox.widthProperty().multiply(.8));
        comboBox.getItems().addAll(gosperBox, islandsAndLakes, koch, sierpinskiArrowhead, tree, flake);
        rightBox.setAlignment(Pos.CENTER);
        CheckBox colored = new CheckBox("Color fractal");
        Button apply = new Button("Apply");
        fractalModel.hsbEffectProperty().bind(colored.selectedProperty());
        rightBox.getChildren().addAll(comboBox, colored, apply);
        apply.setOnAction(e -> displayFractal());

        return rightBox;
    }

    private void displayFractal() {
        String fractal = fractalModel.getFractal();
        if (fractal == null) {
            return;
        }
        ((Pane)rootPane.getCenter()).getChildren().clear();
        if (fractal.equals("Gosper")) {
            new Gosper(150, 400).displayFractal((Pane) rootPane.getCenter(), 5, 100, fractalModel.isHsbEffect());
        } else if (fractal.equals("Islands and lakes")) {
            new IslandsAndLakes(150, 150).displayFractal((Pane) rootPane.getCenter(), 3, 10, fractalModel.isHsbEffect());
        } else if (fractal.equals("Koch")) {
            new Koch(100, 0).displayFractal((Pane) rootPane.getCenter(), 6, 50, fractalModel.isHsbEffect());
        } else if (fractal.equals("Sierpinski arrowhead")) {
            new SierpinskiArrowhead(400, 100).displayFractal((Pane) rootPane.getCenter(), 7, 400, fractalModel.isHsbEffect());
        } else if (fractal.equals("Tree")) {
            new Tree(WIDTH/2-100, HEIGHT).displayFractal((Pane) rootPane.getCenter(), 7, 400, fractalModel.isHsbEffect());
        } else if (fractal.equals("Snowflake")) {
            new SnowFlake(150, 50).displayFractal((Pane) rootPane.getCenter(), 4, 5, fractalModel.isHsbEffect());
        }
    }
}
