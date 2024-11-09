package mshujo2s.hbrs.se1.ws24.exercises.uebung4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author mshujo2s
 */

public class PersistenceManager {



    public static void store( List<UserStory> list ) throws ContainerException {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( PersistenceManager.LOCATION );
            oos = new ObjectOutputStream(fos);
            oos.writeObject( list );
            System.out.println(  list.size() + " User Stories wurden erfolgreich gespeichert!");
        }
        catch (IOException e) {
            // Koennte man ausgeben für interne Debugs: e.printStackTrace();
            // Chain of Responsibility: Hochtragen der Exception in Richtung Ausgabe (UI)
            // Uebergabe in ein lesbares Format fuer den Benutzer
            throw new ContainerException("Fehler beim Laden der Datei!");
        }
        finally {
            if (oos != null) try { oos.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }

    }


    public static List<UserStory> load() {
        List<UserStory> list = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( PersistenceManager.LOCATION );
            ois = new ObjectInputStream(fis);


            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List) obj;

            }
            System.out.println("Es wurden " + list.size() + " User Stories erfolgreich reingeladen!");
            return list;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("FEHLER: Liste konnte nicht extrahiert werden (ClassNotFound)!");
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
        return list;
    }




}
