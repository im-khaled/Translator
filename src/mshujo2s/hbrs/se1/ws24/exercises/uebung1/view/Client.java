package mshujo2s.hbrs.se1.ws24.exercises.uebung1.view;
import mshujo2s.hbrs.se1.ws24.exercises.uebung1.control.GTFactory;
import mshujo2s.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import mshujo2s.hbrs.se1.ws24.exercises.uebung1.control.Translator;

/**
 * @author mshujo2s
 */


public class Client {

    public void display(int aNumber) {
        Translator translator = GTFactory.createTranslator();
        String result = translator.translateNumber(aNumber);
        System.out.println("Das Ergebnis: " + result);


        if (translator instanceof GermanTranslator) {
            ((GermanTranslator) translator).printInfo();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.display(6);
        client.display(14);
    }
}
