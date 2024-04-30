package org.Flyweight;

import java.util.HashMap;

public class CharacterFactory {
    private static CharacterFactory instance;
    private HashMap<String, Font> fonts = new HashMap<>();
    private HashMap<Integer, FontSize> fontSizes = new HashMap<>();
    private HashMap<String, Color> colors = new HashMap<>();

    public CharacterFactory() {

    }

    public static CharacterFactory getInstance()
    {
        if(instance == null)
            instance = new CharacterFactory();
        return instance;
    }

    public Character getCharacter(Character character, String font, int size, String color)
    {
        if(fonts.containsKey(font)) {
            character.setFont(fonts.get(font));
        } else if(font != null) {
            Font newFont = new Font(font);
            character.setFont(newFont);
            fonts.put(font, newFont);
        }

        if(fontSizes.containsKey(size)) {
            character.setFontSize(fontSizes.get(size));
        } else if(size != -1) {
            FontSize newFontSize = new FontSize(size);
            character.setFontSize(newFontSize);
            fontSizes.put(size, newFontSize);
        }

        if(colors.containsKey(color)) {
            character.setColor(colors.get(color));
        } else if(color != null) {
            Color newColor = new Color(color);
            character.setColor(newColor);
            colors.put(font, newColor);
        }

        return character;
    }

    public Character editFont(Character character, String font) {
        return getCharacter(character, font, -1, null);
    }

    public Character editFontSize(Character character, int fontSize) {
        return getCharacter(character, null, fontSize, null);
    }

    public Character editColor(Character character, String color) {
        return getCharacter(character, null, -1, color);
    }
}
