package mshujo2s.hbrs.se1.ws24.exercises.uebung2;
import java.util.*;

/**
 * @author mshujo2s
 */

public class TestDump {

    public void start() throws ContainerException {


        Member r1 = new MemberKonkret(92);
        Member r2 = new MemberKonkret(32);
        Member r3 = new MemberKonkret(112);
        Member r4 = new MemberKonkret(87);

        Container store = new Container();


        vergleich ( "Test 1 - Pruefe auf leeren Store" , 0 , store.size()  );

        store.addMember( r1 );
        store.addMember( r2 );
        store.addMember( r3 );
        store.addMember( r4 );

        store.dump();

    }

    private void vergleich( String titel, int soll , int ist ){
        System.out.print( titel + ": \n");
        if (soll == ist ) {
            System.out.print("Soll (" + soll + ") = IST (" + soll + ") --> Probe Erfolgreich");
        } else {
            System.out.print("Soll (" + soll + ") != IST (" + soll + ") --> Probe nicht erfolgreich");
        }
        System.out.println("\n");
    }
    public static void main (String[] args)  {
        TestDump test = new TestDump();
        try {
            test.start();
        } catch (ContainerException e) {
            e.printStackTrace();
        }

    }

}
