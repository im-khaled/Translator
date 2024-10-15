package mshujo2s.hbrs.se1.ws24.exercises.uebung3;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.List;

/**
 * @author mshujo2s
 */





public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {


    private String LOCATION = "objects.ser";

    private ObjectOutputStream oos = null;
    private FileOutputStream fos = null;

    private FileInputStream fis = null;
    private ObjectInputStream ois = null;


    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    @Override

    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream( LOCATION );
        } catch (FileNotFoundException e) {
            throw new PersistenceException( PersistenceException.ExceptionType.ConnectionNotAvailable, "Error in opening the connection, File could not be found");
        }
        try {
            oos = new ObjectOutputStream( fos );
        } catch (IOException e) {
            throw new PersistenceException( PersistenceException.ExceptionType.ConnectionNotAvailable, "Error in opening the connection, problems with the stream");
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {

        try {

            if (oos != null) oos.close();
            if (fos != null) fos.close();


            if (ois != null) ois.close();
            if (fis != null) fis.close();
        } catch( IOException e ) {

            throw new PersistenceException(PersistenceException.ExceptionType.ClosingFailure , "error while closing connections");
        }
    }

    @Override

    public void save(List<Member> list) throws PersistenceException {

        this.openConnection();


        try {
            System.out.println(  list.size() + " User Stories wurden erfolgreich gespeichert!");
            oos.writeObject( list );

        }
        catch (IOException e) {

            e.printStackTrace();
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Speichern der Datei!");
        }
        finally {
            this.closeConnection();
        }
    }

    @Override

    public List<Member> load() throws PersistenceException {


        List<Member> list = null;

        try {

            fis = new FileInputStream( LOCATION );
            ois = new ObjectInputStream( fis );


            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List) obj;
            }
            System.out.println("LOG: Es wurden " + list.size() + " User Stories erfolgreich reingeladen!");
            return list;
        }
        catch (IOException e) {

            e.printStackTrace();
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei!");
        }
        catch (ClassNotFoundException e) {

            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei! Class not found!");
        }
        finally {
            this.closeConnection();
        }

    }
}

