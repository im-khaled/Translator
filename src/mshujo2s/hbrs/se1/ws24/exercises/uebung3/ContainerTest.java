package mshujo2s.hbrs.se1.ws24.exercises.uebung3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mshujo2s.hbrs.se1.ws24.exercises.uebung2.*;
import java.lang.reflect.Member;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mshujo2s
 */


class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = Container.getInstance();
    }

    @Test
    void testNoStrategeySet() {
        try {
            container.setPersistenceStrategie(null);
            container.store();

        } catch (PersistenceException e) {
            System.out.println("Message: " + e.getMessage() );
            assertEquals( e.getMessage() , "Strategy not initialized" );
            assertEquals(  e.getExceptionTypeType() , PersistenceException.ExceptionType.NoStrategyIsSet );
        }
    }

    @Test
    void testMongoDBNotImplemented() {
        try {
            container.setPersistenceStrategie( new PersistenceStrategyMongoDB<Member>() );
            container.store();
        } catch (PersistenceException e) {
            System.out.println("Message: " + e.getMessage() );
            assertEquals( e.getMessage() , "Not implemented!" );
            assertEquals(  e.getExceptionTypeType() , PersistenceException.ExceptionType.ImplementationNotAvailable );
        }
    }

    @Test
    void testWrongLocationOfFile() {
        try {
            PersistenceStrategyStream<Member> strat = new PersistenceStrategyStream<Member>();

            strat.setLOCATION("/Users/saschaalda/tmp");
            container.setPersistenceStrategie( strat );
            container.store();

        } catch (PersistenceException e) {
            System.out.println("Message: " + e.getMessage() );
            assertEquals( e.getMessage() , "Error in opening the connection, File could not be found" );
            assertEquals(  PersistenceException.ExceptionType.ConnectionNotAvailable  ,
                    e.getExceptionTypeType() ) ;
        }
    }

    @Test
    void testStoreAndLoad() {
        try {
            container.setPersistenceStrategie( new PersistenceStrategyStream<Member>() );
            container.addMember(new MemberKonkret(1));

            assertEquals( 1 , container.size() );
            container.store();

            container.deleteMember(1);
            assertEquals(0 , container.size() );

            container.load();
            assertEquals( 1 , container.size() );

        } catch ( ContainerException e) {
            System.out.println("Message: " + e.getMessage() );
        }
    }

}