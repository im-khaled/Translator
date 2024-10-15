package mshujo2s.hbrs.se1.ws24.exercises.uebung2;
import java.util.*;

/**
 * @author mshujo2s
 */


public class Test {

    public void start() throws ContainerException {

        Member r1 = new MemberKonkret(92);
        Member r2 = new MemberKonkret(32);
        Member r3 = new MemberKonkret(112);
        Member r4 = new MemberKonkret(87);
        Member r5 = new MemberKonkret(934);

        Container store = new Container();


        vergleich ( "Probe 1 - Pruefe auf leeren Store" , 0 , store.size()  );

        store.addMember( r1 );
        store.addMember( r2 );
        store.addMember( r3 );
        store.addMember( r4 );


        vergleich ( "Probe 2 - Prüfe, ob vier Objekte eingefuegt ist" , 4 , store.size()  );

        store.addMember(r5);

        vergleich ( "Probe 3 - Prüfe, ob fuenftes Objekt eingefuegt ist" , 5 , store.size()  );

        String result = store.deleteMember(32);

        vergleich ( "Probe 4 - Pruefe, ob Objekt geloescht wist" ,  4 , store.size()  );

        result = store.deleteMember(87);
        System.out.println( result );

        vergleich ( "Probe 5 - Pruefe, ob ein Objekt nicht geloescht ist" , 4 , store.size()  );

        try {
            store.addMember( r2 );
        } catch (ContainerException e) {

            e.printStackTrace();

        } finally {

            vergleich ( "probe 6 - Pruefen, ob ein Objekt nicht doppelt eingefuegt wurde" , 4 , store.size()  );
        }

        store.dump();

    }

    private void vergleich( String titel, int soll , int ist ){
        System.out.print( titel + ": \n");
        if (soll == ist ) {
            System.out.print("Soll (" + soll + ") = IST (" + soll + ") --> Probe Erfolgreich");
        } else {
            System.out.print("Soll (" + soll + ") != IST (" + soll + ") --> Probe NICHT Erfolgreich");
        }
        System.out.println("\n");
    }

    public static void main (String[] args)  {
        Test test = new Test();
        try {
            test.start();
        } catch (ContainerException e) {
            e.printStackTrace();
        }

    }

}
