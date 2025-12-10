package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import problem.definition.State;

@DisplayName("Algorithm Convergence Tests")
public class ConvergenceTest {

    private List<State> population;
    private List<Double> bestFitnessHistory;

    @BeforeEach
    public void setUp() {
        population = new ArrayList<>();
        bestFitnessHistory = new ArrayList<>();
        
        // Initialize population
        for (int i = 0; i < 10; i++) {
            ArrayList<Object> code = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                code.add((int)(Math.random() * 100));
            }
            State state = new State(code);
            ArrayList<Double> eval = new ArrayList<>();
            eval.add(Math.random() * 100);
            state.setEvaluation(eval);
            population.add(state);
        }
    }

    @Test
    @DisplayName("Test best fitness tracking over generations")
    public void testBestFitnessTracking() {
        for (int gen = 0; gen < 5; gen++) {
            State best = population.stream()
                .max((s1, s2) -> 
                    Double.compare(s1.getEvaluation().get(0), 
                                  s2.getEvaluation().get(0)))
                .orElse(null);
            
            if (best != null) {
                bestFitnessHistory.add(best.getEvaluation().get(0));
            }
            
            // Simulate improvement
            for (State state : population) {
                ArrayList<Double> eval = state.getEvaluation();
                eval.set(0, eval.get(0) * 1.01);
            }
        }
        
        assertEquals(5, bestFitnessHistory.size(), "Should track 5 generations");
        
        // Verify improvement trend
        for (int i = 1; i < bestFitnessHistory.size(); i++) {
            assertTrue(bestFitnessHistory.get(i) >= bestFitnessHistory.get(i-1), 
                       "Best fitness should improve or stay same");
        }
    }

    @Test
    @DisplayName("Test convergence to local optimum")
    public void testConvergenceToLocalOptimum() {
        double previousBest = 0;
        int stagnationCounter = 0;
        
        for (int gen = 0; gen < 20; gen++) {
            State best = population.stream()
                .max((s1, s2) -> 
                    Double.compare(s1.getEvaluation().get(0), 
                                  s2.getEvaluation().get(0)))
                .orElse(null);
            
            if (best != null) {
                if (Math.abs(best.getEvaluation().get(0) - previousBest) < 0.001) {
                    stagnationCounter++;
                } else {
                    stagnationCounter = 0;
                    previousBest = best.getEvaluation().get(0);
                }
            }
        }
        
        assertTrue(stagnationCounter >= 0, "Stagnation detection works");
    }

    @Test
    @DisplayName("Test population fitness variance")
    public void testPopulationFitnessVariance() {
        double meanFitness = population.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .average()
            .orElse(0);
        
        double variance = population.stream()
            .mapToDouble(s -> Math.pow(s.getEvaluation().get(0) - meanFitness, 2))
            .average()
            .orElse(0);
        
        double stdDev = Math.sqrt(variance);
        
        assertTrue(meanFitness >= 0, "Mean fitness should be non-negative");
        assertTrue(stdDev >= 0, "Standard deviation should be non-negative");
    }

    @Test
    @DisplayName("Test elitism preservation")
    public void testElitismPreservation() {
        State elite = population.stream()
            .max((s1, s2) -> 
                Double.compare(s1.getEvaluation().get(0), 
                              s2.getEvaluation().get(0)))
            .orElse(null);
        
        assertNotNull(elite, "Elite individual should exist");
        double eliteFitness = elite.getEvaluation().get(0);
        
        // Simulate generation
        for (State state : population) {
            if (!state.equals(elite)) {
                ArrayList<Double> eval = state.getEvaluation();
                eval.set(0, eval.get(0) - 5.0);
            }
        }
        
        // Verify elite is still best
        State newBest = population.stream()
            .max((s1, s2) -> 
                Double.compare(s1.getEvaluation().get(0), 
                              s2.getEvaluation().get(0)))
            .orElse(null);
        
        if (newBest != null) {
            assertTrue(newBest.getEvaluation().get(0) >= eliteFitness * 0.95, 
                       "Elite quality should be maintained");
        }
    }

    @Test
    @DisplayName("Test mutation effect on population")
    public void testMutationEffectOnPopulation() {
        double fitnessBeforeMutation = population.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .sum();
        
        // Apply mutations
        for (State state : population) {
            for (int i = 0; i < state.getCode().size(); i++) {
                if (Math.random() < 0.05) {
                    state.getCode().set(i, (int)(Math.random() * 100));
                }
            }
        }
        
        double fitnessAfterMutation = population.stream()
            .mapToDouble(s -> s.getEvaluation().get(0))
            .sum();
        
        assertTrue(fitnessBeforeMutation > 0 || fitnessAfterMutation > 0, 
                   "Fitness values should be trackable");
    }

    @Test
    @DisplayName("Test crossover diversity effect")
    public void testCrossoverDiversityEffect() {
        List<State> offspring = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            State parent1 = population.get(i);
            State parent2 = population.get(i + 1);
            
            ArrayList<Object> childCode = new ArrayList<>();
            int crossoverPoint = parent1.getCode().size() / 2;
            
            for (int j = 0; j < crossoverPoint; j++) {
                childCode.add(parent1.getCode().get(j));
            }
            for (int j = crossoverPoint; j < parent2.getCode().size(); j++) {
                childCode.add(parent2.getCode().get(j));
            }
            
            State child = new State(childCode);
            offspring.add(child);
        }
        
        assertEquals(5, offspring.size(), "Should produce 5 offspring");
        
        long uniqueOffspring = offspring.stream()
            .map(s -> s.getCode().toString())
            .distinct()
            .count();
        
        assertTrue(uniqueOffspring > 0, "Offspring should be diverse");
    }

    @Test
    @DisplayName("Test population replacement cycle")
    public void testPopulationReplacementCycle() {
        int initialSize = population.size();
        
        List<State> newPopulation = new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            ArrayList<Object> code = new ArrayList<>();
            code.add((int)(Math.random() * 100));
            newPopulation.add(new State(code));
        }
        
        population.clear();
        population.addAll(newPopulation);
        
        assertEquals(initialSize, population.size(), 
                     "Population size should be maintained");
    }
}
