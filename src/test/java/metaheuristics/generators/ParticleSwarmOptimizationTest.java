package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParticleSwarmOptimizationTest {

    @Test
    public void instantiate() {
        ParticleSwarmOptimization p = new ParticleSwarmOptimization();
        assertNotNull(p);
    }
}
