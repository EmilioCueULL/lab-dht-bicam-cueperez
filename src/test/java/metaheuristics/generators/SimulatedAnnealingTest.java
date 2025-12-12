package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimulatedAnnealingTest {

    @Test
    public void instantiate() {
        SimulatedAnnealing s = new SimulatedAnnealing();
        assertNotNull(s);
    }
}
