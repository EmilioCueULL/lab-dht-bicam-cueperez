package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.Crossover;
import evolutionary_algorithms.complement.CrossoverType;
import factory_method.FactoryCrossover;

public class FactoryCrossoverTest {

    private FactoryCrossover factoryCrossover;

    @BeforeEach
    public void setUp() {
        factoryCrossover = new FactoryCrossover();
    }

    @Test
    public void testCreateOnePointCrossover() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Crossover crossover = factoryCrossover.createCrossover(CrossoverType.OnePointCrossover);
        assertNotNull(crossover, "OnePointCrossover should not be null");
        assertEquals("OnePointCrossover", crossover.getClass().getSimpleName());
    }

    @Test
    public void testCreateUniformCrossover() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Crossover crossover = factoryCrossover.createCrossover(CrossoverType.UniformCrossover);
        assertNotNull(crossover, "UniformCrossover should not be null");
        assertEquals("UniformCrossover", crossover.getClass().getSimpleName());
    }

    @Test
    public void testMultipleCrossoverTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (CrossoverType type : CrossoverType.values()) {
            Crossover crossover = factoryCrossover.createCrossover(type);
            assertNotNull(crossover, "Crossover for type " + type + " should not be null");
            assertTrue(crossover instanceof Crossover);
        }
    }
}
