package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import evolutionary_algorithms.complement.FatherSelection;
import evolutionary_algorithms.complement.SelectionType;
import factory_method.FactoryFatherSelection;

public class FactoryFatherSelectionTest {

    private FactoryFatherSelection factoryFatherSelection;

    @BeforeEach
    public void setUp() {
        factoryFatherSelection = new FactoryFatherSelection();
    }

    @Test
    public void testCreateTruncationSelection() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        FatherSelection selection = factoryFatherSelection.createSelectFather(SelectionType.Truncation);
        assertNotNull(selection, "TruncationSelection should not be null");
        assertEquals("TruncationSelection", selection.getClass().getSimpleName());
    }

    @Test
    public void testCreateRouletteSelection() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        FatherSelection selection = factoryFatherSelection.createSelectFather(SelectionType.Roulette);
        assertNotNull(selection, "RouletteSelection should not be null");
        assertEquals("RouletteSelection", selection.getClass().getSimpleName());
    }

    @Test
    public void testMultipleSelectionTypes() throws IllegalArgumentException, SecurityException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        for (SelectionType type : SelectionType.values()) {
            FatherSelection selection = factoryFatherSelection.createSelectFather(type);
            assertNotNull(selection, "Selection for type " + type + " should not be null");
            assertTrue(selection instanceof FatherSelection);
        }
    }
}
