package mshujo2s.hbrs.se1.ws24.exercises.uebung1.control;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author mshujo2s
 */

public class GTFactory {

    public static Translator createTranslator() {
        GermanTranslator translator = new GermanTranslator();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String currentDate = LocalDate.now().format(formatter);
        translator.setDate(currentDate);

        return translator;
    }
}
