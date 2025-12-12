package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiobjectiveHillClimbingRestartTest {

    @Test
    public void instantiate() {
        MultiobjectiveHillClimbingRestart m = new MultiobjectiveHillClimbingRestart();
        assertNotNull(m);
    }
}
