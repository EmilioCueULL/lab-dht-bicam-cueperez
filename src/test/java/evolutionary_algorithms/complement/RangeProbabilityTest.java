package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RangeProbabilityTest {

    @Test
    public void testProbabilityCloneDistinct() {
        Probability p = new Probability();
        p.setKey("k");
        p.setValue("v");
        p.setProbability(0.42f);

        Probability c = p.clone();
        assertNotSame(p, c);
        assertEquals(p.getKey(), c.getKey());
        assertEquals(p.getValue(), c.getValue());
        assertEquals(p.getProbability(), c.getProbability());
    }

    @Test
    public void testRangeSetDataClonesInput() {
        Probability p = new Probability();
        p.setProbability(0.1f);

        Range r = new Range();
        r.setData(p);

        // modify original after setting - Range should have a clone
        p.setProbability(0.9f);

        Probability fromRange = r.getData();
        assertNotNull(fromRange);
        assertEquals(0.1f, fromRange.getProbability());
    }

    @Test
    public void testRangeGetDataReturnsClone() {
        Probability p = new Probability();
        p.setProbability(0.33f);

        Range r = new Range();
        r.setData(p);

        Probability a = r.getData();
        a.setProbability(0.66f);

        // getting again should return original value (clone inside Range unaffected)
        Probability b = r.getData();
        assertEquals(0.33f, b.getProbability());
    }

    @Test
    public void testRangeNullHandlingAndMinMax() {
        Range r = new Range();
        r.setData(null);
        assertNull(r.getData());

        r.setMin(-5.5f);
        r.setMax(10.0f);
        assertEquals(-5.5f, r.getMin());
        assertEquals(10.0f, r.getMax());
    }

    @Test
    public void testEnumsExist() {
        assertEquals(MutationType.OnePointMutation, MutationType.valueOf("OnePointMutation"));
        assertEquals(DistributionType.Univariate, DistributionType.valueOf("Univariate"));
    }
}
