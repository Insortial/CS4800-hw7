package org.Flyweight;

public class Character {
    char character;
    Font font;
    FontSize fontSize;
    Color color;

    public Character(char character) {
        this.character = character;
        this.font = null;
        this.fontSize = null;
        this.color = null;
    }

    public char getCharacter() {
        return character;
    }

    public String getColor() {
        return color.getColor();
    }

    public String encode() {
        return character + ":" + font.getFont() + "," + color.getColor() + "," + fontSize.getFontSize();
    }

    public String getFont() {
        return font.getFont();
    }

    public Integer getFontSize() {
        return fontSize.getFontSize();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }
}
