package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;

@DisplayName("Edge Cases and Boundary Tests")
public class EdgeCaseTest {

    private State state;

    @BeforeEach
    public void setUp() {
        state = new State();
    }

    @Test
    @DisplayName("Test empty state code")
    public void testEmptyStateCode() {
        ArrayList<Object> emptyCode = new ArrayList<>();
        State emptyState = new State(emptyCode);
        assertTrue(emptyState.getCode().isEmpty(), "State code should be empty");
    }

    @Test
    @DisplayName("Test single gene state")
    public void testSingleGeneState() {
        ArrayList<Object> singleCode = new ArrayList<>();
        singleCode.add(1);
        State singleState = new State(singleCode);
        assertEquals(1, singleState.getCode().size(), "State should have 1 gene");
    }

    @Test
    @DisplayName("Test large population")
    public void testLargePopulation() {
        List<State> largePopulation = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            largePopulation.add(new State(code));
        }
        assertEquals(1000, largePopulation.size(), "Large population size should be 1000");
    }

    @Test
    @DisplayName("Test zero evaluation")
    public void testZeroEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(0.0);
        state.setEvaluation(evaluation);
        assertEquals(0.0, state.getEvaluation().get(0), "Evaluation can be zero");
    }

    @Test
    @DisplayName("Test negative evaluation")
    public void testNegativeEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(-100.0);
        state.setEvaluation(evaluation);
        assertEquals(-100.0, state.getEvaluation().get(0), "Evaluation can be negative");
    }

    @Test
    @DisplayName("Test very large evaluation")
    public void testVeryLargeEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(Double.MAX_VALUE);
        state.setEvaluation(evaluation);
        assertEquals(Double.MAX_VALUE, state.getEvaluation().get(0), 
                     "Should handle very large values");
    }

    @Test
    @DisplayName("Test distance with single different gene")
    public void testDistanceSingleDifferentGene() {
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        code1.add(2);
        code1.add(3);
        State s1 = new State(code1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        code2.add(99);
        State s2 = new State(code2);
        
        assertEquals(1.0, s1.Distance(s2), "Distance should be 1");
    }

    @Test
    @DisplayName("Test maximum number assignment")
    public void testMaximumNumberAssignment() {
        state.setNumber(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, state.getNumber(), 
                     "Should handle maximum integer");
    }

    @Test
    @DisplayName("Test multiple evaluation objectives")
    public void testMultipleEvaluationObjectives() {
        ArrayList<Double> evaluation = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            evaluation.add(Math.random() * 100);
        }
        state.setEvaluation(evaluation);
        assertEquals(100, state.getEvaluation().size(), 
                     "Should handle 100 objectives");
    }

    @Test
    @DisplayName("Test null value in code")
    public void testNullValueInCode() {
        ArrayList<Object> code = new ArrayList<>();
        code.add(1);
        code.add(null);
        code.add(3);
        State stateWithNull = new State(code);
        assertEquals(3, stateWithNull.getCode().size(), "Code should accept null values");
        assertNull(stateWithNull.getCode().get(1), "Second element should be null");
    }

    @Test
    @DisplayName("Test state comparison with identical codes")
    public void testStateComparisonIdenticalCodes() {
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        code1.add(2);
        State s1 = new State(code1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        State s2 = new State(code2);
        
        assertTrue(s1.Comparator(s2), "States with identical codes should be equal");
    }

    @Test
    @DisplayName("Test population with zero size")
    public void testEmptyPopulation() {
        List<State> emptyPopulation = new ArrayList<>();
        assertTrue(emptyPopulation.isEmpty(), "Empty population should be empty");
        assertEquals(0, emptyPopulation.size(), "Empty population size should be 0");
    }

    @Test
    @DisplayName("Test fractional evaluation")
    public void testFractionalEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(3.14159265);
        state.setEvaluation(evaluation);
        assertEquals(3.14159265, state.getEvaluation().get(0), 0.00000001, 
                     "Should handle fractional values");
    }
}
