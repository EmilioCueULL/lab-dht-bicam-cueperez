package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HillClimbingRestartTest {

    @Test
    public void instantiate() {
        HillClimbingRestart h = new HillClimbingRestart();
        assertNotNull(h);
    }
}
