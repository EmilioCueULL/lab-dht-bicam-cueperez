package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiCaseSimulatedAnnealingTest {

    @Test
    public void instantiate() {
        MultiCaseSimulatedAnnealing m = new MultiCaseSimulatedAnnealing();
        assertNotNull(m);
    }
}
