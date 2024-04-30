import org.Flyweight.*;
import org.Flyweight.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class FlyweightTest {
    @Test
    public void editCharacterTest() {
        CharacterFactory charFactory = CharacterFactory.getInstance();
        TextEditor textEditor = new TextEditor();

        Character testCharacter = new Character('B');
        charFactory.getCharacter(testCharacter, "Arial", 12, "Black");
        Assertions.assertEquals(testCharacter.getFont(), "Arial");
        charFactory.editFont(testCharacter, "Helvetica");
        Assertions.assertEquals(testCharacter.getFont(), "Helvetica");
    }

    @Test
    public void getCharacterTest() {
        CharacterFactory charFactory = CharacterFactory.getInstance();
        TextEditor textEditor = new TextEditor();

        Character testCharacter = new Character('B');
        charFactory.getCharacter(testCharacter, "Arial", 12, "Black");
        Assertions.assertEquals(testCharacter.getFont(), "Arial");
        Assertions.assertEquals(testCharacter.getFontSize(), 12);
        Assertions.assertEquals(testCharacter.getColor(), "Black");
    }
}
