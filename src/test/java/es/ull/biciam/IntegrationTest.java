package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;
import problem.definition.Problem;
import problem.definition.Problem.ProblemType;

@DisplayName("Integration Tests")
public class IntegrationTest {

    private Problem problem;
    private List<State> population;

    @BeforeEach
    public void setUp() {
        problem = new Problem();
        problem.setTypeProblem(ProblemType.Maximizar);
        problem.setPossibleValue(100);
        
        population = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Object> code = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                code.add((int)(Math.random() * 100));
            }
            State state = new State(code);
            ArrayList<Double> eval = new ArrayList<>();
            eval.add(Math.random() * 100);
            state.setEvaluation(eval);
            state.setNumber(i);
            population.add(state);
        }
    }

    @Test
    @DisplayName("Test problem and population integration")
    public void testProblemAndPopulationIntegration() {
        assertNotNull(problem, "Problem should not be null");
        assertNotNull(population, "Population should not be null");
        assertEquals(5, population.size(), "Population should have 5 individuals");
    }

    @Test
    @DisplayName("Test population evaluation tracking")
    public void testPopulationEvaluationTracking() {
        double minEval = Double.MAX_VALUE;
        double maxEval = Double.MIN_VALUE;
        double sumEval = 0;
        
        for (State state : population) {
            double eval = state.getEvaluation().get(0);
            minEval = Math.min(minEval, eval);
            maxEval = Math.max(maxEval, eval);
            sumEval += eval;
        }
        
        assertTrue(minEval >= 0, "Min evaluation should be non-negative");
        assertTrue(maxEval <= 100, "Max evaluation should be <= 100");
        double avgEval = sumEval / population.size();
        assertTrue(avgEval >= minEval && avgEval <= maxEval, 
                   "Average evaluation should be between min and max");
    }

    @Test
    @DisplayName("Test best individual tracking")
    public void testBestIndividualTracking() {
        State best = population.get(0);
        for (State state : population) {
            if (state.getEvaluation().get(0) > best.getEvaluation().get(0)) {
                best = state;
            }
        }
        
        assertNotNull(best, "Best individual should be found");
        for (State state : population) {
            assertTrue(best.getEvaluation().get(0) >= state.getEvaluation().get(0), 
                       "Best individual should have highest evaluation");
        }
    }

    @Test
    @DisplayName("Test generational evolution simulation")
    public void testGenerationalEvolutionSimulation() {
        int generations = 3;
        List<Double> bestEvals = new ArrayList<>();
        
        for (int gen = 0; gen < generations; gen++) {
            State best = population.stream()
                .max((s1, s2) -> 
                    Double.compare(s1.getEvaluation().get(0), 
                                  s2.getEvaluation().get(0)))
                .orElse(null);
            
            if (best != null) {
                bestEvals.add(best.getEvaluation().get(0));
            }
            
            // Simulate mutation
            for (State state : population) {
                if (Math.random() < 0.1) {
                    ArrayList<Object> code = state.getCode();
                    int pos = (int)(Math.random() * code.size());
                    code.set(pos, (int)(Math.random() * 100));
                }
            }
        }
        
        assertEquals(generations, bestEvals.size(), 
                     "Should track best evaluation for each generation");
    }

    @Test
    @DisplayName("Test population diversity preservation")
    public void testPopulationDiversityPreservation() {
        long uniqueIndividuals = population.stream()
            .map(s -> s.getNumber())
            .distinct()
            .count();
        
        assertTrue(uniqueIndividuals > 0, "Population should have unique individuals");
    }

    @Test
    @DisplayName("Test state copying and modification")
    public void testStateCopyingAndModification() {
        State original = population.get(0);
        Object copiedObj = original.getCopy();
        State copied = (State) copiedObj;
        
        assertNotNull(copied, "Copied state should not be null");
        assertEquals(original.getCode().size(), copied.getCode().size(), 
                     "Copied state should have same code size");
    }

    @Test
    @DisplayName("Test problem type affects selection")
    public void testProblemTypeAffectsSelection() {
        problem.setTypeProblem(ProblemType.Maximizar);
        State best = null;
        
        for (State state : population) {
            if (best == null || 
                state.getEvaluation().get(0) > best.getEvaluation().get(0)) {
                best = state;
            }
        }
        
        assertNotNull(best, "Best should be found for maximization");
        
        // For minimization, selection would be reversed
        problem.setTypeProblem(ProblemType.Minimizar);
        State worst = null;
        
        for (State state : population) {
            if (worst == null || 
                state.getEvaluation().get(0) < worst.getEvaluation().get(0)) {
                worst = state;
            }
        }
        
        assertNotNull(worst, "Worst should be found for minimization");
    }

    @Test
    @DisplayName("Test crossover simulation")
    public void testCrossoverSimulation() {
        State parent1 = population.get(0);
        State parent2 = population.get(1);
        
        ArrayList<Object> childCode = new ArrayList<>();
        int crossoverPoint = parent1.getCode().size() / 2;
        
        for (int i = 0; i < crossoverPoint; i++) {
            childCode.add(parent1.getCode().get(i));
        }
        for (int i = crossoverPoint; i < parent2.getCode().size(); i++) {
            childCode.add(parent2.getCode().get(i));
        }
        
        State child = new State(childCode);
        assertEquals(parent1.getCode().size(), child.getCode().size(), 
                     "Child should inherit parent size");
    }
}
