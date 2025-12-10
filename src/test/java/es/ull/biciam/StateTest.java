package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.State;
import metaheuristics.generators.GeneratorType;

public class StateTest {

    private State state;
    private ArrayList<Object> code;

    @BeforeEach
    public void setUp() {
        code = new ArrayList<>();
        code.add(1);
        code.add(2);
        code.add(3);
        state = new State(code);
    }

    @Test
    public void testStateConstructorWithCode() {
        assertNotNull(state, "State should not be null");
        assertEquals(3, state.getCode().size(), "Code size should be 3");
    }

    @Test
    public void testStateDefaultConstructor() {
        State defaultState = new State();
        assertNotNull(defaultState, "State should not be null");
        assertNotNull(defaultState.getCode(), "Code should not be null");
    }

    @Test
    public void testStateConstructorWithState() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(5.0);
        state.setEvaluation(evaluation);
        state.setNumber(10);
        state.setTypeGenerator(GeneratorType.GeneticAlgorithm);

        State newState = new State(state);
        assertEquals(state.getCode().size(), newState.getCode().size());
        assertEquals(state.getNumber(), newState.getNumber());
    }

    @Test
    public void testSetAndGetCode() {
        ArrayList<Object> newCode = new ArrayList<>();
        newCode.add(4);
        newCode.add(5);
        state.setCode(newCode);
        assertEquals(2, state.getCode().size());
        assertEquals(4, state.getCode().get(0));
    }

    @Test
    public void testSetAndGetEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(7.5);
        evaluation.add(8.5);
        state.setEvaluation(evaluation);
        assertNotNull(state.getEvaluation());
        assertEquals(2, state.getEvaluation().size());
        assertEquals(7.5, state.getEvaluation().get(0));
    }

    @Test
    public void testSetAndGetNumber() {
        state.setNumber(42);
        assertEquals(42, state.getNumber());
    }

    @Test
    public void testSetAndGetTypeGenerator() {
        state.setTypeGenerator(GeneratorType.ParticleSwarmOptimization);
        assertEquals(GeneratorType.ParticleSwarmOptimization, state.getTypeGenerator());
    }

    @Test
    public void testComparator() {
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        code2.add(3);
        State state2 = new State(code2);
        assertTrue(state.Comparator(state2), "States with same code should be equal");
    }

    @Test
    public void testComparatorFalse() {
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        code2.add(4);
        State state2 = new State(code2);
        assertFalse(state.Comparator(state2), "States with different code should not be equal");
    }

    @Test
    public void testDistance() {
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(5);
        code2.add(3);
        State state2 = new State(code2);
        double distance = state.Distance(state2);
        assertEquals(1.0, distance, "Distance should be 1");
    }

    @Test
    public void testDistanceSame() {
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        code2.add(3);
        State state2 = new State(code2);
        double distance = state.Distance(state2);
        assertEquals(0.0, distance, "Distance should be 0");
    }

    @Test
    public void testDistanceAll() {
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(4);
        code2.add(5);
        code2.add(6);
        State state2 = new State(code2);
        double distance = state.Distance(state2);
        assertEquals(3.0, distance, "Distance should be 3");
    }

    @Test
    public void testClone() {
        State cloned = state.clone();
        assertEquals(state, cloned);
    }

    @Test
    public void testGetCopy() {
        Object copy = state.getCopy();
        assertTrue(copy instanceof State);
        State copiedState = (State) copy;
        assertEquals(state.getCode().size(), copiedState.getCode().size());
    }
}
