package metaheurictics.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StrategySmokeTest {

    @Test
    public void basicGettersSetters() {
        Strategy.destroyExecute();
        Strategy s = Strategy.getStrategy();
        assertNotNull(s);
        s.setCountCurrent(42);
        assertEquals(42, s.getCountCurrent());
        s.setThreshold(0.123);
        assertEquals(0.123, s.getThreshold());
        Strategy.destroyExecute();
    }
}
