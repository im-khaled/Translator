package mshujo2s.hbrs.se1.ws24.exercises.uebung2;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


/**
 * @author mshujo2s
 */

public class Container {

    public Container(){
    }


    private List<Member> liste = new ArrayList<Member>();



    public void addMember ( Member r ) throws ContainerException {
        if ( contains( r ) == true ) {
            ContainerException ex = new ContainerException();
            ex.addID ( r.getID() );
            throw ex;
        }
        liste.add( r );

    }


    private boolean contains(Member r) {
        Integer ID = r.getID();
        for (int i=0;i<liste.size();i++){
            if(liste.get(i).getID().intValue()==ID.intValue()){

                return true;
            }
        }
        return false;

    }


    public String deleteMember( Integer id ) {
        Member rec = getMember( id );
        if (rec == null) return "Kunde nicht enthalten - ERROR"; else {
            liste.remove(rec);
            return "Kunde mit der ID " + id + " wurde gelöscht";
        }
    }


    public int size(){
        return liste.size();
    }


    public void dump(){
        System.out.println("Ausgabe aller Kunden: ");
        for (int i=0; i<liste.size();i++){
            System.out.println("ID:"+liste.get(i).getID());
        }
    }


    public void accept(Member p) {
        System.out.println( p.toString()  );
    }


    private Member getMember(Integer id) {
        for ( Member rec : liste) {
            if (id == rec.getID().intValue() ){
                return rec;
            }
        }
        return null;
    }
}