package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.Sampling;
import evolutionary_algorithms.complement.SamplingType;
import factory_method.FactorySampling;

public class FactorySamplingTest {

    private FactorySampling factorySampling;

    @BeforeEach
    public void setUp() {
        factorySampling = new FactorySampling();
    }

    @Test
    public void testCreateProbabilisticSampling() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Sampling sampling = factorySampling.createSampling(SamplingType.Probabilistic);
        assertNotNull(sampling, "ProbabilisticSampling should not be null");
        assertEquals("ProbabilisticSampling", sampling.getClass().getSimpleName());
    }

    @Test
    public void testMultipleSamplingTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (SamplingType type : SamplingType.values()) {
            Sampling sampling = factorySampling.createSampling(type);
            assertNotNull(sampling, "Sampling for type " + type + " should not be null");
            assertTrue(sampling instanceof Sampling);
        }
    }
}
