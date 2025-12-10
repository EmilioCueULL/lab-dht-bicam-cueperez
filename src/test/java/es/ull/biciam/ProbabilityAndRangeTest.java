package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import evolutionary_algorithms.complement.Probability;
import evolutionary_algorithms.complement.Range;

public class ProbabilityAndRangeTest {

    private Probability probability;
    private Range range;

    @BeforeEach
    public void setUp() {
        probability = new Probability();
        range = new Range();
    }

    @Test
    public void testProbabilitySetAndGetKey() {
        probability.setKey("key1");
        assertEquals("key1", probability.getKey());
    }

    @Test
    public void testProbabilitySetAndGetValue() {
        probability.setValue(100);
        assertEquals(100, probability.getValue());
    }

    @Test
    public void testProbabilitySetAndGetProbability() {
        probability.setProbability(0.5f);
        assertEquals(0.5f, probability.getProbability());
    }

    @Test
    public void testProbabilityMultipleValues() {
        probability.setKey("mutation");
        probability.setValue(50);
        probability.setProbability(0.75f);
        
        assertEquals("mutation", probability.getKey());
        assertEquals(50, probability.getValue());
        assertEquals(0.75f, probability.getProbability());
    }

    @Test
    public void testRangeSetAndGetMax() {
        range.setMax(100.0f);
        assertEquals(100.0f, range.getMax());
    }

    @Test
    public void testRangeSetAndGetMin() {
        range.setMin(10.0f);
        assertEquals(10.0f, range.getMin());
    }

    @Test
    public void testRangeSetAndGetData() {
        Probability prob = new Probability();
        prob.setProbability(0.5f);
        range.setData(prob);
        assertNotNull(range.getData());
        assertEquals(0.5f, range.getData().getProbability());
    }

    @Test
    public void testRangeMultipleOperations() {
        range.setMin(0.1f);
        range.setMax(0.9f);
        
        Probability prob = new Probability();
        prob.setKey("rate");
        prob.setValue(75);
        prob.setProbability(0.5f);
        range.setData(prob);
        
        assertEquals(0.1f, range.getMin());
        assertEquals(0.9f, range.getMax());
        assertEquals("rate", range.getData().getKey());
        assertEquals(75, range.getData().getValue());
    }

    @Test
    public void testProbabilityWithNullValue() {
        probability.setValue(null);
        assertNull(probability.getValue());
    }

    @Test
    public void testRangeWithNullData() {
        range.setData(null);
        assertNull(range.getData());
    }

    @Test
    public void testProbabilityPrecision() {
        float value = 0.333333f;
        probability.setProbability(value);
        assertEquals(value, probability.getProbability(), 0.0001f);
    }

    @Test
    public void testRangeMinMaxRelationship() {
        range.setMin(50.0f);
        range.setMax(100.0f);
        assertTrue(range.getMax() > range.getMin());
    }
}
