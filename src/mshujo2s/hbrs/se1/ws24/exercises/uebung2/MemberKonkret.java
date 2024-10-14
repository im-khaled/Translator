package mshujo2s.hbrs.se1.ws24.exercises.uebung2;

/**
 * @author mshujo2s
 */

public class MemberKonkret implements Member {

    private Integer id = null;

    public MemberKonkret( Integer id ){
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public void setID ( Integer id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberKonkret [id=" + id + "]";
    }
}
