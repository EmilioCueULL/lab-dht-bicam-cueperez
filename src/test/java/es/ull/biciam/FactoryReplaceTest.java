package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.Replace;
import evolutionary_algorithms.complement.ReplaceType;
import factory_method.FactoryReplace;

public class FactoryReplaceTest {

    private FactoryReplace factoryReplace;

    @BeforeEach
    public void setUp() {
        factoryReplace = new FactoryReplace();
    }

    @Test
    public void testCreateGenerationalReplace() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Replace replace = factoryReplace.createReplace(ReplaceType.Generational);
        assertNotNull(replace, "GenerationalReplace should not be null");
        assertEquals("GenerationalReplace", replace.getClass().getSimpleName());
    }

    @Test
    public void testCreateSteadyStateReplace() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        Replace replace = factoryReplace.createReplace(ReplaceType.SteadyState);
        assertNotNull(replace, "SteadyStateReplace should not be null");
        assertEquals("SteadyStateReplace", replace.getClass().getSimpleName());
    }

    @Test
    public void testMultipleReplaceTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (ReplaceType type : ReplaceType.values()) {
            Replace replace = factoryReplace.createReplace(type);
            assertNotNull(replace, "Replace for type " + type + " should not be null");
            assertTrue(replace instanceof Replace);
        }
    }
}
