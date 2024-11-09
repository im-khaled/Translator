package mshujo2s.hbrs.se1.ws24.exercises.uebung4;

/**
 * @author mshujo2s
 */

public class ContainerException extends Exception {

    private String modus;
    private Integer id;

    public ContainerException( String z ) {
        super ( z );
    }

    public void printStackTrace() {
        System.out.println(" ID " + this.id + " ist bereits vorhanden!");
    }

    public void addID(Integer id) {
        this.id = id;
    }

}




