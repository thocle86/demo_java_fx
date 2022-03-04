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

    private Color color = new Color(0, 0, 0);
    private final double MIN_SLIDER = color.getMinRgb();
    private final double MAX_SLIDER = color.getMaxRgb();

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
        initValueSliders();
        initValueTextFields();
        
        updatePaneColor();

        updateColorRedFromTextField();
        updateColorGreenFromTextField();
        updateColorBlueFromTextField();

        updateColorRedFromSlider();
        updateColorGreenFromSlider();
        updateColorBlueFromSlider();

        updateColorFromTextFieldHex();
    }

    // <<< UPDATE COLOR FROM SLIDER___start >>>//
    private void updateColorRedFromSlider() {
        sliderRed.valueProperty().addListener((observableValue, oldNumber, newNumber) -> {
            color.setRed((int) sliderRed.getValue());
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }

    private void updateColorGreenFromSlider() {
        sliderGreen.valueProperty().addListener((observableValue, oldNumber, newNumber) -> {
            color.setGreen((int) sliderGreen.getValue());
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }

    private void updateColorBlueFromSlider() {
        sliderBlue.valueProperty().addListener((observableValue, oldNumber, newNumber) -> {
            color.setBlue((int) sliderBlue.getValue());
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }
    // <<< UPDATE COLOR FROM SLIDER___end >>>//

    // <<< UPDATE COLOR FROM TEXT_FIELD_RGB___start >>>//
    private void updateColorRedFromTextField() {
        textFieldRed.setOnAction(actionEvent -> {
            color.setRed(Integer.parseInt(textFieldRed.getText()));
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }

    private void updateColorGreenFromTextField() {
        textFieldGreen.setOnAction(actionEvent -> {
            color.setGreen(Integer.parseInt(textFieldGreen.getText()));
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }

    private void updateColorBlueFromTextField() {
        textFieldBlue.setOnAction(actionEvent -> {
            color.setBlue(Integer.parseInt(textFieldBlue.getText()));
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }
    // <<< UPDATE COLOR FROM TEXT_FIELD_RGB___end >>>//

    // <<< UPDATE COLOR FROM TEXT_FIELD_HEX___start >>>//
    private void updateColorFromTextFieldHex() {
        textFieldHex.setOnAction(actionEvent -> {
            color.setHexValue(textFieldHex.getText());
            initValueSliders();
            initValueTextFields();
            updatePaneColor();
            System.out.println(color);
        });
    }
    // <<< UPDATE COLOR FROM TEXT_FIELD_HEX___end >>>//

    // <<< INIT___start >>>//
    private void initValueTextFields() {
        textFieldRed.setText(String.valueOf(color.getRed()));
        textFieldGreen.setText(String.valueOf(color.getGreen()));
        textFieldBlue.setText(String.valueOf(color.getBlue()));
        textFieldHex.setText(String.valueOf(color.getHexValue()));
    }

    private void initValueSliders() {
        sliderRed.setValue(color.getRed());
        sliderGreen.setValue(color.getGreen());
        sliderBlue.setValue(color.getBlue());
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

    private void updatePaneColor() {
        paneColor.setStyle("-fx-background-color: " + color.getHexValue());
    }
    // <<< INIT___end >>>//
}