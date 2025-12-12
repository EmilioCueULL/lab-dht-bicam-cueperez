package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiobjectiveStochasticHillClimbingTest {

    @Test
    public void instantiate() {
        MultiobjectiveStochasticHillClimbing m = new MultiobjectiveStochasticHillClimbing();
        assertNotNull(m);
    }
}
