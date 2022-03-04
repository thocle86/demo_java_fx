package fr.cefim.demofx.controllers;

import fr.cefim.demofx.models.Color;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorController implements Initializable {

    private final Color color = new Color(0, 0, 0);
    private final double MIN_SLIDER = color.getMinRgb();
    private final double MAX_SLIDER = color.getMaxRgb();
    enum COLOR{RED, GREEN, BLUE};

    @FXML
    private Slider sliderRed;

    @FXML
    private Slider sliderGreen;

    @FXML
    private Slider sliderBlue;

    @FXML
    private TextField textFieldRed;

    @FXML
    private TextField textFieldGreen;

    @FXML
    private TextField textFieldBlue;

    @FXML
    private TextField textFieldHex;

    @FXML
    private Pane paneColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initParamSliders(MIN_SLIDER, MAX_SLIDER, true, true, 100);
        updateInterface();

        updateColorFromSliders();

        updateColorFromTextFields();

        updateColorFromTextFieldHex();
    }

    // <<< UPDATE COLOR FROM SLIDERS___start >>>//
    private void updateColorFromSliders() {
        String red;
        sliderRed.valueProperty().addListener((observableValue, oldNumber, newNumber) -> setColorFromSliders(COLOR.RED));
        sliderGreen.valueProperty().addListener((observableValue, oldNumber, newNumber) -> setColorFromSliders(COLOR.GREEN));
        sliderBlue.valueProperty().addListener((observableValue, oldNumber, newNumber) -> setColorFromSliders(COLOR.BLUE));

    }

    private void setColorFromSliders(COLOR rgb) {
        try {
            switch (rgb) {
                case RED -> color.setRed((int) sliderRed.getValue());
                case GREEN -> color.setGreen((int) sliderGreen.getValue());
                case BLUE -> color.setBlue((int) sliderBlue.getValue());
            }
        } catch (IllegalArgumentException e) {
            // aucune action à réaliser, l'interface est mise à jour ensuite
        } finally {
            updateInterface();
        }
    }
    // <<< UPDATE COLOR FROM SLIDERS___end >>>//

    // <<< UPDATE COLOR FROM TEXT_FIELD_RGB___start >>>//
    private void updateColorFromTextFields() {
        textFieldRed.setOnAction(actionEvent -> setColorFromTextFiedls(COLOR.RED));
        textFieldGreen.setOnAction(actionEvent -> setColorFromTextFiedls(COLOR.GREEN));
        textFieldBlue.setOnAction(actionEvent -> setColorFromTextFiedls(COLOR.BLUE));
    }

    private void setColorFromTextFiedls(COLOR rgb) {
        try {
            switch (rgb) {
                case RED -> color.setRed(Integer.parseInt(textFieldRed.getText()));
                case GREEN -> color.setGreen(Integer.parseInt(textFieldGreen.getText()));
                case BLUE -> color.setBlue(Integer.parseInt(textFieldBlue.getText()));
            }
        } catch (IllegalArgumentException ignored) {
            // aucune action à réaliser, l'interface est mise à jour ensuite
        } finally {
            updateInterface();
        }
    }
    // <<< UPDATE COLOR FROM TEXT_FIELD_RGB___end >>>//

    // <<< UPDATE COLOR FROM TEXT_FIELD_HEX___start >>>//
    private void updateColorFromTextFieldHex() {
        textFieldHex.setOnAction(actionEvent -> {
            try {
                color.setHexValue(textFieldHex.getText());
            } catch (IllegalArgumentException e) {
                // aucune action à réaliser, l'interface est mise à jour ensuite
            } finally {
                updateInterface();
            }
        });
    }
    // <<< UPDATE COLOR FROM TEXT_FIELD_HEX___end >>>//

    // <<< INIT___start >>>//
    private void updateInterface() {
        updateValueSliders();
        updateValueTextFields();
        updatePaneColor();
        System.out.println(color);
    }

    private void updateValueTextFields() {
        textFieldRed.setText(String.valueOf(color.getRed()));
        textFieldGreen.setText(String.valueOf(color.getGreen()));
        textFieldBlue.setText(String.valueOf(color.getBlue()));
        textFieldHex.setText(String.valueOf(color.getHexValue()));
    }

    private void updateValueSliders() {
        sliderRed.setValue(color.getRed());
        sliderGreen.setValue(color.getGreen());
        sliderBlue.setValue(color.getBlue());
    }

    private void updatePaneColor() {
        paneColor.setStyle("-fx-background-color: " + color.getHexValue());
    }

    private void initParamSliders(double miniSlider, double maxiSlider, boolean tickLabels, boolean tickMarks, int blockIncrement) {
        sliderRed.setMin(miniSlider);
        sliderRed.setMax(maxiSlider);
        sliderGreen.setMin(miniSlider);
        sliderGreen.setMax(maxiSlider);
        sliderBlue.setMin(miniSlider);
        sliderBlue.setMax(maxiSlider);
        sliderRed.setShowTickLabels(tickLabels);
        sliderRed.setShowTickMarks(tickMarks);
        sliderRed.setBlockIncrement(blockIncrement);
        sliderGreen.setShowTickLabels(tickLabels);
        sliderGreen.setShowTickMarks(tickMarks);
        sliderGreen.setBlockIncrement(blockIncrement);
        sliderBlue.setShowTickLabels(tickLabels);
        sliderBlue.setShowTickMarks(tickMarks);
        sliderBlue.setBlockIncrement(blockIncrement);
    }
    // <<< INIT___end >>>//
}