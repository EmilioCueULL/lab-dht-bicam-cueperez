package es.ull.biciam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import evolutionary_algorithms.complement.CrossoverType;
import evolutionary_algorithms.complement.MutationType;
import evolutionary_algorithms.complement.SelectionType;
import evolutionary_algorithms.complement.ReplaceType;

public class EvolutionaryAlgorithmEnumsTest {

    @Test
    public void testCrossoverTypeValues() {
        CrossoverType[] types = CrossoverType.values();
        assertTrue(types.length > 0, "CrossoverType should have values");
        assertTrue(contains(types, CrossoverType.OnePointCrossover));
        assertTrue(contains(types, CrossoverType.UniformCrossover));
    }

    @Test
    public void testMutationTypeValues() {
        MutationType[] types = MutationType.values();
        assertTrue(types.length > 0, "MutationType should have values");
        assertTrue(contains(types, MutationType.OnePointMutation));
        assertTrue(contains(types, MutationType.TowPointsMutation));
        assertTrue(contains(types, MutationType.UniformMutation));
    }

    @Test
    public void testSelectionTypeValues() {
        SelectionType[] types = SelectionType.values();
        assertTrue(types.length > 0, "SelectionType should have values");
        assertTrue(contains(types, SelectionType.Truncation));
        assertTrue(contains(types, SelectionType.Roulette));
    }

    @Test
    public void testReplaceTypeValues() {
        ReplaceType[] types = ReplaceType.values();
        assertTrue(types.length > 0, "ReplaceType should have values");
        assertTrue(contains(types, ReplaceType.Generational));
        assertTrue(contains(types, ReplaceType.SteadyState));
    }

    @Test
    public void testCrossoverTypeToString() {
        assertNotNull(CrossoverType.OnePointCrossover.toString());
        assertTrue(CrossoverType.OnePointCrossover.toString().contains("Crossover"));
    }

    @Test
    public void testMutationTypeToString() {
        assertNotNull(MutationType.OnePointMutation.toString());
        assertTrue(MutationType.OnePointMutation.toString().contains("Mutation"));
    }

    private <T extends Enum<T>> boolean contains(T[] values, T target) {
        for (T value : values) {
            if (value.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
