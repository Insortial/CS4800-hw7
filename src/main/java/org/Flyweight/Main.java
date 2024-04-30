package org.Flyweight;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharacterFactory charFactory = CharacterFactory.getInstance();
        TextEditor textEditor = new TextEditor();
        Character test = charFactory.getCharacter(new Character('H'), "Times New Roman", 12, "Black");
        textEditor.addCharacter(charFactory.getCharacter(new Character('H'), "Times New Roman", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('e'), "Times New Roman", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('l'), "Times New Roman", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('l'), "Times New Roman", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('o'), "Arial", 16, "Blue"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('W'), "Arial", 16, "Blue"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('o'), "Arial", 16, "Blue"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('r'), "Arial", 16, "Blue"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('l'), "Times New Roman", 18, "Red"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('d'), "Times New Roman", 18, "Red"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('C'), "Times New Roman", 18, "Red"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('S'), "Times New Roman", 18, "Red"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('5'), "Roboto", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('8'), "Roboto", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('0'), "Roboto", 12, "Black"));
        textEditor.addCharacter(charFactory.getCharacter(new Character('0'), "Roboto", 12, "Black"));

        textEditor.saveDocument("testFile");
        textEditor.loadDocument("testFile");
        textEditor.displayDocument();
    }
}