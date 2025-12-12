package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EvolutionStrategiesTest {

    @Test
    public void instantiate() {
        EvolutionStrategies e = new EvolutionStrategies();
        assertNotNull(e);
    }
}
