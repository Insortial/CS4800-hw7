package org.Flyweight;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextEditor {
    private ArrayList<Character> characterList;
    private StringBuilder document;

    public TextEditor() {
        this.document = new StringBuilder();
        this.characterList = new ArrayList<>();
    }
    public void addCharacter(Character character) {
        this.characterList.add(character);
        this.document.append(character.encode());
    }

    public void saveDocument(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(document.toString());
        }
    }

    public void loadDocument(String filename) throws IOException {
        this.characterList = new ArrayList<>();

        StringBuilder decodedDocument = new StringBuilder();
        CharacterFactory charFactory = CharacterFactory.getInstance();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                decodedDocument.append(line);
            }
        }

        int i = 0;
        while (i < decodedDocument.length()) {
            StringBuilder encodedCharacter = new StringBuilder();
            if (decodedDocument.charAt(i) == ':') {
                encodedCharacter.append(decodedDocument.charAt(i - 1));
                encodedCharacter.append(decodedDocument.charAt(i));
                i++;
                while (i < decodedDocument.length() && decodedDocument.charAt(i) != ':') {
                    encodedCharacter.append(decodedDocument.charAt(i));
                    i++;
                }
                i -= 1;
                encodedCharacter.setLength(encodedCharacter.length() - 1);
                characterList.add(characterDecode(encodedCharacter.toString()));
            }
            i++;
        }
        document = decodedDocument;
    }

    public Character characterDecode(String encoded) {
        CharacterFactory charFactory = CharacterFactory.getInstance();
        String[] parts = encoded.split(":");
        Character character = new Character(parts[0].charAt(0));
        String[] properties = parts[1].split(",");
        return charFactory.getCharacter(character, properties[0], Integer.parseInt(properties[2]), properties[1]);
    }

    public void displayDocument() {
        for(Character c : this.characterList) {
            System.out.print(c.getCharacter());
        }
        System.out.println();
    }
}
