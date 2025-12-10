package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import local_search.acceptation_type.AcceptableCandidate;
import local_search.acceptation_type.AcceptType;
import factory_method.FactoryAcceptCandidate;

public class FactoryAcceptCandidateTest {

    private FactoryAcceptCandidate factoryAcceptCandidate;

    @BeforeEach
    public void setUp() {
        factoryAcceptCandidate = new FactoryAcceptCandidate();
    }

    @Test
    public void testCreateAcceptBest() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        AcceptableCandidate accept = factoryAcceptCandidate.createAcceptCandidate(AcceptType.AcceptBest);
        assertNotNull(accept, "AcceptBest should not be null");
        assertEquals("AcceptBest", accept.getClass().getSimpleName());
    }

    @Test
    public void testCreateAcceptAnyone() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        AcceptableCandidate accept = factoryAcceptCandidate.createAcceptCandidate(AcceptType.AcceptAnyone);
        assertNotNull(accept, "AcceptAnyone should not be null");
        assertEquals("AcceptAnyone", accept.getClass().getSimpleName());
    }

    @Test
    public void testCreateAcceptNotBad() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        AcceptableCandidate accept = factoryAcceptCandidate.createAcceptCandidate(AcceptType.AcceptNotBad);
        assertNotNull(accept, "AcceptNotBad should not be null");
        assertEquals("AcceptNotBad", accept.getClass().getSimpleName());
    }

    @Test
    public void testMultipleAcceptTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (AcceptType type : AcceptType.values()) {
            AcceptableCandidate accept = factoryAcceptCandidate.createAcceptCandidate(type);
            assertNotNull(accept, "Accept for type " + type + " should not be null");
            assertTrue(accept instanceof AcceptableCandidate);
        }
    }
}
