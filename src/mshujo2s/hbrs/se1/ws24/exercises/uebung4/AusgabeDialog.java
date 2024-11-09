package mshujo2s.hbrs.se1.ws24.exercises.uebung4;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author mshujo2s
 */

public class AusgabeDialog {

    List<UserStory> liste = null;

    public AusgabeDialog(List<UserStory> currentList) {
        this.liste = currentList;
    }


    public void dump(){
        if ( liste.isEmpty() ) {
            System.out.println(" Keine User Story ");
            return;
        }
    }

    private void dumpIterator() {

        Collections.sort(   this.liste );

        Iterator<UserStory> i = liste.iterator();
        while (  i.hasNext() ) {
            UserStory a = i.next();
            System.out.println("Titel: " + a.getTitel());
            System.out.println("ID: " + a.getId() );
            System.out.println("Aufwand: " + a.getAufwand());
            System.out.println("Mehrwert: " + a.getMehrwert());
            System.out.println("Risiko: " + a.getRisk());
            System.out.println("Prio: " + a.getPrio());
            System.out.println("Strafe: " + a.getStrafe());

        }
        System.out.println("Anzahl User Stories: " + liste.size() );
    }


    private void dumpForEach() {
        for ( UserStory us : liste ) {
            System.out.println( us.toString() );
        }
    }

    private void dumpFunctionInterface() {
        liste.forEach( new Consumer<UserStory>() {
            public void accept(UserStory us) {
                System.out.println( us.toString() );
            }
        }  );
    }


    private void dumpLambdaInFunctionalInterface() {
        liste.forEach( us  -> System.out.println( us.toString() ) );
    }

    private void dumpLambdaInStream() {
        liste.stream().forEach( us  -> System.out.println( us.toString() ) );
    }


    private void dumpLambdaWithFilter() {
        liste.stream().filter( us -> us.getRisk() > 4)
                .forEach( us  -> System.out.println( us.toString() ) );
    }
    private void dumpLambdaWithFilterAndMap() {
        liste.stream()
                .filter( element -> element.getAufwand() > 4 )
                .map( element -> element.getTitel() )
                .forEach( element -> System.out.println( element ) );
    }



    private void dumpLambdaWithFilterAndMapParallel() {
        liste.parallelStream()
                .filter( element -> element.getAufwand() > 4 )
                .map( element -> element.getTitel() )
                .forEach( element -> System.out.println( element ) );  		}


    private void dumpLambdaWithFilterAndMapAndSort() {
        liste.stream()
                .filter( element -> element.getAufwand() > 4 )
                .sorted( (i1, i2) ->  Double.compare( i1.getPrio() , i2.getPrio()  ) )
                .forEach( element -> System.out.println( element ) );
    }


    private List<UserStory> dumpLambdaWithFilterAndMapAndCollect() {
        return liste.stream()
                .filter( element -> element.getAufwand() > 4 )
                .sorted( (i1, i2) ->  Double.compare( i1.getPrio() , i2.getPrio()  ) )
                .collect( Collectors.toList()  );
    }



}







