package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import local_search.candidate_type.CandidateType;
import local_search.candidate_type.SearchCandidate;
import factory_method.FactoryCandidate;

public class FactoryCandidateTest {

    private FactoryCandidate factoryCandidate;

    @BeforeEach
    public void setUp() {
        factoryCandidate = new FactoryCandidate();
    }

    @Test
    public void testCreateGreaterCandidate() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        SearchCandidate candidate = factoryCandidate.createSearchCandidate(CandidateType.Greater);
        assertNotNull(candidate, "GreaterCandidate should not be null");
        assertEquals("GreaterCandidate", candidate.getClass().getSimpleName());
    }

    @Test
    public void testCreateSmallerCandidate() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        SearchCandidate candidate = factoryCandidate.createSearchCandidate(CandidateType.Smaller);
        assertNotNull(candidate, "SmallerCandidate should not be null");
        assertEquals("SmallerCandidate", candidate.getClass().getSimpleName());
    }

    @Test
    public void testCreateRandomCandidate() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        SearchCandidate candidate = factoryCandidate.createSearchCandidate(CandidateType.Random);
        assertNotNull(candidate, "RandomCandidate should not be null");
        assertEquals("RandomCandidate", candidate.getClass().getSimpleName());
    }

    @Test
    public void testMultipleCandidateTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (CandidateType type : CandidateType.values()) {
            SearchCandidate candidate = factoryCandidate.createSearchCandidate(type);
            assertNotNull(candidate, "Candidate for type " + type + " should not be null");
            assertTrue(candidate instanceof SearchCandidate);
        }
    }
}
