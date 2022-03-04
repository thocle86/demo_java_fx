package fr.cefim.demofx.models;

/**
 * This class allows to create a color with three parameters, red, green and blue or with only parameter, a hexadecimal string
 * @author Thomas CLEMENT
 * @version 2022-03-02
 */

public class Color {

    private int red;
    private int green;
    private int blue;
    private String hexadecimal;
    private static final int MIN_RGB = 0;
    private static final int MAX_RGB = 255;
    private static final String REGEX_HEXA = "^#([A-F0-9]{6})$";

    /**
     * Allows to create a color with rgb parameters and update a hexadecimal color
     * @param red int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @param green int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @param blue int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #updateRed(int)
     * @see #updateGreen(int)
     * @see #updateBlue(int)
     * @see #setHexValue(String)
     */
    public Color(int red, int green, int blue) {
        updateRed(red);
        updateGreen(green);
        updateBlue(blue);
        setHexValue(updateHexValueToRgb(red, green, blue));
    }

    /**
     * Allows to return a minimum bound color
     * @return int
     */
    public int getMinRgb() {
        return MIN_RGB;
    }

    /**
     * Allows to return a maximum bound color
     * @return int
     */
    public int getMaxRgb() {
        return MAX_RGB;
    }

    /**
     * Allows to verify a rgb color is between the bounds
     * @param color int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @throws IllegalArgumentException if a value is not within the bounds
     */
    private void verifyColor(int color) {
        if (color < MIN_RGB || color > MAX_RGB) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Allows to update a red color
     * @param red int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #verifyColor(int)
     */
    private void updateRed(int red) {
        verifyColor(red);
        this.red = red;
    }

    /**
     * Allows to update a green color
     * @param green int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #verifyColor(int)
     */
    private void updateGreen(int green) {
        verifyColor(green);
        this.green = green;
    }

    /**
     * Allows to update a blue color
     * @param blue int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #verifyColor(int)
     */
    private void updateBlue(int blue) {
        verifyColor(blue);
        this.blue = blue;
    }

    /**
     * Allows to create a hexadecimal color and update rgb color
     * @param hexadecimal string in format: sharp at the beginning and 6 six letters or numbers between [A-F] and [0-9] -> {@value #REGEX_HEXA}
     * @see #setRed(int)
     * @see #setGreen(int)
     * @see #setBlue(int)
     * @throws IllegalArgumentException if the value does not match the format
     */
    public Color(String hexadecimal) {
        if (
                hexadecimal == null ||
                !hexadecimal.matches(REGEX_HEXA)

        ) {
            throw new IllegalArgumentException();
        }
        this.hexadecimal = hexadecimal;
        setRed(java.awt.Color.decode(hexadecimal).getRed());
        setGreen(java.awt.Color.decode(hexadecimal).getGreen());
        setBlue(java.awt.Color.decode(hexadecimal).getBlue());
    }

    /**
     * Allows to return the red color
     * @return int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     */
    public int getRed() {
        return red;
    }

    /**
     * Allows to return the green color
     * @return int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     */
    public int getGreen() {
        return green;
    }

    /**
     * Allows to return the blue color
     * @return int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Allows to transform a rgb color to hexadecimal color
     * @param red int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @param green int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @param blue int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @return string hexadecimal color
     * @throws IllegalArgumentException if a value is not within the bounds
     */
    private String updateHexValueToRgb(int red, int green, int blue) {
        verifyColor(red);
        verifyColor(green);
        verifyColor(blue);
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    /**
     * Allows to update the red color and update the hexadecimal value
     * @param red int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #updateRed(int)
     * @see #setHexValue(String)
     */
    public void setRed(int red) {
        updateRed(red);
        setHexValue(updateHexValueToRgb(red, getGreen(), getBlue()));
    }

    /**
     * Allows to update the green color and update the hexadecimal value
     * @param green int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #updateGreen(int)
     * @see #setHexValue(String)
     */
    public void setGreen(int green) {
        updateGreen(green);
        setHexValue(updateHexValueToRgb(getRed(), green, getBlue()));
    }

    /**
     * Allows to update the blue color and update the hexadecimal value
     * @param blue int between {@value #MIN_RGB} and {@value #MAX_RGB} inclusive
     * @see #updateBlue(int)
     * @see #setHexValue(String)
     */
    public void setBlue(int blue) {
        this.updateBlue(blue);
        this.setHexValue(updateHexValueToRgb(getRed(), getGreen(), blue));
    }

    /**
     * Allows to return a hexadecimal color
     * @return string in format: sharp at the beginning and 6 six letters or numbers between [A-F] and [0-9] -> {@value #REGEX_HEXA}
     */
    public String getHexValue() {
        return hexadecimal;
    }

    /**
     * Allows to update a hexadecimal color and update a rgb color
     * @param hexadecimal string in format: sharp at the beginning and 6 six letters or numbers between [A-F] and [0-9] -> {@value #REGEX_HEXA}
     * @see #updateRed(int)
     * @see #updateGreen(int)
     * @see #updateBlue(int)
     * @throws IllegalArgumentException if the value does not match the format
     */
    public void setHexValue(String hexadecimal) {
        if (
                hexadecimal == null ||
                !hexadecimal.matches(REGEX_HEXA)
        ) {
            throw new IllegalArgumentException();
        }
        this.hexadecimal = hexadecimal;
        updateRed(java.awt.Color.decode(hexadecimal).getRed());
        updateGreen(java.awt.Color.decode(hexadecimal).getGreen());
        updateBlue(java.awt.Color.decode(hexadecimal).getBlue());
    }

    /**
     * Allows to return a string with a hexadecimal color and rgb color
     * @return string
     */
    @Override
    public String toString() {
        return "[" + "value=" + hexadecimal + ", r=" + red + ", g=" + green + ", b=" + blue + "]";
    }
}
