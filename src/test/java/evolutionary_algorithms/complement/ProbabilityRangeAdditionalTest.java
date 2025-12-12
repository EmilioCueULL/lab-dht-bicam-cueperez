package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProbabilityRangeAdditionalTest {

    @Test
    public void probabilityDefaults() {
        Probability p = new Probability();
        assertEquals(0.0f, p.getProbability());
        assertNull(p.getKey());
        assertNull(p.getValue());
    }

    @Test
    public void rangeBounds() {
        Range r = new Range();
        r.setMin(-1f);
        r.setMax(5f);
        assertEquals(-1f, r.getMin());
        assertEquals(5f, r.getMax());
    }
}
