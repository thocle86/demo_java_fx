package fr.cefim.demofx.models;

public class Palette {

    private final Color colorWithoutRed;
    private final Color colorWithMaxRed;
    private final Color colorWithoutGreen;
    private final Color colorWithMaxGreen;
    private final Color colorWithoutBlue;
    private final Color colorWithMaxBlue;

    public Palette(Color color) {
        colorWithoutRed = new Color(color.getMinRgb(), color.getGreen(), color.getBlue());
        colorWithMaxRed = new Color(color.getMaxRgb(), color.getGreen(), color.getBlue());
        colorWithoutGreen = new Color(color.getRed(), color.getMinRgb(), color.getBlue());
        colorWithMaxGreen = new Color(color.getRed(), color.getMaxRgb(), color.getBlue());
        colorWithoutBlue = new Color(color.getRed(), color.getGreen(), color.getMinRgb());
        colorWithMaxBlue = new Color(color.getRed(), color.getGreen(), color.getMaxRgb());
    }

    public Color getColorWithoutRed() {
        return colorWithoutRed;
    }

    public Color getColorWithMaxRed() {
        return colorWithMaxRed;
    }

    public Color getColorWithoutGreen() {
        return colorWithoutGreen;
    }

    public Color getColorWithMaxGreen() {
        return colorWithMaxGreen;
    }

    public Color getColorWithoutBlue() {
        return colorWithoutBlue;
    }

    public Color getColorWithMaxBlue() {
        return colorWithMaxBlue;
    }

    public void setColorWithoutRed(Color color) {
        colorWithoutRed.setRed(color.getMinRgb());
        colorWithoutRed.setGreen(color.getGreen());
        colorWithoutRed.setBlue(color.getBlue());
    }

    public void setColorWithMaxRed(Color color) {
        colorWithoutRed.setRed(color.getMaxRgb());
        colorWithoutRed.setGreen(color.getGreen());
        colorWithoutRed.setBlue(color.getBlue());
    }

    public void setColorWithoutGreen(Color color) {
        colorWithoutGreen.setRed(color.getRed());
        colorWithoutGreen.setGreen(color.getMinRgb());
        colorWithoutGreen.setBlue(color.getBlue());
    }

    public void setColorWithMaxGreen(Color color) {
        colorWithoutGreen.setRed(color.getRed());
        colorWithoutGreen.setGreen(color.getMaxRgb());
        colorWithoutGreen.setBlue(color.getBlue());
    }

    public void setColorWithoutBlue(Color color) {
        colorWithoutBlue.setRed(color.getRed());
        colorWithoutBlue.setGreen(color.getGreen());
        colorWithoutBlue.setBlue(color.getMinRgb());
    }

    public void setColorWithMaxBlue(Color color) {
        colorWithoutBlue.setRed(color.getRed());
        colorWithoutBlue.setGreen(color.getGreen());
        colorWithoutBlue.setBlue(color.getMaxRgb());
    }
}
