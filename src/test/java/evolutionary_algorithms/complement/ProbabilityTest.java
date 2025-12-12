package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProbabilityTest {

    @Test
    public void cloneAndAccessors() {
        Probability p = new Probability();
        p.setKey("k");
        p.setValue("v");
        p.setProbability(0.5f);

        Probability cloned = p.clone();

        assertNotSame(p, cloned);
        assertEquals(p.getKey(), cloned.getKey());
        assertEquals(p.getValue(), cloned.getValue());
        assertEquals(p.getProbability(), cloned.getProbability());

        // Modify original and ensure clone retains original values
        p.setKey("k2");
        p.setValue("v2");
        p.setProbability(0.9f);

        assertEquals("k", cloned.getKey());
        assertEquals("v", cloned.getValue());
        assertEquals(0.5f, cloned.getProbability());
    }
}
