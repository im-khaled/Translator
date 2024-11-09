package mshujo2s.hbrs.se1.ws24.exercises.uebung4;

/**
 * @author mshujo2s
 */

import java.io.Serializable;

public class UserStory implements Comparable<UserStory>, Serializable {

    private String titel;
    private int id;
    private int aufwand;
    private int mehrwert;
    private int strafe;
    private int prio;
    private int risk;

    public UserStory(String titel,int id,int aufwand,int mehrwert,int strafe,
                     int prio,int risk) {
        this.titel=titel;
        this.id=id;
        this.aufwand=aufwand;
        this.mehrwert=mehrwert;
        this.strafe=strafe;
        this.prio=prio;
        this.risk=risk;
    }
    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {

    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    public double getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }

    
    public String toString() {
        return "UserStory Ttitel=" + titel + ", Aufwand=" + aufwand+ ", Id=" + id + ", Mehrwert=" + mehrwert
                + ", Risk=" + risk + ", Strafe=" + strafe + ", Prio=" + prio + "]";
    }
    @Override
    public int compareTo(UserStory o) {
        return 0;
    }


}
