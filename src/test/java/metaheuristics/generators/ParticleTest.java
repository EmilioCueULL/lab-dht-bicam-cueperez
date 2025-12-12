package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParticleTest {

    @Test
    public void instantiate() {
        Particle p = new Particle();
        assertNotNull(p);
    }
}
