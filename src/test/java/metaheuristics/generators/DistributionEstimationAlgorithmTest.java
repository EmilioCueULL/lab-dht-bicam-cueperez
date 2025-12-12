package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DistributionEstimationAlgorithmTest {

    @Test
    public void instantiate() {
        DistributionEstimationAlgorithm d = new DistributionEstimationAlgorithm();
        assertNotNull(d);
    }
}
