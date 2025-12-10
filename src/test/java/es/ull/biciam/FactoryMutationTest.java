package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.Mutation;
import evolutionary_algorithms.complement.MutationType;
import factory_method.FactoryMutation;

public class FactoryMutationTest {

    private FactoryMutation factoryMutation;

    @BeforeEach
    public void setUp() {
        factoryMutation = new FactoryMutation();
    }

    @Test
    public void testCreateOnePointMutation() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Mutation mutation = factoryMutation.createMutation(MutationType.OnePointMutation);
        assertNotNull(mutation, "OnePointMutation should not be null");
        assertEquals("OnePointMutation", mutation.getClass().getSimpleName());
    }

    @Test
    public void testCreateTwoPointsMutation() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Mutation mutation = factoryMutation.createMutation(MutationType.TowPointsMutation);
        assertNotNull(mutation, "TowPointsMutation should not be null");
        assertEquals("TowPointsMutation", mutation.getClass().getSimpleName());
    }

    @Test
    public void testCreateUniformMutation() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Mutation mutation = factoryMutation.createMutation(MutationType.UniformMutation);
        assertNotNull(mutation, "UniformMutation should not be null");
        assertEquals("UniformMutation", mutation.getClass().getSimpleName());
    }

    @Test
    public void testMultipleMutationTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (MutationType type : MutationType.values()) {
            Mutation mutation = factoryMutation.createMutation(type);
            assertNotNull(mutation, "Mutation for type " + type + " should not be null");
            assertTrue(mutation instanceof Mutation);
        }
    }
}
