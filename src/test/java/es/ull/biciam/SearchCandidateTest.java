package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;

@DisplayName("SearchCandidate Tests")
public class SearchCandidateTest {

    private List<State> neighborhood;
    private State state1;
    private State state2;
    private State state3;

    @BeforeEach
    public void setUp() {
        neighborhood = new ArrayList<>();
        
        // Create states with different evaluations
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        state1 = new State(code1);
        ArrayList<Double> eval1 = new ArrayList<>();
        eval1.add(10.0);
        state1.setEvaluation(eval1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(2);
        state2 = new State(code2);
        ArrayList<Double> eval2 = new ArrayList<>();
        eval2.add(20.0);
        state2.setEvaluation(eval2);
        
        ArrayList<Object> code3 = new ArrayList<>();
        code3.add(3);
        state3 = new State(code3);
        ArrayList<Double> eval3 = new ArrayList<>();
        eval3.add(15.0);
        state3.setEvaluation(eval3);
    }

    @Test
    @DisplayName("Test neighborhood has states")
    public void testNeighborhoodNotEmpty() {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        assertFalse(neighborhood.isEmpty(), "Neighborhood should not be empty");
        assertEquals(3, neighborhood.size(), "Neighborhood should have 3 states");
    }

    @Test
    @DisplayName("Test single state in neighborhood")
    public void testSingleStateNeighborhood() {
        neighborhood.add(state1);
        assertEquals(1, neighborhood.size(), "Neighborhood should have 1 state");
    }

    @Test
    @DisplayName("Test neighborhood contains expected states")
    public void testNeighborhoodContainsStates() {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        assertTrue(neighborhood.contains(state1), "Neighborhood should contain state1");
        assertTrue(neighborhood.contains(state2), "Neighborhood should contain state2");
        assertTrue(neighborhood.contains(state3), "Neighborhood should contain state3");
    }

    @Test
    @DisplayName("Test state evaluation values")
    public void testStateEvaluations() {
        assertEquals(10.0, state1.getEvaluation().get(0));
        assertEquals(20.0, state2.getEvaluation().get(0));
        assertEquals(15.0, state3.getEvaluation().get(0));
    }

    @Test
    @DisplayName("Test finding maximum evaluation")
    public void testMaxEvaluation() {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        double maxEval = neighborhood.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .max()
            .orElse(0.0);
        
        assertEquals(20.0, maxEval, "Maximum evaluation should be 20.0");
    }

    @Test
    @DisplayName("Test finding minimum evaluation")
    public void testMinEvaluation() {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        double minEval = neighborhood.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .min()
            .orElse(0.0);
        
        assertEquals(10.0, minEval, "Minimum evaluation should be 10.0");
    }

    @Test
    @DisplayName("Test neighborhood filtering")
    public void testNeighborhoodFiltering() {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        List<State> filtered = neighborhood.stream()
            .filter(s -> s.getEvaluation().get(0) > 12.0)
            .toList();
        
        assertEquals(2, filtered.size(), "Filtered list should have 2 states");
        assertTrue(filtered.contains(state2));
        assertTrue(filtered.contains(state3));
    }
}
