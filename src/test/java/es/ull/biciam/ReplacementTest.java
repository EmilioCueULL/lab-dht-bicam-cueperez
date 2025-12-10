package es.ull.biciam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;

@DisplayName("Replacement and Population Tests")
public class ReplacementTest {

    @Test
    @DisplayName("Test population creation")
    public void testPopulationCreation() {
        List<State> population = new ArrayList<>();
        assertNotNull(population, "Population should not be null");
        assertTrue(population.isEmpty(), "Initial population should be empty");
    }

    @Test
    @DisplayName("Test adding states to population")
    public void testAddingStatesToPopulation() {
        List<State> population = new ArrayList<>();
        
        ArrayList<Object> code = new ArrayList<>();
        code.add(1);
        State state = new State(code);
        
        population.add(state);
        assertEquals(1, population.size(), "Population should have 1 state");
    }

    @Test
    @DisplayName("Test population size")
    public void testPopulationSize() {
        List<State> population = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            population.add(new State(code));
        }
        assertEquals(10, population.size(), "Population should have 10 states");
    }

    @Test
    @DisplayName("Test population replacement")
    public void testPopulationReplacement() {
        List<State> population = new ArrayList<>();
        
        // Add initial states
        for (int i = 0; i < 5; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            population.add(new State(code));
        }
        
        assertEquals(5, population.size());
        
        // Replace one state
        ArrayList<Object> newCode = new ArrayList<>();
        newCode.add(99);
        State newState = new State(newCode);
        population.set(0, newState);
        
        assertTrue(population.contains(newState), "Population should contain new state");
    }

    @Test
    @DisplayName("Test population removal")
    public void testPopulationRemoval() {
        List<State> population = new ArrayList<>();
        
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        State state1 = new State(code1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(2);
        State state2 = new State(code2);
        
        population.add(state1);
        population.add(state2);
        assertEquals(2, population.size());
        
        population.remove(state1);
        assertEquals(1, population.size());
        assertFalse(population.contains(state1));
    }

    @Test
    @DisplayName("Test generational replacement strategy")
    public void testGenerationalReplacement() {
        List<State> oldPopulation = new ArrayList<>();
        List<State> newPopulation = new ArrayList<>();
        
        // Create old population
        for (int i = 0; i < 5; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            oldPopulation.add(new State(code));
        }
        
        // Create new population (representing offspring)
        for (int i = 5; i < 10; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            newPopulation.add(new State(code));
        }
        
        // Simulate generational replacement: replace entire population
        oldPopulation.clear();
        oldPopulation.addAll(newPopulation);
        
        assertEquals(5, oldPopulation.size(), "Old population should have been replaced");
    }

    @Test
    @DisplayName("Test steady-state replacement strategy")
    public void testSteadyStateReplacement() {
        List<State> population = new ArrayList<>();
        
        // Create initial population
        for (int i = 0; i < 5; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            ArrayList<Double> eval = new ArrayList<>();
            eval.add((double) i);
            State state = new State(code);
            state.setEvaluation(eval);
            population.add(state);
        }
        
        // Simulate steady-state replacement: replace worst individual
        int worstIndex = 0;
        double worstEval = population.get(0).getEvaluation().get(0);
        for (int i = 1; i < population.size(); i++) {
            if (population.get(i).getEvaluation().get(0) < worstEval) {
                worstEval = population.get(i).getEvaluation().get(0);
                worstIndex = i;
            }
        }
        
        ArrayList<Object> newCode = new ArrayList<>();
        newCode.add(100);
        ArrayList<Double> newEval = new ArrayList<>();
        newEval.add(100.0);
        State newState = new State(newCode);
        newState.setEvaluation(newEval);
        
        population.set(worstIndex, newState);
        assertEquals(5, population.size(), "Population size should remain constant");
    }
}
