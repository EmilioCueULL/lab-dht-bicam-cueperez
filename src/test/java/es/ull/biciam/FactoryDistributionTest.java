package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.Distribution;
import evolutionary_algorithms.complement.DistributionType;
import factory_method.FactoryDistribution;

public class FactoryDistributionTest {

    private FactoryDistribution factoryDistribution;

    @BeforeEach
    public void setUp() {
        factoryDistribution = new FactoryDistribution();
    }

    @Test
    public void testCreateUnivariateDistribution() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Distribution distribution = factoryDistribution.createDistribution(DistributionType.Univariate);
        assertNotNull(distribution, "UnivariateDistribution should not be null");
        assertEquals("Univariate", distribution.getClass().getSimpleName());
    }

    @Test
    public void testMultipleDistributionTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (DistributionType type : DistributionType.values()) {
            Distribution distribution = factoryDistribution.createDistribution(type);
            assertNotNull(distribution, "Distribution for type " + type + " should not be null");
            assertTrue(distribution instanceof Distribution);
        }
    }
}
