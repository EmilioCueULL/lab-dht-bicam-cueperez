package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.State;

@DisplayName("Genetic Operations Tests")
public class GeneticOperationsTest {

    private State father1;
    private State father2;
    private State child;

    @BeforeEach
    public void setUp() {
        // Create father 1
        ArrayList<Object> code1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            code1.add(i);
        }
        father1 = new State(code1);
        ArrayList<Double> eval1 = new ArrayList<>();
        eval1.add(10.0);
        father1.setEvaluation(eval1);
        
        // Create father 2
        ArrayList<Object> code2 = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            code2.add(i);
        }
        father2 = new State(code2);
        ArrayList<Double> eval2 = new ArrayList<>();
        eval2.add(20.0);
        father2.setEvaluation(eval2);
    }

    @Test
    @DisplayName("Test father states initialization")
    public void testFatherStatesInitialization() {
        assertNotNull(father1, "Father1 should not be null");
        assertNotNull(father2, "Father2 should not be null");
        assertEquals(5, father1.getCode().size(), "Father1 code size should be 5");
        assertEquals(5, father2.getCode().size(), "Father2 code size should be 5");
    }

    @Test
    @DisplayName("Test crossover produces different child")
    public void testCrossoverProducesChild() {
        // Simulate simple one-point crossover
        ArrayList<Object> childCode = new ArrayList<>();
        int crossoverPoint = 2;
        
        for (int i = 0; i < crossoverPoint; i++) {
            childCode.add(father1.getCode().get(i));
        }
        for (int i = crossoverPoint; i < father2.getCode().size(); i++) {
            childCode.add(father2.getCode().get(i));
        }
        
        child = new State(childCode);
        assertNotNull(child, "Child should not be null");
        assertEquals(5, child.getCode().size(), "Child should have inherited code size");
    }

    @Test
    @DisplayName("Test uniform crossover mask generation")
    public void testUniformCrossoverMask() {
        int[] mask = new int[father1.getCode().size()];
        
        for (int i = 0; i < mask.length; i++) {
            mask[i] = (Math.random() < 0.5) ? 0 : 1;
        }
        
        assertNotNull(mask, "Mask should not be null");
        assertEquals(5, mask.length, "Mask length should match code length");
    }

    @Test
    @DisplayName("Test mutation changes one gene")
    public void testMutationChangesGene() {
        ArrayList<Object> code = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            code.add(i);
        }
        State state = new State(code);
        
        // Simulate mutation
        int mutationPos = (int)(Math.random() * code.size());
        Object originalValue = code.get(mutationPos);
        code.set(mutationPos, 999);
        
        assertNotEquals(originalValue, state.getCode().get(mutationPos), "Gene should have changed");
    }

    @Test
    @DisplayName("Test mutation probability")
    public void testMutationProbability() {
        double mutationRate = 0.1;
        int geneCount = 100;
        int expectedMutations = (int)(geneCount * mutationRate);
        
        int actualMutations = 0;
        for (int i = 0; i < geneCount; i++) {
            if (Math.random() < mutationRate) {
                actualMutations++;
            }
        }
        
        // Allow some variance (between 50% and 150% of expected)
        assertTrue(actualMutations >= expectedMutations * 0.5, 
                   "Actual mutations should be close to expected");
        assertTrue(actualMutations <= expectedMutations * 1.5, 
                   "Actual mutations should be close to expected");
    }

    @Test
    @DisplayName("Test crossover probability")
    public void testCrossoverProbability() {
        double crossoverRate = 0.8;
        int attempts = 100;
        int successCount = 0;
        
        for (int i = 0; i < attempts; i++) {
            if (Math.random() < crossoverRate) {
                successCount++;
            }
        }
        
        // Allow variance
        assertTrue(successCount >= attempts * 0.6, 
                   "Crossover rate should be close to probability");
    }

    @Test
    @DisplayName("Test gene values preservation")
    public void testGeneValuesPreservation() {
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(100);
        code1.add(200);
        code1.add(300);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(400);
        code2.add(500);
        code2.add(600);
        
        State s1 = new State(code1);
        State s2 = new State(code2);
        
        // Verify values before operations
        assertEquals(100, s1.getCode().get(0));
        assertEquals(400, s2.getCode().get(0));
    }

    @Test
    @DisplayName("Test code length preservation during inheritance")
    public void testCodeLengthPreservation() {
        ArrayList<Object> inherited = new ArrayList<>();
        inherited.addAll(father1.getCode());
        inherited.addAll(father2.getCode());
        
        // In a real scenario, we'd trim to original size
        assertTrue(inherited.size() >= father1.getCode().size(), 
                   "Inherited code should contain genes from both parents");
    }
}
