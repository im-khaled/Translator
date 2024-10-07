package mshujo2s.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mshujo2s.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;

/**
 * @author mshujo2s
 */

class GermanTranslatorTest {

    GermanTranslator translator = new GermanTranslator();

    @Test
    void testValidNum() {
        assertEquals("EINS", translator.translateNumber(1));
        assertEquals("ZWEI", translator.translateNumber(2));
        assertEquals("DREI", translator.translateNumber(3));
        assertEquals("VIER", translator.translateNumber(4));
        assertEquals("FUENF", translator.translateNumber(5));
        assertEquals("SECHS", translator.translateNumber(6));
        assertEquals("SIEBEN", translator.translateNumber(7));
        assertEquals("ACHT", translator.translateNumber(8));
        assertEquals("NEUN", translator.translateNumber(9));
        assertEquals("ZEHN", translator.translateNumber(10));
    }

    @Test
    void testInvalidNum() {
        assertEquals("Uebersetzung der Zahl 15 nicht moeglich (V 1.0)", translator.translateNumber(15));
        assertEquals("Uebersetzung der Zahl -4 nicht moeglich (V 1.0)", translator.translateNumber(-4));
        assertEquals("Uebersetzung der Zahl 88 nicht moeglich (V 1.0)", translator.translateNumber(88));
    }
}