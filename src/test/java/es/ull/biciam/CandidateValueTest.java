package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.State;
import metaheuristics.generators.GeneratorType;

public class CandidateValueTest {

    private State candidateState;
    private State currentState;
    private ArrayList<Object> candidateCode;
    private ArrayList<Object> currentCode;

    @BeforeEach
    public void setUp() {
        // Initialize candidate state
        candidateCode = new ArrayList<>();
        candidateCode.add(10);
        candidateCode.add(20);
        candidateCode.add(30);
        candidateState = new State(candidateCode);
        
        // Initialize current state
        currentCode = new ArrayList<>();
        currentCode.add(1);
        currentCode.add(2);
        currentCode.add(3);
        currentState = new State(currentCode);
        
        // Set evaluations
        ArrayList<Double> candidateEval = new ArrayList<>();
        candidateEval.add(100.0);
        candidateState.setEvaluation(candidateEval);
        
        ArrayList<Double> currentEval = new ArrayList<>();
        currentEval.add(50.0);
        currentState.setEvaluation(currentEval);
    }

    @Test
    @DisplayName("Test candidate state initialization")
    public void testCandidateStateInitialization() {
        assertNotNull(candidateState, "Candidate state should not be null");
        assertEquals(3, candidateState.getCode().size(), "Candidate code should have 3 elements");
    }

    @Test
    @DisplayName("Test current state initialization")
    public void testCurrentStateInitialization() {
        assertNotNull(currentState, "Current state should not be null");
        assertEquals(3, currentState.getCode().size(), "Current code should have 3 elements");
    }

    @Test
    @DisplayName("Test candidate evaluation")
    public void testCandidateEvaluation() {
        assertNotNull(candidateState.getEvaluation(), "Candidate evaluation should not be null");
        assertEquals(100.0, candidateState.getEvaluation().get(0), "Candidate evaluation should be 100.0");
    }

    @Test
    @DisplayName("Test current state evaluation")
    public void testCurrentStateEvaluation() {
        assertNotNull(currentState.getEvaluation(), "Current evaluation should not be null");
        assertEquals(50.0, currentState.getEvaluation().get(0), "Current evaluation should be 50.0");
    }

    @Test
    @DisplayName("Test states are different")
    public void testStatesDifferent() {
        assertFalse(candidateState.Comparator(currentState), "States should not be equal");
    }

    @Test
    @DisplayName("Test distance calculation between states")
    public void testDistance() {
        double distance = candidateState.Distance(currentState);
        assertEquals(3.0, distance, "Distance should be 3");
    }

    @Test
    @DisplayName("Test type generator assignment")
    public void testTypeGeneratorAssignment() {
        candidateState.setTypeGenerator(GeneratorType.GeneticAlgorithm);
        assertEquals(GeneratorType.GeneticAlgorithm, candidateState.getTypeGenerator());
    }

    @Test
    @DisplayName("Test number assignment")
    public void testNumberAssignment() {
        candidateState.setNumber(42);
        assertEquals(42, candidateState.getNumber());
    }
}
