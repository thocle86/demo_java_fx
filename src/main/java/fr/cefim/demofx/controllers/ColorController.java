package fr.cefim.demofx.controllers;

import fr.cefim.demofx.models.Color;
import fr.cefim.demofx.models.Palette;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorController implements Initializable {

    private Color color;
    private Palette palette;
    private enum COLOR {RED, GREEN, BLUE};

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
    private Pane paneColorPalette;
    @FXML
    private Pane paneColorPaletteWithoutRed;
    @FXML
    private Pane paneColorPaletteWithMaxRed;
    @FXML
    private Pane paneColorPaletteWithoutGreen;
    @FXML
    private Pane paneColorPaletteWithMaxGreen;
    @FXML
    private Pane paneColorPaletteWithoutBlue;
    @FXML
    private Pane paneColorPaletteWithMaxBlue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        color = new Color(127,127,127);
        palette = new Palette(color);
        initParamSliders(color.getMinRgb(), color.getMaxRgb(), true, false, 1);
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

    // <<< INIT & UPDATE___start >>>//
    private void updateInterface() {
        updateValueSliders();
        updateValueTextFields();
        updateColorPalettes();
        updatePaneColorPalettes();
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

    private void updateColorPalettes() {
        palette.setColorWithoutRed(color);
        palette.setColorWithMaxRed(color);
        palette.setColorWithoutGreen(color);
        palette.setColorWithMaxGreen(color);
        palette.setColorWithoutBlue(color);
        palette.setColorWithMaxBlue(color);
    }

    private void updatePaneColorPalettes() {
        paneColorPalette.setStyle("-fx-background-color: " + color.getHexValue());
        paneColorPaletteWithoutRed.setStyle("-fx-background-color: " + palette.getColorWithoutRed().getHexValue());
        paneColorPaletteWithMaxRed.setStyle("-fx-background-color: " + palette.getColorWithMaxRed().getHexValue());
        paneColorPaletteWithoutGreen.setStyle("-fx-background-color: " + palette.getColorWithoutGreen().getHexValue());
        paneColorPaletteWithMaxGreen.setStyle("-fx-background-color: " + palette.getColorWithMaxGreen().getHexValue());
        paneColorPaletteWithoutBlue.setStyle("-fx-background-color: " + palette.getColorWithoutBlue().getHexValue());
        paneColorPaletteWithMaxBlue.setStyle("-fx-background-color: " + palette.getColorWithMaxBlue().getHexValue());
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
    // <<< INIT & UPDATE___end >>>//
}