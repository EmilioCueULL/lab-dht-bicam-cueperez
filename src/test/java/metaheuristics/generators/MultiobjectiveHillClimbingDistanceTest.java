package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiobjectiveHillClimbingDistanceTest {

    @Test
    public void instantiate() {
        MultiobjectiveHillClimbingDistance m = new MultiobjectiveHillClimbingDistance();
        assertNotNull(m);
    }
}
