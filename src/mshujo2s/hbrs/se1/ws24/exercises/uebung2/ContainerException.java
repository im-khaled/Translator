package mshujo2s.hbrs.se1.ws24.exercises.uebung2;

/**
 * @author mshujo2s
 */

public class ContainerException extends Exception {

    private Integer id;

    @Override
    public void printStackTrace() {
        System.out.println("Das M-Objekt mit der ID " + this.id + " ist vorhanden!");
    }

    public void addID(Integer id) {
        this.id = id;
    }
}
