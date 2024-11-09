package mshujo2s.hbrs.se1.ws24.exercises.uebung4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author mshujo2s
 */

public class EingabeDialog {

    public void startEingabe() {

        String strInput = null;


        BufferedReader input = new BufferedReader( new InputStreamReader(System.in ) );


        while ( true ) {

            try {
                System.out.print("");
                strInput = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] strings = strInput.split(" ");

            if ( strings[0].equals("help") ) {
                System.out.println(" Befehle : help, dump....");
            }

            if ( strings[0].equals("dump") ) {
                this.startAusgabe();
            }

            if ( strings[0].equals("load") ) {
                Container.getInstance().load();
            }

            if ( strings[0].equals("store") ) {
                Container.getInstance().store();
            }

            if (  strings[0].equals("enter")  ) {

                MyConsole console = new MyConsole();

                System.out.println(" UserStory eingeben:");

                int id = console.readLineInt(" UserStory ID: ");

                String titel = console.readLine("UserStory Titel: ");

                int aufwand = console.readLineInt("UserStory Aufwand: ");

                int risk = console.readLineInt("UserStory Risiko: ");

                int mehrwert = console.readLineInt("UserStory Mehrwert: ");

                int strafe = console.readLineInt("UserStory Strafe: ");

                int prio =  ( (mehrwert + strafe ) / ( aufwand + risk ) );
                System.out.println(" ID UserStory: " + id + " Prio: " + prio);

                UserStory us = new UserStory( titel, id, mehrwert, strafe, aufwand, risk , prio );

                try {
                    Container.getInstance().addUserStory( us );
                } catch (ContainerException e) {
                    System.out.println("Fehler  beim abspeichern");
                }

            }
        }
    }

    private void startAusgabe() {
        AusgabeDialog dialog = new AusgabeDialog( Container.getInstance().getCurrentList() );
        dialog.dump();


    }



}





