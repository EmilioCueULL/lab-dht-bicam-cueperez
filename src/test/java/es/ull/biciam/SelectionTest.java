package es.ull.biciam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;

@DisplayName("Selection Tests")
public class SelectionTest {

    private List<State> population;

    @BeforeEach
    public void setUp() {
        population = new ArrayList<>();
        
        // Create population with different evaluations
        for (int i = 1; i <= 5; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add(i);
            State state = new State(code);
            ArrayList<Double> eval = new ArrayList<>();
            eval.add((double)(i * 10));
            state.setEvaluation(eval);
            population.add(state);
        }
    }

    @Test
    @DisplayName("Test population sorting by evaluation")
    public void testPopulationSorting() {
        // Sort by evaluation descending
        population.sort((s1, s2) -> 
            Double.compare(s2.getEvaluation().get(0), s1.getEvaluation().get(0)));
        
        assertEquals(50.0, population.get(0).getEvaluation().get(0), 
                     "Best individual should be first");
        assertEquals(10.0, population.get(population.size()-1).getEvaluation().get(0), 
                     "Worst individual should be last");
    }

    @Test
    @DisplayName("Test truncation selection")
    public void testTruncationSelection() {
        // Sort population
        population.sort((s1, s2) -> 
            Double.compare(s2.getEvaluation().get(0), s1.getEvaluation().get(0)));
        
        int truncationSize = 3;
        List<State> selected = population.subList(0, truncationSize);
        
        assertEquals(truncationSize, selected.size(), "Selected population size should be 3");
        for (State s : selected) {
            assertTrue(s.getEvaluation().get(0) >= 30.0, 
                       "Selected individuals should have high evaluations");
        }
    }

    @Test
    @DisplayName("Test roulette wheel selection probability")
    public void testRouletteWheelSelection() {
        // Calculate total fitness
        double totalFitness = 0;
        for (State s : population) {
            totalFitness += s.getEvaluation().get(0);
        }
        
        assertTrue(totalFitness > 0, "Total fitness should be positive");
        
        // Calculate probabilities
        for (State s : population) {
            double probability = s.getEvaluation().get(0) / totalFitness;
            assertTrue(probability > 0 && probability < 1, 
                       "Probability should be between 0 and 1");
        }
    }

    @Test
    @DisplayName("Test best individual selection")
    public void testBestIndividualSelection() {
        State best = population.stream()
            .max((s1, s2) -> 
                Double.compare(s1.getEvaluation().get(0), 
                              s2.getEvaluation().get(0)))
            .orElse(null);
        
        assertNotNull(best, "Best individual should exist");
        assertEquals(50.0, best.getEvaluation().get(0), "Best should have evaluation 50.0");
    }

    @Test
    @DisplayName("Test worst individual selection")
    public void testWorstIndividualSelection() {
        State worst = population.stream()
            .min((s1, s2) -> 
                Double.compare(s1.getEvaluation().get(0), 
                              s2.getEvaluation().get(0)))
            .orElse(null);
        
        assertNotNull(worst, "Worst individual should exist");
        assertEquals(10.0, worst.getEvaluation().get(0), "Worst should have evaluation 10.0");
    }

    @Test
    @DisplayName("Test average population fitness")
    public void testAveragePopulationFitness() {
        double totalFitness = population.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .sum();
        
        double averageFitness = totalFitness / population.size();
        assertEquals(30.0, averageFitness, 0.01, "Average fitness should be 30.0");
    }

    @Test
    @DisplayName("Test population diversity")
    public void testPopulationDiversity() {
        long uniqueEvaluations = population.stream()
            .map(s -> s.getEvaluation().get(0))
            .distinct()
            .count();
        
        assertTrue(uniqueEvaluations > 1, "Population should have diverse solutions");
    }
}
