package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LimitThresholdTest {

    @Test
    public void instantiate() {
        LimitThreshold l = new LimitThreshold();
        assertNotNull(l);
    }
}
