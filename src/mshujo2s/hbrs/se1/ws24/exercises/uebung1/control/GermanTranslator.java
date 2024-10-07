package mshujo2s.hbrs.se1.ws24.exercises.uebung1.control;

/**
 * @author mshujo2s
 */


public class GermanTranslator implements Translator {

    private final String[] zahlen = {
            "EINS", "ZWEI", "DREI", "VIER", "FUENF", "SECHS",
            "SIEBEN", "ACHT", "NEUN", "ZEHN"
    };

    private String date = "Okt/2024";

    @Override
    public String translateNumber(int number) {
        try {

            return zahlen[number - 1];
        } catch (ArrayIndexOutOfBoundsException e) {

            return "Uebersetzung der Zahl " + number + " nicht moeglich (V " + Translator.version + ")";
        }
    }

    public void printInfo() {
        System.out.println("GermanTranslator v" + Translator.version + ", erzeugt am " + this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }
}
