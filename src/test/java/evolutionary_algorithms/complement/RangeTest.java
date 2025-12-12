package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RangeTest {

    @Test
    public void dataIsClonedOnSetAndGet() {
        Probability p = new Probability();
        p.setKey("k");
        p.setValue("v");
        p.setProbability(0.2f);

        Range r = new Range();
        r.setMax(10f);
        r.setMin(1f);
        r.setData(p);

        Probability fromRange = r.getData();
        assertNotNull(fromRange);
        assertNotSame(p, fromRange);
        assertEquals("k", fromRange.getKey());

        // Changing original should not change Range's stored data
        p.setKey("changed");
        assertEquals("k", r.getData().getKey());
    }
}
