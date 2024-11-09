package mshujo2s.hbrs.se1.ws24.exercises.uebung4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mshujo2s
 */


public class Container {

    private static final String LOCATION = null;


    private List<UserStory> liste = null;


    private static Container instance = new Container();



    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }


    private Container(){
        liste = new ArrayList<UserStory>();
    }


    public void addUserStory ( UserStory s ) throws ContainerException {
        if ( contains(s) == true ) {
            ContainerException ex = new ContainerException("ID vorhanden");
            throw ex;
        }
        liste.add(s);

    }


    private boolean contains(UserStory a) {
        int ID = a.getId();
        for ( UserStory rec : liste) {
            if ( rec.getId() == ID ) {
                return true;
            }
        }
        return false;
    }

    public int getAnzahl(){
        return liste.size();
    }


    public List<UserStory> getCurrentList() {
        return this.liste;
    }




    private UserStory getUserStory(int id) {
        for ( UserStory rec : liste) {
            if (id == rec.getId() ){
                return rec;
            }
        }
        return null;
    }


    public void store() {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( Container.LOCATION );
            oos = new ObjectOutputStream(fos);

            try {
                oos.writeObject( liste );
                System.out.println(this.getAnzahl() + " User Storie gespeichert");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) try { oos.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }

    }


    public void load() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( Container.LOCATION );
            ois = new ObjectInputStream(fis);


            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                this.liste = (List) obj;

            }
            System.out.println( this.getAnzahl() + " User Stories  reingeladen!");
        }
        catch (IOException e) {
            System.out.println("FEHLER");
        }
        catch (ClassNotFoundException e) {
            System.out.println("FEHLER");
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
    }


}






